package src.it.unibs.ingsw.gestvisit;
import it.unibs.fp.libjava.*;
import java.util.*;
class Luogo {

    private String nome;
    private String descrizione;
    private String collocazioneGeografica;
    private HashMap<String, List<String>> volontari;


    public Luogo(String nome, String descrizione, String collocazioneGeografica,  HashMap<String, List<String>> volontari) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.collocazioneGeografica = collocazioneGeografica;
        this.volontari = volontari;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCollocazioneGeografica() {
        return collocazioneGeografica;
    }
    

  /* public void aggiungiTipoVisita(String tipo) {
        tipiVisita.add(tipo);
    } */

/*    public void assegnaVolontario(String volontario) {
        volontari.add(volontario);
    }*/

    public static Luogo creaLuogo(HashMap<String, List<String>> tipiVisita,  HashMap<String, List<String>> volontari){
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del luogo: ");
        String descrizione = InputDati.leggiStringaNonVuota("inserire una descrizione: ");
        String collocazioneGeografica = InputDati.leggiStringaNonVuota("dove è situato questo luogo? ");
        return new Luogo(nome, descrizione, collocazioneGeografica, volontari);
    }

    public static Luogo creaLuogoUtente(String nome, String descrizione, String collocazioneGeografica, HashMap<String, List<String>> volontari) {
        return new Luogo(nome, descrizione, collocazioneGeografica, volontari);
    }

    public void assegnaVolontario(String volontario, List<String> orari) {
        volontari.put(volontario, orari);
    }

    public static String toString(List<Luogo> luoghi) {
        StringBuilder sb = new StringBuilder();
        for (Luogo luogo : luoghi) {
            sb.append(luogo.getNome()).append("\n");
        }
        return sb.toString();
    }

}
