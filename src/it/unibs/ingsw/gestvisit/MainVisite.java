package src.it.unibs.ingsw.gestvisit;

public class MainVisite {
    public static void main(String[] args) {
        VisitManager manager = new VisitManager();
        manager.leggiCredenzialiConfiguratore();

        if(manager.autenticaConfiguratore()){
            System.out.println("Accesso Effettuato");
            manager.menu();
        }
    }
}
