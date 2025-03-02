package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.InputDati;

public class Utente {
    private String nome;
    private String cognome;

    public Utente(String nomeUtente, String password) {
        this.nome = nome;
        this.cognome = cognome; // assuming password should not be assigned to cognome
    }

    public void setNome(String nome) {
        this.nome = nome; // changed method to set the nome
    }

    public void setCognome(String cognome) {
        this.cognome = cognome; // added method to set the cognome
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
