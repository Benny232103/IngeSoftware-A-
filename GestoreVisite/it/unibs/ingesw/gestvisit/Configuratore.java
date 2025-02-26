package GestoreVisite.it.unibs.ingesw.gestvisit;
import it.unibs.fp.mylib.*;
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

		public boolean isLogged() {
			return isLogged;
		}

		public void setLogged(boolean isLogged) {
			this.isLogged = isLogged;
		}

		public static Configuratore creaConfiguratore() {
	    	 String accessoConfiguratoreString = InputDati.leggiStringaNonVuota("nome utente: ");
		     String passwordConfiguratoreString = InputDati.leggiStringaNonVuota("password: ");
		     return new Configuratore(accessoConfiguratoreString, passwordConfiguratoreString);
	    }
}
