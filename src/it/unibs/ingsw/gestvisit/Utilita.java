package src.it.unibs.ingsw.gestvisit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
                String tipiDiVisite = dati[4];
                Volontario volontario = new Volontario(nome, cognome, email, password, tipiDiVisite);
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

    public static void creazioneTipiVisite(HashMap<String, List<String>> tipiVisite, List<GestVisite> visites){
        List<Giorni> giornis = new List<Giorni>();
        giornis.add(Giorni.DOMENICA);
        giornis.add(Giorni.SABATO);
        giornis.add(Giorni.VENERDI);
        GestVisite visita = GestVisite.creaGestVisite("alla scoperta del castello Bonoris", "magnifica visita guidata all'interno del castello", "nel cortile del castello", "tutto l'anno", giornis, 18, 1, "biglietto acquistabile in loco");
        GestVisite visita3 = GestVisite.creaGestVisite("alla scoperta del castello Bonoris", "visita libera all'interno del castello", "nessun luogo", "tutto l'anno", giornis, 14, 2, "biglietto acquistabile in loco");
        GestVisite visita2 = GestVisite.creaGestVisite("alla scoperta della pinacoteca Pasinetti", "magnifica visita guidata all'interno della celebrissima pinacoteca monteclarense", "nell'atrio della pinacoteca", "tutto l'anno", giornis, 16, 2, "biglietto acquistabile in loco");
        visites.add(visita);
        visites.add(visita2);
        visites.add(visita3); 
    }

    public static void salvaLuoghi(Luogo luogo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENZIALI_FILE_PATH_LUOGHI))) {
            bw.write(luogo.getNome() + "," + luogo.getCollocazioneGeografica() + "," + luogo.getDescrizione());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
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