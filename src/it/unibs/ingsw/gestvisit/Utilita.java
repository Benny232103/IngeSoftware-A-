package src.it.unibs.ingsw.gestvisit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utilita {
    private static final String CREDENZIALI_FILE_PATH_LUOGHI = "src/it/unibs/ingsw/gestvisit/luoghi.txt";
    private static final String CREDENZIALI_FILE_PATH_VOLONTARI = "src/it/unibs/ingsw/gestvisit/volontari.txt";

    public static void popolaLuoghi(List<Luogo> luoghi) {
        // Leggi i dati dei luoghi da un file (ad esempio, "luoghi.txt")
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENZIALI_FILE_PATH_LUOGHI))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dati = line.split(",");
                String nome = dati[0];
                String descrizione = dati[1];
                String collocazioneGeografica = dati[2];
                Luogo luogo = new Luogo(nome, descrizione, collocazioneGeografica, new HashMap<>(), new HashMap<>());
                luoghi.add(luogo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void popolaVolontari(List<Volontario> volontari) {
        // Leggi i dati dei volontari da un file (ad esempio, "volontari.txt")
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENZIALI_FILE_PATH_VOLONTARI))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dati = line.split(",");
                String nome = dati[0];
                String cognome = dati[1];
                String email = dati[2];
                String password = dati[3];
                Volontario volontario = new Volontario(nome, cognome, email, password);
                volontari.add(volontario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void creazioneLuoghi(ArrayList<Luogo> luoghi, HashMap<String, List<String>> volontari, HashMap<String, List<String>> tipiVisite){
        Luogo luogo1 = Luogo.creaLuogoUtente("alla scoperta del castello Bonoris", "una fantastica visita alla scoperta del bellissimo castello di montichiari: il luogo che rappresenta appieno questa favola cittadina", "Montichiari, piazza Santa Maria, 36", tipiVisite, volontari);
        Luogo luogo2 = Luogo.creaLuogoUtente("Pinacoteca Pasinetti: un luogo d'eccellenza per scoprire l'arte monteclarense", "una fantastica visita attraverso le varie epoche dell'arte monteclarense", "Montichiari, Via Trieste, 56", tipiVisite, volontari);
        luoghi.add(luogo1);
        luoghi.add(luogo2);
    }

    public static void creazioneVolontari(HashMap<String, List<String>> volontari){
        List<String> volontariLuogo1 = new ArrayList<>();
        volontariLuogo1.add("volontario1");
        volontariLuogo1.add("volontario2");
        volontari.put("alla scoperta del castello Bonoris", volontariLuogo1);

        List<String> volontariLuogo2 = new ArrayList<>();
        volontariLuogo2.add("volontario3");
        volontariLuogo2.add("volontario4");
        volontari.put("Pinacoteca Pasinetti: un luogo d'eccellenza per scoprire l'arte monteclarense", volontariLuogo2);
    }

    public static void creazioneTipiVisite(HashMap<String, List<String>> tipiVisite){
        List<String> tipiVisitaLuogo1 = new ArrayList<>();
        tipiVisitaLuogo1.add("visita guidata");
        tipiVisitaLuogo1.add("visita libera");
        tipiVisite.put("alla scoperta del castello Bonoris", tipiVisitaLuogo1);

        List<String> tipiVisitaLuogo2 = new ArrayList<>();
        tipiVisitaLuogo2.add("visita guidata");
        tipiVisitaLuogo2.add("visita libera");
        tipiVisite.put("Pinacoteca Pasinetti: un luogo d'eccellenza per scoprire l'arte monteclarense", tipiVisitaLuogo2);
    }
    /* 
    public static void creaCredeziali(CredentialManager salvaCredenziali){
        Configuratore configuratore1 = new Configuratore("Mario", "Rossi", "mario.rossi@gmail.com", "pass12");
        Configuratore configuratore2 = new Configuratore("Luca", "Bianchi",  "luca.bianchi@gmail.com", "pass123");
        salvaCredenziali.salvaCredenziali();
        salvaCredenziali.caricaCredenziali();
    }
    */
}