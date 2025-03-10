package src.it.unibs.ingsw.gestvisit;

public class Utente {
    private String nome;
    private String cognome;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome; // assuming an empty default, can modify as per requirements
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
