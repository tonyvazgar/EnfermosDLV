import java.util.*;

import it.unical.mat.dlv.program.Term;
import it.unical.mat.wrapper.FactResult;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class ProjectDeductiveDatabase {
	static DeductiveDatabase database;
	static Vector<FactResult>  answerSet;

	static Vector<Dato> datos;
	static int i;
	static Dato dato;
	static Fact fact;
	static String palabra;

	public static Vector<Dato> getDatos(Vector<FactResult>  answerSet) {
		Vector<Dato> datos;
		Dato dato;
		FactResult factResult;
		int i;
		int j;
        List<Term> lista;
        String predicate;
        StringTokenizer tokenizer;
		//
		datos = new Vector<Dato>();
		i = 0;
		while(i < answerSet.size()) {
			factResult = answerSet.get(i);
			lista = factResult.attributes();
            if(lista.size() == 0)       //predicado sin atributos (como iAmHungry)
                predicate = factResult.toString();
            else {
                tokenizer = new StringTokenizer(factResult.toString(), "(");
                predicate = tokenizer.nextToken();
            }//end else
			dato = new Dato(predicate);
            if(lista.size() != 0) {
                j = 0;
                while(j < lista.size()) {
                    dato.addArgument(lista.get(j).toString());
                    j = j + 1;
                }//end while
            }//end if
            datos.add(dato);
			i = i + 1;
		}//end while

		return datos;
	}//end getDatos

	public static void cargarArchivos(){
		database = new DeductiveDatabase("./dlv.bin");
		database.load("./enfermosFacts.txt");
		database.load("./enfermosRules.txt");
		answerSet = database.getAnswerSet();
	}

	public static void cargarPersonas(){
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("persona")){
				System.out.println("    " + elDato.getArgument(0));

			}
		}
		System.out.println(" ************** ");
	}

	public static void cargarSintomasDePersonas() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***SINTOMAS DE PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("tieneSintoma")){
				System.out.print("    " + elDato.getArgument(0));
				System.out.println("  -->  " + elDato.getArgument(1));

			}
		}
		System.out.println(" **************************");
	}

	public static void cargarMedicinaEnfermedad() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***PARA ESTAS ENFERMEDADES SE USAN ESTAS \"MEDICINAS\"*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("enfermedad")){
				System.out.print(" Para enfermedad: " + elDato.getArgument(0));
				System.out.println(" tomar  -->  " + elDato.getArgument(1));

			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarPuedeEstarEnfermo() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***ENFERMEDADES DE LAS CUALES PUEDEN ESTAR ENFERMAS LAS PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedeEstarEnfermoDe")){
				System.out.print(elDato.getArgument(0).toUpperCase());
				System.out.println(" puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase());
			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarPosiblesMedicamentos() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***ESTO PUEDEN TOMAR LAS PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedeTomar")){
				System.out.print(elDato.getArgument(0).toUpperCase());
				System.out.println(" puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase());
			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarEnfermedadesConCura() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***ESTAS ENFERMEDADES TIENEN CURA*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("enfermedadQueTieneCura")){
				System.out.println(" " + elDato.getArgument(0));
			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarDesahuciados() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***ESTAS PERSONAS YA NO TIENEN CURA*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("noTieneCura")){
				System.out.println(" El paciente " + elDato.getArgument(0).toUpperCase() + " esta desahuciado.");
			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarAmigos() {
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***PUEDEN SER AMIGOS ENFERMOS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedenSerAmigosEnfermos")){
				System.out.println(" " + elDato.getArgument(0) + " y " + elDato.getArgument(1) + " pueden ser amigos enfermos.");
			}
		}
		System.out.println(" *****************************************************");
	}

	public static void cargarAnswerSet(){
		cargarArchivos();
		database.show();
	}

	public void resumen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el nombre de la persona o del medicamento/enfermedad/Sintoma");
		String nombre = scanner.nextLine();
		cargarArchivos();
		datos = getDatos(answerSet);
		for(Dato elDato: datos){
			int i = 0;

			while (i < elDato.getArity())
			{
				if(elDato.getArgument(i).equals(nombre))
				{
					System.out.println(elDato.getPredicate() + elDato.arguments.toString().replace("[", "(").replace("]",")"));
				}
				i = i + 1;
			}
		}
	}
}//end ProjectDeductiveDatabase
