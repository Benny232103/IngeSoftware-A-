import java.net.*;

public class WhatsAppServer {

	public static void main(String[] args) {
		
		System.out.println("Avvio del server...");
		
		try(
			ServerSocket server = new ServerSocket(1234);
		){
			System.out.println("Server avviato...");
			
			while(true) {
				System.out.println("Attesa client...");
				Socket client = server.accept();
				
				WhatsAppProtocol p = new WhatsAppProtocol(client);
				Thread t = new Thread(p);
				t.start();
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	ciao
	
}
