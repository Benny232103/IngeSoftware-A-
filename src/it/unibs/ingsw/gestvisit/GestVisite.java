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

    public GestVisite() {
        this.luoghi = new ArrayList<>();
        this.dateNonDisponibili = new HashSet<>();
        this.maxPersonePerVisita = 10; // valore di default
    }
    
}
