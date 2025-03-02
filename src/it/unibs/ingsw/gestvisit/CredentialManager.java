package src.it.unibs.ingsw.gestvisit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CredentialManager {
    private List<Utente> utenti = new ArrayList<>();
    public List<Volontario> volontari = new ArrayList<>();
    public List<Configuratore> configuratori = new ArrayList<>();

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public void salvaCredenziali() {
        File file = new File("credenziali.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Utente utente : utenti) {
                String tipoUtente = "";
                if (utente instanceof Configuratore) {
                    tipoUtente = "Configuratore";
                    Configuratore config = (Configuratore) utente;
                    writer.write(tipoUtente + ":" + config.getNomeUtente() + ":" + config.getPassword() + ":" + config.getEmail());
                } else if (utente instanceof Volontario) {
                    tipoUtente = "Volontario";
                    Volontario vol = (Volontario) utente;
                    writer.write(tipoUtente + ":" + vol.getNomeUtente() + ":" + vol.getPassword() + ":" + vol.getEmail());
                } else {
                    tipoUtente = "UtentePubblico";
                }
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
                String nome = credenziali[1];
                String cognome = credenziali[2];
                String nomeUtente = credenziali[3];
                String password = credenziali[4];
                String email = credenziali[5];
                switch (tipoUtente) {
                    case "Configuratore":
                        configuratori.add(new Configuratore(nome, cognome, email, nomeUtente, password));
                        break;
                    case "Volontario":
                        volontari.add(new Volontario(nome, cognome, email, nomeUtente, password));
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
