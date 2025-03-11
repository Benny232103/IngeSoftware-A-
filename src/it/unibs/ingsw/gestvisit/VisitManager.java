package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class VisitManager {

    private static final String[] SELECT = {"Add Luogo", "Add Volontario", "Show Luoghi", "Show Volontari", "Assegna Visita", "Show Visite"};
    private List<Luogo> luoghi = new ArrayList<>();
    private List<Volontario> volontari = new ArrayList<>();
    private List<Configuratore> configuratori = new ArrayList<>();
    private List<TemporaryCredential> temporaryCredentials = new ArrayList<>();
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
        for (Luogo luogo : luoghi) {
            luogo.toString();
        }
    }

    public void showVolontari() {
        for (Volontario volontario : volontari) {
            volontario.toString();
        }
    }

    public void assegnaVisita() {
        LocalDate data = LocalDate.now();
        
        System.out.printf("%s%n", Luogo.toString(luoghi));
        System.out.printf("%s%n", Volontario.toString(volontari));

        String nomeLuogo = InputDati.leggiStringaNonVuota("Inserisci il nome del luogo: ");
        String nomeVolontario = InputDati.leggiStringaNonVuota("Inserisci il nome del volontario: ");
        String tipoVisita = InputDati.leggiStringaNonVuota("Inserisci il tipo di visita: ");

        Luogo luogo = null;
        Volontario volontario = null;
        for (Luogo l : luoghi) {
            if (l.getNome().equals(nomeLuogo)) {
                luogo = l;
                break;
            }
        }
        for (Volontario v : volontari) {
            if (v.getNome().equals(nomeVolontario)) {
                volontario = v;
                break;
            }
        }
        // for (GestVisite visita : tipiVisita) {
        //     if (visita.getTipo().equals(tipoVisita)) {
        //         if (visita.getMaxPersonePerVisita() == 0) {
        //             System.out.println("Numero massimo di persone per visita non impostato.");
        //             return;
        //         }
        //         break;
        //     }
        // }

        if (luogo == null || volontario == null) {
            System.out.println("Luogo o volontario non trovato.");
            return;
        }

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

        if(nomeUtente.equals("admin") && password.equals("admin")){
            modificaCredenzialiConfiguratore();
            return true;
        }else {
            for (Configuratore configuratore : configuratori ) {
                if (configuratore.getEmail().equals(nomeUtente) && configuratore.getPassword().equals(password)) {
                    return true;
                }else {
                    System.out.println("Credenziali non valide.");
                    return false;
                }
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
