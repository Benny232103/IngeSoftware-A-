package src.it.unibs.ingsw.gestvisit;
import it.unibs.fp.libjava.*;
import java.util.*;
class Luogo {

    private String nome;
    private String descrizione;
    private String collocazioneGeografica;
    private HashMap<String, List<String>> tipiVisita;
    private HashMap<String, List<String>> volontari;


    public Luogo(String nome, String descrizione, String collocazioneGeografica,  HashMap<String, List<String>> tipiVisita,  HashMap<String, List<String>> volontari) {
        this.nome = nome;
        this.tipiVisita = tipiVisita;
        this.descrizione = descrizione;
        this.collocazioneGeografica = collocazioneGeografica;
        this.volontari = volontari;
    }

  /* public void aggiungiTipoVisita(String tipo) {
        tipiVisita.add(tipo);
    } */

/*    public void assegnaVolontario(String volontario) {
        volontari.add(volontario);
    }*/

    @Override
    public String toString() {
        return "Luogo: " + nome + ", Tipi di visita: " + tipiVisita + ", Volontari: " + volontari;
    }

    public static Luogo creaLuogo(HashMap<String, List<String>> tipiVisita,  HashMap<String, List<String>> volontari){
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del luogo: ");
        String descrizione = InputDati.leggiStringaNonVuota("inserire una descrizione: ");
        String collocazioneGeografica = InputDati.leggiStringaNonVuota("dove è situato questo luogo? ");
        return new Luogo(nome, descrizione, collocazioneGeografica, tipiVisita, volontari);
    }

     public static Luogo creaLuogoUtente( String nome,  String descrizione,  String collocazioneGeografica, HashMap<String, List<String>> tipiVisita,  HashMap<String, List<String>> volontari){
        return new Luogo(nome, descrizione, collocazioneGeografica, tipiVisita, volontari);
    }
}
