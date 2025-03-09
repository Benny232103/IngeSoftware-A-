package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class VisitManager {

    private static final String[] SELECT = {"Add Luogo", "Add Volontario", "Show Luoghi", "Show Volontari"};
    private List<Luogo> luoghi = new ArrayList<>();
    private List<Volontario> volontari = new ArrayList<>();
    private List<Configuratore> configuratori = new ArrayList<>();
    private List<TemporaryCredential> temporaryCredentials = new ArrayList<>();
    private CredentialManager credentialManager = new CredentialManager();
    private boolean credenzialiModificate = false;

    public void menu() {
        Utilita.popolaLuoghi(luoghi);
        Utilita.popolaVolontari(volontari);
        boolean goOn = true;
        do {
            MyMenu menu = new MyMenu("What do you want to do?\n", SELECT);
            int chosed = menu.scegli();

            if (chosed != 0) {
                if (chosed == 1) {
                    System.out.println("U choose Luogo");
                    addLuogo();
                } else if (chosed == 2) {
                    System.out.println("U choose Volontario");
                    addVolontario();
                } else if (chosed == 3) {
                    showLuoghi();
                } else if (chosed == 4) {
                    showVolontari();
                } else if (chosed == 0) {
                    goOn = false;
                }
            } else
                goOn = false;
        } while (goOn);
    }

    public void menuStart() {
        Utilita.popolaLuoghi(luoghi);
        Utilita.popolaVolontari(volontari);
        boolean goOn = true;
        do {
            MyMenu menu = new MyMenu("New or not?\n", SELECT);
            int chosed = menu.scegli();

            if (chosed != 0) {
                if (chosed == 1) {
                    System.out.println("Welcome");
                    if (autenticaConfiguratore()) {
                        System.out.println("Configuratore Autenticato con successo");
                        menu();
                    } else if (autenticaTemporaneo()) {
                        System.out.println("Accesso Temporaneo");
                        modificaCredenzialiConfiguratore();
                        menu();
                    } else if (!autenticaConfiguratore() && !autenticaTemporaneo()) {
                        System.out.println("Accesso Negato");
                        
                    };
                } else if (chosed == 2) {
                    System.out.println("U choose Volontario");
                    addVolontario();
                } else if (chosed == 0) {
                    goOn = false;
                }
            } else
                goOn = false;
        } while (goOn);
    }

    public void addLuogo() {
        HashMap<String, List<String>> tipiVisita = new HashMap<String, List<String>>();
        HashMap<String, List<String>> volontari = new HashMap<String, List<String>>();
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del luogo: ");
        String descrizione = InputDati.leggiStringaNonVuota("inserire una descrizione: ");
        String collocazioneGeografica = InputDati.leggiStringaNonVuota("dove è situato questo luogo? ");
        Luogo luogo = new Luogo(nome, descrizione, collocazioneGeografica, tipiVisita, volontari);
        luoghi.add(luogo);
    }

    public void addVolontario() {
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del volontario: ");
        String cognome = InputDati.leggiStringaNonVuota("inserire il cognome del volontario: ");
        String email = InputDati.leggiStringaNonVuota("inserire l'email del volontario: ");
        String nomeUtente = email;
        String password = InputDati.leggiStringaNonVuota("inserire la password: ");
        Volontario volontario = new Volontario(nome, cognome, email, nomeUtente, password);
        volontari.add(volontario);
    }

    public void addConfiguratore() {
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del configuratore: ");
        String cognome = InputDati.leggiStringaNonVuota("inserire il cognome del configuratore: ");
        String email = InputDati.leggiStringaNonVuota("inserire l'email del configuratore: ");
        String password = InputDati.leggiStringaNonVuota("inserire la password: ");
        Configuratore configuratore = new Configuratore(nome, cognome, email, password);
        configuratori.add(configuratore);
    }

    public void showLuoghi() {
        for (Luogo luogo : luoghi) {
            System.out.println(luogo);
        }
    }

    public void showVolontari() {
        for (Volontario volontario : volontari) {
            System.out.println(volontario);
        }
    }

    public boolean autenticaConfiguratore() {
        String nomeUtente = InputDati.leggiStringaNonVuota("Inserisci il nome utente (email): ");
        String password = InputDati.leggiStringaNonVuota("Inserisci la password: ");

        for (Configuratore configuratore : configuratori) {
            if (configuratore.getEmail().equals(nomeUtente) && configuratore.getPassword().equals(password)) {
                credenzialiModificate = true;
                return true;
            }
        }
        return false;
    }

    public boolean autenticaTemporaneo() {
        String nomeUtente = InputDati.leggiStringaNonVuota("Inserisci il nome utente: ");
        String password = InputDati.leggiStringaNonVuota("Inserisci la password: ");

        for (TemporaryCredential tempCred : temporaryCredentials) {
            if (tempCred.getUsername().equals(nomeUtente) && tempCred.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void modificaCredenzialiConfiguratore() {
        credentialManager.saveNewConfigCredential(configuratori);
    }

    public void leggiCredenzialiConfiguratore() {
        credentialManager.caricaCredenzialiTemporanee(temporaryCredentials);
        credentialManager.caricaCredenzialiConfiguratore(configuratori);
    }

    public boolean isCredenzialiModificate() {
        return credenzialiModificate;
    }
}
