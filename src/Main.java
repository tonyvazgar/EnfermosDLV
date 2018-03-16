public class Main {

    public static void main(String[] Args){

        ProjectDeductiveDatabase model;
        InterfazPrincipal view;
        Controler controler;
        //Menu menu;

        model = new ProjectDeductiveDatabase();
        //menu = new Menu(model);
        view = new InterfazPrincipal();
        controler = new Controler(model, view);

        view.inicia(controler);
        //menu.iniciar();
    }
}
