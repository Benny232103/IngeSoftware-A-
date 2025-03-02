package src.it.unibs.ingsw.gestvisit;


public class Configuratore extends Utente {
    private String email;
    private String nomeUtente;
    private String password;

    public Configuratore(String nome, String cognome, String email, String nomeUtente, String password) {
        super(nome, cognome);
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.email = email;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }
    
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
