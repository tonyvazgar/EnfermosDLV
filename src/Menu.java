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
            System.out.println("     [10] Para agregar nuevos hechos.");
            System.out.println("     [11] Salir");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println(datos.resumen());
                        break;
                    case 1:
                        System.out.println(datos.cargarAnswerSet());
                        break;
                    case 2:
                        System.out.println(datos.cargarPersonas());
                        break;
                    case 3:
                        System.out.println(datos.cargarSintomasDePersonas());
                        break;
                    case 4:
                        System.out.println(datos.cargarMedicinaEnfermedad());
                        break;
                    case 5:
                        System.out.println(datos.cargarPuedeEstarEnfermo());
                        break;
                    case 6:
                        System.out.println(datos.cargarPosiblesMedicamentos());
                        break;
                    case 7:
                        System.out.println(datos.cargarEnfermedadesConCura());
                        break;
                    case 8:
                        System.out.println(datos.cargarDesahuciado());
                        break;
                    case 9:
                        System.out.println(datos.cargarAmigos());
                        break;
                    case 10:
                        System.out.println("     [0] Para agregar una persona");
                        System.out.println("     [1] Para agregar una sintomas");
                        int agregar = scanner.nextInt();
                        switch (agregar){
                            case 0:
                                datos.agregar("persona");
                                break;
                            case 1:
                                datos.agregar("sintomas");
                                break;
                        }
                        break;
                    case 11:
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
