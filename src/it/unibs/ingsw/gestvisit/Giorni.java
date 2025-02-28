package src.it.unibs.ingsw.gestvisit;
import java.util.*;

class GestVisite {
    static final int NUMERO_MAX_PERSONE_PER_VISITA = 20;    
    private String titolo;
    private String descrizioneVisita;
    private String luogoIncontro;
    private String periodoAnnoInCuiPossibileVedere;
    private Giorni giornataSettimanale;
    private int ora;
    private int durataMinuti;
    private String descrizioneBiglietto;
    private List<Luogo> luoghi;
    private Set<String> dateNonDisponibili;
    private int maxPersonePerVisita;

    public enum Giorni {
        LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA;
    }


    public GestVisite() {
        this.luoghi = new ArrayList<>();
        this.dateNonDisponibili = new HashSet<>();
        this.maxPersonePerVisita = 10; // valore di default
    }

    public void setGiornateSettimanali(Set<Giorni> giornate) {
        this.giornataSettimanale = giornate;
    }

    public Set<Giorni> getGiornateSettimanali() {
        return giornataSettimanale;
    }

    public void aggiungiLuogo(String nome) {
        luoghi.add(new Luogo(nome));
    }

    public void modificaMaxPersone(int max) {
        this.maxPersonePerVisita = max;
    }

    public void aggiungiDataNonDisponibile(String data) {
        dateNonDisponibili.add(data);
    }

    public void mostraLuoghi() {
        for (Luogo l : luoghi) {
            System.out.println(l);
        }
    }
}
