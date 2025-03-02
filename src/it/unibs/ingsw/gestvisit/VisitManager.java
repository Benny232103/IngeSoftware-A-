package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.*;
import java.util.*;
public class VisitManager {

    private static final String[] SELECT = {"Add Luogo", "Add Volontario", "Show Luoghi", "Show Volontari",  "Exit"};
    private List<Luogo> luoghi = new ArrayList<>();
    private List<Volontario> volontari = new ArrayList<>();
    private List<Configuratore> configuratori = new ArrayList<>();
    

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
                    }else if (chosed == 2) {
                        System.out.println("U choose Volontario");
                        addVolontario();
                    }else if (chosed == 3) {
                        showLuoghi();
                    }else if (chosed == 4) {
                        showVolontari();
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
            String nomeUtente = email;
            String password = InputDati.leggiStringaNonVuota("inserire la password: ");
            Configuratore configuratore = new Configuratore(nome, cognome, email, nomeUtente, password);
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

        

}
