public class Main {

    public static void main(String[] Args){

        /* ---------------------------------------------- *
         * CLASE PRINCIPAL LA CUAL HACE QUE SE EJECUTE EL *
         * PROGRAMA POR MEDIO DE UNA INTERFAZ DE USUARIO  *
         * O POR UN MENU EN LA CONSOLA (SE PUEDE VER      *
         * ESTE MENU QUITANDO LOS COMENTARIOS QUE ESTAN   *
         * PRESENTES ABAJO)                               *
         * ---------------------------------------------- */

        ProjectDeductiveDatabase model;
        InterfazPrincipal view;
        Controler controler;
        Menu menu;

        model = new ProjectDeductiveDatabase();
        menu = new Menu(model);
        view = new InterfazPrincipal();
        controler = new Controler(model, view);

        view.inicia(controler);
        menu.iniciar();
    }
}
