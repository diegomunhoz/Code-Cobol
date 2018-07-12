import util.UtilProjeto;
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        UtilProjeto util = new UtilProjeto();
        util.mudarAparencia();
        new MenuPrincipal();
    }
}