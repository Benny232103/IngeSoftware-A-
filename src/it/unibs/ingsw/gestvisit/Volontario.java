package src.it.unibs.ingsw.gestvisit;

public class Volontario extends Utente {
    private String email;
    private String nomeUtente;
    private String password;
    
    public Volontario(String nome, String cognome, String email, String nomeUtente, String password) {
        super(nome, cognome);
        if (nome == null || cognome == null || email == null || nomeUtente == null || password == null) {
            throw new IllegalArgumentException("I campi non possono essere null");
        }
        this.email = email;
        this.nomeUtente = nomeUtente;
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
        return "Volontario: " + super.getNome() + " " + super.getCognome() + " " + email + " " + nomeUtente;
    }
}
