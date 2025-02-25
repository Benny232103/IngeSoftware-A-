import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WhatsAppProtocol implements Runnable {
	private static HashMap<String, WhatsAppProtocol> clientMap = new HashMap<>();
	private static HashMap<String, Consumer<WAPEvent>> commandMap = new HashMap<>();
	
	static {
		commandMap.put("TIME", e -> e.sender.sendMsg(e.sender, LocalDateTime.now().toString()));
		commandMap.put("USER_LIST", e -> e.sender.listClient());
		commandMap.put("SEND_ALL",  e -> e.sender.sendToAll(e.sender, e.getLastParameter()));
		commandMap.put("SEND", 
				e -> e.sender.sendTo(e.sender, e.getParameter(1), e.getLastParameter())); 
		
	}
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private String name = null;
	
	
	public WhatsAppProtocol(Socket client) {
		this.client = client;
	}
	
	public void run() {
		
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			
			login();
			
			String request;
			while((request = in.readLine()) != null) {
				WAPEvent e = new WAPEvent(this, request);
				if(e.getCommand() != null) {
					System.out.printf("request: %s [%s]", request, e.getCommand());
				
					Consumer<WAPEvent> command = commandMap.get(e.getCommand());
					
					if(command == null) {
						sendMsg(this, "comando non riconosciuto");
					} else {
						command.accept(e);
					}
					
				}
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			// chiusura degli stream....
		}
		
	}

	private void login() throws IOException {
		System.out.println("Client connesso... attesa nome utente...");
		
		sendMsg(this, "Benvenuto sul server WAP PAJC");
		
		while(name == null) {
			sendMsg(this, "Inserisci il tuo nome:");
			name = in.readLine();
			
			if(name.length() < 3) {
				sendMsg(this, "ERRORE: il tuo nome deve avere almeno tre caratteri!");
				name = null;
			}
			
			if(clientMap.containsKey(name)) {
				sendMsg(this, "ERRORE: utente già presente");
				name = null;
			}
		}
		
		synchronized (clientMap) {
			clientMap.put(name, this);	
		}

		out.printf("Benvenuto: %s\n", name);
	}

	public String getName() {
		return name;
	}
	
	public void listClient() {
		String elencoClient = clientMap.keySet().stream().collect(Collectors.joining(", "));
		
		sendMsg(this, elencoClient);
	}
	
	
	public void sendToAll(WhatsAppProtocol sender, String msg) {
		for(WhatsAppProtocol p: clientMap.values()) {
			if(p != this) {
				p.sendMsg(sender, msg);
			}
		}
	}
	
	public void sendTo(WhatsAppProtocol sender, String destName, String msg) {
		WhatsAppProtocol dest = clientMap.get(destName);
		if(dest == null) {
			sender.sendMsg(sender, "Errore: utente non trovato");
		} else {
			dest.sendMsg(sender, msg);
		}
	}
	
	public void sendMsg(WhatsAppProtocol sender, String msg) {
		String senderName = sender != null ? sender.name : "*";
		out.printf("[%s] %s\n", senderName, msg);
		//out.flush();
	}
}














