public class Main {

    public static void main(String[] Args){

        ProjectDeductiveDatabase datos;
        Menu menu;
        InterfazPrincipal interfaz;

        datos = new ProjectDeductiveDatabase();
        menu = new Menu(datos);
        interfaz = new InterfazPrincipal();

        interfaz.inicia();

        menu.iniciar();
    }
}
