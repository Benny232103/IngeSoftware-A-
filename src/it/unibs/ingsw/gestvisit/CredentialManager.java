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
    // private List<Utente> utenti = new ArrayList<>();
    // public List<Volontario> volontari = new ArrayList<>();
    private static final String CREDENZIALI_FILE_PATH_CONFIGURATORI_INIZ = "src/it/unibs/ingsw/gestvisit/credenzialiInizialiConf.txt";
    private static final String CREDENZIALI_FILE_PATH_CONFIG_PERS = "src/it/unibs/ingsw/gestvisit/credenzialiConfiguratoriPers.txt";
    private static final String CREDENZIALI_FILE_PATH_GENERALS = "src/it/unibs/ingsw/gestvisit/credenziali.txt";

    // public void aggiungiUtente(Utente utente) {
    //     utenti.add(utente);
    // }

    // public void salvaCredenziali() {
    //     File file = new File(CREDENZIALI_FILE_PATH_GENERALS);

    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
    //         for (Utente utente : utenti) {
    //             String tipoUtente = "";
    //             if (utente instanceof Configuratore) {
    //                 tipoUtente = "Configuratore";
    //                 Configuratore config = (Configuratore) utente;
    //                 writer.write(tipoUtente + "," + config.getPassword() + "," + config.getEmail());
    //             } else if (utente instanceof Volontario) {
    //                 tipoUtente = "Volontario";
    //                 Volontario vol = (Volontario) utente;
    //                 writer.write(tipoUtente + "," + vol.getPassword() + "," + vol.getEmail());
    //             } else {
    //                 tipoUtente = "UtentePubblico";
    //             }
    //         }
    //         System.out.println("Credenziali salvate.");
    //     } catch (IOException e) {
    //         System.out.println("Errore durante la scrittura del file.");
    //         e.printStackTrace();
    //     }
    // }

    // public void caricaCredenziali() {
    //     File file = new File(CREDENZIALI_FILE_PATH_GENERALS);

    //     try (Scanner scanner = new Scanner(file)) {
    //         while (scanner.hasNextLine()) {
    //             String[] credenziali = scanner.nextLine().split(",");
    //             if (credenziali.length != 6) {
    //                 System.out.println("Formato credenziali non valido: " + String.join(":", credenziali));
    //                 continue;
    //             }
    //             String tipoUtente = credenziali[0];
    //             String nome = credenziali[1];
    //             String cognome = credenziali[2];
    //             String email = credenziali[3];
    //             String password = credenziali[4];
    //             String tipiDiVisite = credenziali[5];
    //             switch (tipoUtente) {
    //                 case "Volontario":
    //                     volontari.add(new Volontario(nome, cognome, email, password, tipiDiVisite));
    //                     break;
                     
    //                 case "Utente":
    //                     utenti.add(new Utente(nome, cognome, nomeUtente, password));
    //                     break;
                    
                    
    //                 default:
    //                     System.out.println("Tipo utente non riconosciuto: " + tipoUtente);
    //                     break;
    //             }
    //         }
    //         System.out.println("Credenziali caricate.");
    //     } catch (IOException e) {
    //         System.out.println("Errore durante la lettura del file.");
    //         e.printStackTrace();
    //     }
    // }

    public void caricaCredenzialiConfiguratore(List<Configuratore> configuratori) {
        File file = new File(CREDENZIALI_FILE_PATH_CONFIG_PERS);

        if (!file.exists()) {
            System.out.println("File " + CREDENZIALI_FILE_PATH_CONFIG_PERS + " non trovato.");
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

    public void caricaCredenzialiTemporanee(List<TemporaryCredential> temporaryCredentials) {
        File file = new File(CREDENZIALI_FILE_PATH_CONFIGURATORI_INIZ);

        if (!file.exists()) {
            System.out.println("File " + CREDENZIALI_FILE_PATH_CONFIGURATORI_INIZ + " non trovato.");
            System.out.println("Percorso assoluto: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isTemporarySection = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Credenziali temporanee config:")) {
                    isTemporarySection = true;
                    continue;
                } else if (line.startsWith("Credenziali personali Configuratori:")) {
                    isTemporarySection = false;
                    continue;
                }

                String[] credenziali = line.split(",");
                if (isTemporarySection) {
                    if (credenziali.length == 2) {
                        String username = credenziali[0].trim();
                        String password = credenziali[1].trim();
                        temporaryCredentials.add(new TemporaryCredential(username, password));
                    }
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
        String name = InputDati.leggiStringaNonVuota("Inserisci il nome: ");
        String surname = InputDati.leggiStringaNonVuota("Inserisci il cognome: ");
        
        Configuratore configuratore1 = configuratori.get(0); 
        configuratore1.setEmail(newNomeUtente);
        configuratore1.setPassword(newPassword);
        configuratore1.setNome(name);
        configuratore1.setCognome(surname);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENZIALI_FILE_PATH_CONFIG_PERS, true))) {
            writer.write("Configuratore," + configuratore1.getNome() + "," + configuratore1.getCognome() + "," + configuratore1.getEmail() + "," + configuratore1.getPassword());
            writer.newLine();
            System.out.println("Nuove credenziali salvate.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file.");
            e.printStackTrace();
        }
    }

    public boolean[] verificaCredenziali(String username, String password, ArrayList<Configuratore> configuratori, ArrayList<TemporaryCredential> temporaryCredentials) {
        boolean[] esito = new boolean[2]; // esito[0] = autenticato, esito[1] = credenzialiTemporanee

        for (TemporaryCredential tempCred : temporaryCredentials) {
            if (tempCred.getUsername().equals(username) && tempCred.getPassword().equals(password)) {
                esito[0] = true; // Autenticato
                esito[1] = true; // Credenziali temporanee
                return esito;
            }
        }

        for (Configuratore configuratore : configuratori) {
            if (configuratore.getEmail().equals(username) && configuratore.getPassword().equals(password)) {
                esito[0] = true; // Autenticato
                esito[1] = false; // Credenziali personali
                return esito;
            }
        }

        esito[0] = false; // Non autenticato
        esito[1] = false; // Non rilevante
        return esito;
    }
}
