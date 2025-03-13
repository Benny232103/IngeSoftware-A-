package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class VisitManager {

    private static final String[] SELECT = {"Add Luogo", "Add Volontario", "Show Luoghi", "Show Volontari", "Assegna Visita", "Show Visite"};
    private ArrayList<Luogo> luoghi = new ArrayList<>();
    private ArrayList<Volontario> volontari = new ArrayList<>();
    private ArrayList<Configuratore> configuratori = new ArrayList<>();
    private ArrayList<TemporaryCredential> temporaryCredentials = new ArrayList<>();
    private CredentialManager credentialManager = new CredentialManager();
    private HashMap<Luogo, HashMap<String, List<String>>> mappaVisite = new HashMap<>();
    private ArrayList<GestVisite> tipiVisita = new ArrayList<>();
    private boolean credenzialiModificate = false;

    public void menu() {
        Utilita.popolaLuoghi(luoghi);
        Utilita.popolaVolontari(volontari);
        Utilita.creazioneTipiVisite(tipiVisita);
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
                } else if (chosed == 5) {
                    assegnaVisita();
                } else if (chosed == 6) {
                    showVisite();
                } else if (chosed == 7) {
                    modifycaNumeroMaxPersonePerVisita();
                }else if (chosed == 0) {
                    goOn = false;
                }
            } else
                goOn = false;
        } while (goOn);
    }

    public void addLuogo() {
        //HashMap<String, List<String>> tipiVisita = new HashMap<String, List<String>>();
        //HashMap<String, List<String>> volontari = new HashMap<String, List<String>>();
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del luogo: ");
        String descrizione = InputDati.leggiStringaNonVuota("inserire una descrizione: ");
        String collocazioneGeografica = InputDati.leggiStringaNonVuota("dove è situato questo luogo? ");
        Luogo luogo = new Luogo(nome, descrizione, collocazioneGeografica);
        luoghi.add(luogo);
        
        Utilita.salvaLuoghi(luogo);
    }

    public void addVolontario() {
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del volontario: ");
        String cognome = InputDati.leggiStringaNonVuota("inserire il cognome del volontario: ");
        String email = InputDati.leggiStringaNonVuota("inserire l'email del volontario: ");
        String nomeUtente = email;
        String password = InputDati.leggiStringaNonVuota("inserire la password: ");
        Volontario volontario = new Volontario(nome, cognome, email, nomeUtente, password);
        volontari.add(volontario);

        Utilita.salvaVolontari(volontario);
    }

    public void showLuoghi() {
        Utilita.stampaLuoghi(luoghi);
    }

    public void showVolontari() {
        Utilita.stampaVolontari(volontari);
    }

    public void assegnaVisita() {
        LocalDate data = LocalDate.now();
        
        // Stampa l'elenco dei luoghi
        System.out.println("Elenco dei luoghi:");
        for (int i = 0; i < luoghi.size(); i++) {
            System.out.println((i + 1) + ". " + luoghi.get(i).getNome());
        }

        // Stampa l'elenco dei volontari
        System.out.println("Elenco dei volontari:");
        for (int i = 0; i < volontari.size(); i++) {
            System.out.println((i + 1) + ". " + volontari.get(i).getNome() + " (" + volontari.get(i).getEmail() + ")");
        }

        // Chiedi all'utente di selezionare un luogo e un volontario
        int indiceLuogo = InputDati.leggiIntero("Seleziona il numero del luogo: ", 1, luoghi.size()) - 1;
        int indiceVolontario = InputDati.leggiIntero("Seleziona il numero del volontario: ", 1, volontari.size()) - 1;
        String tipoVisita = InputDati.leggiStringaNonVuota("Inserisci il tipo di visita: ");

        Luogo luogo = luoghi.get(indiceLuogo);
        Volontario volontario = volontari.get(indiceVolontario);

        // Aggiungere il luogo alla mappa se non esiste già
        mappaVisite.putIfAbsent(luogo, new HashMap<>());

        // Aggiungere il tipo di visita alla mappa se non esiste già
        mappaVisite.get(luogo).putIfAbsent(tipoVisita, new ArrayList<>());

        // Aggiungere il volontario alla lista dei volontari per il tipo di visita
        mappaVisite.get(luogo).get(tipoVisita).add(volontario.getNome() + " (" + volontario.getEmail() + ")");

        Utilita.stampaVisite(mappaVisite);
    }
    public void showVisite() {
        Utilita.stampaVisite(mappaVisite);
    }

    public void modifycaNumeroMaxPersonePerVisita() {
        tipiVisita.forEach(visita -> {
            visita.setMaxPersonePerVisita(InputDati.leggiIntero("Inserisci il numero massimo di persone per visita: ", 2, 10));
        });
    }

    public boolean autenticaConfiguratore() {
        String nomeUtente = InputDati.leggiStringaNonVuota("Inserisci il nome utente (email): ");
        String password = InputDati.leggiStringaNonVuota("Inserisci la password: ");

        boolean[] esito = credentialManager.verificaCredenziali(nomeUtente, password, configuratori, temporaryCredentials);
        if (esito[0]) {
            if (esito[1]) {
                modificaCredenzialiConfiguratore();
            }
            return true;
        } else {
            System.out.println("Credenziali non valide.");
            return false;
        }
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
