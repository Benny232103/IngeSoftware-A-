package src.it.unibs.ingsw.gestvisit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.unibs.fp.libjava.InputDati;

public class CredentialManager {
    private List<Utente> utenti = new ArrayList<>();
    public List<Volontario> volontari = new ArrayList<>();
    private static final String CREDENZIALI_FILE_PATH = "src/it/unibs/ingsw/gestvisit/credenzialiConfiguratori.txt";

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
                    writer.write(tipoUtente + "," + config.getPassword() + "," + config.getEmail());
                } else if (utente instanceof Volontario) {
                    tipoUtente = "Volontario";
                    Volontario vol = (Volontario) utente;
                    writer.write(tipoUtente + "," + vol.getPassword() + "," + vol.getEmail());
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
                String[] credenziali = scanner.nextLine().split(",");
                if (credenziali.length != 6) {
                    System.out.println("Formato credenziali non valido: " + String.join(":", credenziali));
                    continue;
                }
                String tipoUtente = credenziali[0];
                String nome = credenziali[1];
                String cognome = credenziali[2];
                String email = credenziali[3];
                String password = credenziali[4];
                switch (tipoUtente) {
                    case "Volontario":
                        volontari.add(new Volontario(nome, cognome, email, password));
                        break;
                    /* 
                    case "Utente":
                        utenti.add(new Utente(nome, cognome, nomeUtente, password));
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

    public void caricaCredenzialiConfiguratore(List<Configuratore> configuratori) {
        File file = new File(CREDENZIALI_FILE_PATH);

        if (!file.exists()) {
            System.out.println("File " + CREDENZIALI_FILE_PATH + " non trovato.");
            System.out.println("Percorso assoluto: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credenziali = line.split(",");
                if (credenziali.length == 5 && credenziali[0].equals("Configuratore")) {
                    String nome = credenziali[1].trim();
                    String cognome = credenziali[2].trim();
                    String email = credenziali[3].trim();
                    String password = credenziali[4].trim();
                    Configuratore configuratore = new Configuratore(nome, cognome, email, password);
                    configuratori.add(configuratore);
                }
            }
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file.");
            e.printStackTrace();
        }
    }

    public void saveNewConfigCredential(List<Configuratore> configuratori) {
        String newNomeUtente = InputDati.leggiStringaNonVuota("Inserisci il nuovo nome utente (email): ");
        String newPassword = InputDati.leggiStringaNonVuota("Inserisci la nuova password: ");
        
        Configuratore configuratore = configuratori.get(0); // Supponiamo che ci sia solo un configuratore
        configuratore.setEmail(newNomeUtente);
        configuratore.setPassword(newPassword);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENZIALI_FILE_PATH, false))) {
            writer.write("Configuratore," + configuratore.getNome() + "," + configuratore.getCognome() + "," + configuratore.getEmail() + "," + configuratore.getPassword());
            writer.newLine();
            System.out.println("Nuove credenziali salvate.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file.");
            e.printStackTrace();
        }
    }
}
