package src.it.unibs.ingsw.gestvisit;
import java.util.*;
class GestVisite {
    private List<Luogo> luoghi;
    private Set<String> dateNonDisponibili;
    private int maxPersonePerVisita;

    public GestVisite() {
        this.luoghi = new ArrayList<>();
        this.dateNonDisponibili = new HashSet<>();
        this.maxPersonePerVisita = 10; // valore di default
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
