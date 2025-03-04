package src.it.unibs.ingsw.gestvisit;

public class MainVisite {
    public static void main(String[] args) {
        VisitManager manager = new VisitManager();
        manager.leggiCredenzialiConfiguratore();

        if(manager.autenticaConfiguratore()){
            System.out.println("Configuratore Autenticato con successo");
            manager.modificaCredenzialiConfiguratore();
            manager.menu();
        }else{
            System.out.println("Accesso Negato");
        }
    }
}
