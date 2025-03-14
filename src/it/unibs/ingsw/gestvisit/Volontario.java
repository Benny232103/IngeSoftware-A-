package src.it.unibs.ingsw.gestvisit;

import java.util.List;

public class Volontario extends Utente {
    private String email;
    private String password;
    private String tipiDiVisite;
    
    public Volontario(String nome, String cognome, String email, String password, String tipiDiVisite) {
        super(nome, cognome);
        this.email = email;
        this.password = password;
        this.tipiDiVisite = tipiDiVisite;
    }
    
    public String getTipiDiVisite() {
        return tipiDiVisite;
    }

    public void setTipiDiVisite(String tipiDiVisite) {
        this.tipiDiVisite = tipiDiVisite;
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

    @Override
    public String toString() {
        return "Volontario [nome=" + super.getNome() + ", cognome=" + super.getCognome() + ", email=" + email + ", tipiDiVisite=" + tipiDiVisite + "]";
    }
}
