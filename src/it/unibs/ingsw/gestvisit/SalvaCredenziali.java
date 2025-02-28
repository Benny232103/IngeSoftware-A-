package src.it.unibs.ingsw.gestvisit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalvaCredenziali {
    private List<Utente> utenti = new ArrayList<>();

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public void salvaCredenziali() {
        File file = new File("credenziali.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Utente utente : utenti) {
                writer.write(utente.getClass().getSimpleName() + ":" + utente.toString());
                writer.newLine();
            }
            System.out.println("Credenziali salvate.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file.");
            e.printStackTrace();
        }
    }

    public void caricaCredenziali() {
        File file = new File("credenziali.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] credenziali = scanner.nextLine().split(":");
                if (credenziali.length != 3) {
                    System.out.println("Formato credenziali non valido: " + String.join(":", credenziali));
                    continue;
                }
                String tipoUtente = credenziali[0];
                String nomeUtente = credenziali[1];
                String password = credenziali[2];

                switch (tipoUtente) {
                    case "Configuratore":
                        utenti.add(new Configuratore(nomeUtente, password));
                        break;
                    case "Volontario":
                        utenti.add(new Volontario(nomeUtente, password));
                        break;
                    /* 
                    case "UtentePubblico":
                        utenti.add(new UtentePubblico(nomeUtente, password));
                        break;
                    */
                    default:
                        System.out.println("Tipo utente non riconosciuto: " + tipoUtente);
                        break;
                }
            }
            System.out.println("Credenziali caricate.");
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file.");
            e.printStackTrace();
        }
    }
}
