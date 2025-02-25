    import java.util.*;
    public class GestoreMain {
    public static void main(String[] args) {
        Configuratore config = new Configuratore("admin", "password123");
        GestoreVisite gestore = new GestoreVisite();

        if (config.login("admin", "password123")) {
            System.out.println("Accesso effettuato con successo!");
            gestore.aggiungiLuogo("Museo Storico");
            gestore.modificaMaxPersone(15);
            gestore.aggiungiDataNonDisponibile("2025-06-10");
            gestore.mostraLuoghi();
        } else {
            System.out.println("Accesso negato.");
        }
    }
}
