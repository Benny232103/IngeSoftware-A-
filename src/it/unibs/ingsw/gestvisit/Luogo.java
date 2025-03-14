package src.it.unibs.ingsw.gestvisit;
import it.unibs.fp.libjava.*;
import java.util.*;
class Luogo {

    private String nome;
    private String descrizione;
    private String collocazioneGeografica;
    private HashMap<String, List<String>> volontari;
    private HashMap<String, List<String>> tipiVisita; 


    public Luogo(String nome, String descrizione, String collocazioneGeografica) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.collocazioneGeografica = collocazioneGeografica;
        this.tipiVisita = new HashMap<>();
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

    public static Luogo creaLuogo(){
        String nome = InputDati.leggiStringaNonVuota("inserire il nome del luogo: ");
        String descrizione = InputDati.leggiStringaNonVuota("inserire una descrizione: ");
        String collocazioneGeografica = InputDati.leggiStringaNonVuota("dove è situato questo luogo? ");
        return new Luogo(nome, descrizione, collocazioneGeografica);
    }

    public static Luogo creaLuogoUtente(String nome, String descrizione, String collocazioneGeografica) {
        return new Luogo(nome, descrizione, collocazioneGeografica);
    }


    @Override
    public String toString() {
        return "Luogo [collocazioneGeografica=" + collocazioneGeografica + ", descrizione=" + descrizione + ", nome=" + nome + "]";
    }

}
