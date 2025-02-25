import java.util.*;
class Configuratore {
    private String username;
    private String password;
    private boolean isLogged;

    public Configuratore(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLogged = false;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            isLogged = true;
            return true;
        }
        return false;
    }
}
