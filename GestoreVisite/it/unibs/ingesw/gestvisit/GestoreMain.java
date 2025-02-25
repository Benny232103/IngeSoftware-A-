    import java.util.*;
    public class GestoreMain {
    public static void main(String[] args) {
        
        Configuratore config = new Configuratore("admin", "password123");
        GestoreVisite gestore = new GestoreVisite();
        System.out.println("buongiorno, per poter accedere inserire");
	    Configuratore configuratoreUtente = Configuratore.creaConfiguratore(); 
	        
	       
	     if (configuratoreUtente.login(config.getUsername(),config.getPassword())) {
	        System.out.println("Accesso effettuato con successo!");
	        System.out.println("si prega di modificare il nome utente e la password");
	        configuratoreUtente = configuratoreUtente.creaConfiguratore();
             
            gestore.aggiungiLuogo("Museo Storico");
            gestore.modificaMaxPersone(15);
            gestore.aggiungiDataNonDisponibile("2025-06-10");
            gestore.mostraLuoghi();
        } else {
            System.out.println("Accesso negato.");
        }
    }
}
