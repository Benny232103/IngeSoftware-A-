package GestoreVisite.it.unibs.ingesw.gestvisit;
import java.util.*;
class Luogo {
    private String nome;
    private List<String> tipiVisita;
    private List<String> volontari;

    public Luogo(String nome) {
        this.nome = nome;
        this.tipiVisita = new ArrayList<>();
        this.volontari = new ArrayList<>();
    }

    public void aggiungiTipoVisita(String tipo) {
        tipiVisita.add(tipo);
    }

    public void assegnaVolontario(String volontario) {
        volontari.add(volontario);
    }

    @Override
    public String toString() {
        return "Luogo: " + nome + ", Tipi di visita: " + tipiVisita + ", Volontari: " + volontari;
    }
}
