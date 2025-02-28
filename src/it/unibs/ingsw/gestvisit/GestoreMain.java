package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.util.*;
public class GestoreMain {
    /**
     * @param args
     */
    public static void main(String[] args) {

        SalvaCredenziali salvaCredenziali = new SalvaCredenziali();
        salvaCredenziali.aggiungiUtente(new Configuratore("config1", "pass1"));
        salvaCredenziali.aggiungiUtente(new Volontario("volontario1", "pass2"));
        //salvaCredenziali.aggiungiUtente(new UtentePubblico("utente1", "pass3"));
        salvaCredenziali.salvaCredenziali();
        salvaCredenziali.caricaCredenziali();
        HashMap<String, List<String>> tipiVisita = new HashMap<String, List<String>>();
        HashMap<String, List<String>> volontari = new HashMap<String, List<String>>();

        GestVisite gestore = new GestVisite();
        System.out.println("buongiorno, per poter accedere inserire");
        Configuratore configuratore = (Configuratore) Utente.creaUtente();
            
        if () {
            System.out.println("Accesso effettuato con successo!");
            System.out.println("si prega di modificare il nome utente e la password");
            Configuratore configuratore1 = (Configuratore) Utente.creaUtente();
            String ambitoTerritoriale = InputDati.leggiStringaNonVuota("si prega di indicare l'ambito territoriale di competenza: ");
            for(int i = 0; i < 3; i++){
                Luogo.creaLuogo(tipiVisita, volontari);
            }
            gestore.aggiungiLuogo("Museo Storico");
            gestore.modificaMaxPersone(15);
            gestore.aggiungiDataNonDisponibile("2025-06-10");
            gestore.mostraLuoghi();
        } else {
            System.out.println("Accesso negato.");
        }
    }
}
