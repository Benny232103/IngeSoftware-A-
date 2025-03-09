package src.it.unibs.ingsw.gestvisit;

public class MainVisite {
    public static void main(String[] args) {
        VisitManager manager = new VisitManager();
        manager.leggiCredenzialiConfiguratore();

        if(manager.autenticaConfiguratore()){
            System.out.println("Configuratore Autenticato con successo");
            manager.menu();
        }else if (manager.autenticaTemporaneo()){
            System.out.println("Accesso Temporaneo");
            manager.modificaCredenzialiConfiguratore();
            manager.menu();
        }else if (!manager.autenticaConfiguratore() && !manager.autenticaTemporaneo()){
            System.out.println("Accesso Negato");
        }
    }
}
