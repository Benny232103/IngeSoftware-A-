package src.it.unibs.ingsw.gestvisit;

import it.unibs.fp.libjava.InputDati;

public class Utente {
    private String nomeUtente;
    private String password;

    public Utente(String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserName: " + nomeUtente + "\npassword: " + password;
    }

    public boolean verificaPassword(String password) {
        return this.password.equals(password);
    }

    public static Utente creaUtente(){
        String nomeUtente = InputDati.leggiStringaNonVuota("inserire il nome utente: ");
        String password = InputDati.leggiStringaNonVuota("inserire la password: ");
        return new Utente(nomeUtente, password);
    }
}
