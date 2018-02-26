import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    ProjectDeductiveDatabase datos;
    boolean terminado;
    Scanner scanner;
    int opcion;
    String palabra;

    public Menu(ProjectDeductiveDatabase datos){
        this.datos = datos;
        scanner = new Scanner(System.in);
        terminado = false;
    }

    public void iniciar(){
        while (!terminado){
            System.out.println("**** Escribe un número de las siguientes opciones **** \n");
            System.out.println("     [0] Para buscar por palabra");
            System.out.println("     [1] Para ver el aswer-set");
            System.out.println("     [2] Para ver las personas que existen");
            System.out.println("     [3] Ver los sintomas de las personas");
            System.out.println("     [4] Ver los medicamentos que se usan para cierta enfermedad");
            System.out.println("     [5] Ver las posibles enfermedades relacionadas con los sintomas");
            System.out.println("     [6] Ver lo que puede tomar una persona enferma");
            System.out.println("     [7] Ver enfermedades que tienen cura");
            System.out.println("     [8] Ver personas que no tienen cura");
            System.out.println("     [9] Ver los amigos que están en las buenas y en las malas");
            System.out.println("     [10] Salir");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 0:
                        datos.resumen();
                        break;
                    case 1:
                        datos.cargarAnswerSet();
                        break;
                    case 2:
                        datos.cargarPersonas();
                        break;
                    case 3:
                        datos.cargarSintomasDePersonas();
                        break;
                    case 4:
                        datos.cargarMedicinaEnfermedad();
                        break;
                    case 5:
                        datos.cargarPuedeEstarEnfermo();
                        break;
                    case 6:
                        datos.cargarPosiblesMedicamentos();
                        break;
                    case 7:
                        datos.cargarEnfermedadesConCura();
                        break;
                    case 8:
                        datos.cargarDesahuciados();
                        break;
                    case 9:
                        datos.cargarAmigos();
                        break;
                    case 10:
                        terminado = true;
                        break;
                    default:
                        System.out.println("        Solo números entre 1 y 10".toUpperCase());
                }
            } catch (InputMismatchException e) {
                System.out.println("        Solo numeros".toUpperCase());
                scanner.next();
            }
        }
    }
}
