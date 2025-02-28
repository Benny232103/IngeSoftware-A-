package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.util.*;
public class GestoreMain {
  
    public static void main(String[] args) {

        SalvaCredenziali salvaCredenziali = new SalvaCredenziali();
        salvaCredenziali.aggiungiUtente(new Configuratore("config1", "pass1"));
        salvaCredenziali.aggiungiUtente(new Volontario("volontario1", "pass2"));
        String ambitoTerritoriale = "Montichiari";

        //salvaCredenziali.aggiungiUtente(new UtentePubblico("utente1", "pass3"));
        salvaCredenziali.salvaCredenziali();
        salvaCredenziali.caricaCredenziali();
        HashMap<String, List<String>> tipiVisita = new HashMap<String, List<String>>();
        HashMap<String, List<String>> volontari = new HashMap<String, List<String>>();
        ArrayList<Luogo> luoghi = new ArrayList<>();

        GestVisite gestore = new GestVisite();
        System.out.println("buongiorno, per poter accedere inserire");
        Configuratore configuratore = (Configuratore) Utente.creaUtente();
            
        if (configuratore.getNomeUtente().equals("config1") && configuratore.verificaPassword("pass1")) {
            System.out.println("Accesso effettuato con successo!");
            System.out.println("si prega di modificare il nome utente e la password");
            Configuratore configuratore1 = (Configuratore) Utente.creaUtente();
            salvaCredenziali.aggiungiUtente(configuratore1);
            salvaCredenziali.salvaCredenziali();
            Utilita.creazioneLuoghi(luoghi, volontari, tipiVisita);
           /* gestore.aggiungiLuogo("Museo Storico");
            gestore.modificaMaxPersone(15);
            gestore.aggiungiDataNonDisponibile("2025-06-10");
            gestore.mostraLuoghi(); */
        } else {
            System.out.println("Accesso negato.");
        }
    }
}
