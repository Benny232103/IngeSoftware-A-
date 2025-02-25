import java.util.ArrayList;

public class WAPEvent {
	WhatsAppProtocol sender;
	String command;
	ArrayList<String> parameters = new ArrayList<>();
	
	public WAPEvent(WhatsAppProtocol sender, String msg) {
		this.sender = sender;
		
		// fare il parsing del messaggio
		if(msg.startsWith("@")) {
			String[] tokens = msg.split("@");
			
			command = tokens[1].toUpperCase();
			
			for(int i=1; i<tokens.length; i++)
				parameters.add(tokens[i]);
		} else {
			command = null;
			parameters.add(msg);
		}
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getParameter(int indx) {
		return parameters.get(indx);
	}
	
	public String getLastParameter() {
		return parameters.get(parameters.size()-1);
	}
	

}
