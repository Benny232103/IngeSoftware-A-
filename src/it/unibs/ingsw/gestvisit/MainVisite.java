package src.it.unibs.ingsw.gestvisit;

public class MainVisite {
    public static void main(String[] args) {
        VisitManager manager = new VisitManager();
        manager.leggiCredenzialiConfiguratore();
        manager.leggiCredenzialiVolontari();

        if(manager.autenticaConfiguratore()){
            System.out.println("Accesso Effettuato");
            manager.menu();
        } else if(manager.autenticaVolontario()){
            System.out.println("Accesso effettuato");
        }
    }
}
