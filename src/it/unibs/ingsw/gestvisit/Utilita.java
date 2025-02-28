package src.it.unibs.ingsw.gestvisit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utilita {

    public static void creazioneLuoghi(ArrayList<Luogo> luoghi, HashMap<String, List<String>> volontari, HashMap<String, List<String>> tipiVisite){
        Luogo luogo1 = Luogo.creaLuogoUtente("alla scoperta del castello Bonoris", "una fantastica visita alla scoperta del bellissimo castello di montichiari: il luogo che rappresenta appieno questa favola cittadina", "Montichiari, piazza Santa Maria, 36", tipiVisite, volontari);
        Luogo luogo2 = Luogo.creaLuogoUtente("Pinacoteca Pasinetti: un luogo d'eccellenza per scoprire l'arte monteclarense", "una fantastica visita attraverso le varie epoche dell'arte monteclarense", "Montichiari, Via Trieste, 56", tipiVisite, volontari);
        luoghi.add(luogo1);
        luoghi.add(luogo2);
    }

    
    
}