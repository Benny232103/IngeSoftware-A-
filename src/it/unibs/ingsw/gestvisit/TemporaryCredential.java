package src.it.unibs.ingsw.gestvisit;

public class TemporaryCredential {
    private String username;
    private String password;

    public TemporaryCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
