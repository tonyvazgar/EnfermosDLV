public class Main {

    public static void main(String[] Args){

        ProjectDeductiveDatabase datos;
        Menu menu;

        datos = new ProjectDeductiveDatabase();
        menu = new Menu(datos);

        menu.iniciar();
    }
}
