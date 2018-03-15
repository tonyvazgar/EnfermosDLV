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

	public static String cargarPersonas(){
		String personas = "";
		cargarArchivos();
		datos = getDatos(answerSet);
		System.out.println(" ***PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("persona")){
				//System.out.println("    " + elDato.getArgument(0));
				personas = personas + elDato.getArgument(0) + "\n";

			}
		}
		return personas;
	}

	public static String cargarSintomasDePersonas() {
		cargarArchivos();
		String sintomas = "";
		datos = getDatos(answerSet);
		System.out.println(" ***SINTOMAS DE PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("tieneSintoma")){
				//System.out.print("    " + elDato.getArgument(0));
				//System.out.println("  -->  " + elDato.getArgument(1));
				sintomas = sintomas + elDato.getArgument(0) + "  -->  " + elDato.getArgument(1) + "\n";
			}
		}
		return sintomas;
	}

	public static String cargarMedicinaEnfermedad() {
		cargarArchivos();
		String medicinas = "";
		datos = getDatos(answerSet);
		System.out.println(" ***PARA ESTAS ENFERMEDADES SE USAN ESTAS \"MEDICINAS\"*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("enfermedad")){
				//System.out.print(" Para enfermedad: " + elDato.getArgument(0));
				//System.out.println(" tomar  -->  " + elDato.getArgument(1));
				medicinas = medicinas + " Para enfermedad: " + elDato.getArgument(0) + " tomar  -->  " + elDato.getArgument(1) + "\n";
			}
		}
		return medicinas;
	}

	public static String cargarPuedeEstarEnfermo() {
		cargarArchivos();
		String posibleEnfermedad = "";
		datos = getDatos(answerSet);
		System.out.println(" ***ENFERMEDADES DE LAS CUALES PUEDEN ESTAR ENFERMAS LAS PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedeEstarEnfermoDe")){
				//System.out.print(elDato.getArgument(0).toUpperCase());
				//System.out.println(" puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase());
				posibleEnfermedad = posibleEnfermedad + elDato.getArgument(0).toUpperCase() + " puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase() + "\n";
			}
		}
		return posibleEnfermedad;
	}

	public static String cargarPosiblesMedicamentos() {
		cargarArchivos();
		String medicamentos = "";
		datos = getDatos(answerSet);
		System.out.println(" ***ESTO PUEDEN TOMAR LAS PERSONAS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedeTomar")){
				//System.out.print(elDato.getArgument(0).toUpperCase());
				//System.out.println(" puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase());
				medicamentos = medicamentos + elDato.getArgument(0).toUpperCase() + " puede estar enfermo de  ->  " + elDato.getArgument(1).toUpperCase() + "\n";
			}
		}
		return medicamentos;
	}

	public static String cargarEnfermedadesConCura() {
		cargarArchivos();
		String cura = "";
		datos = getDatos(answerSet);
		System.out.println(" ***ESTAS ENFERMEDADES TIENEN CURA*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("enfermedadQueTieneCura")){
				//System.out.println(" " + elDato.getArgument(0));
				cura = cura + elDato.getArgument(0) + "\n";
			}
		}
		return  cura;
	}

	public static String cargarDesahuciado() {
		cargarArchivos();
		String muertos = "";
		datos = getDatos(answerSet);
		System.out.println(" ***ESTAS PERSONAS YA NO TIENEN CURA*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("noTieneCura")){
				//System.out.println(" El paciente " + elDato.getArgument(0).toUpperCase() + " esta desahuciado.");
				muertos = muertos + " El paciente " + elDato.getArgument(0).toUpperCase() + " esta desahuciado." + "\n";
			}
		}
		return muertos;
	}

	public static String cargarAmigos() {
		cargarArchivos();
		String amigos = "";
		datos = getDatos(answerSet);
		System.out.println(" ***PUEDEN SER AMIGOS ENFERMOS*** ");
		for(Dato elDato:datos){
			if(elDato.getPredicate().equals("puedenSerAmigosEnfermos")){
				//System.out.println(" " + elDato.getArgument(0) + " y " + elDato.getArgument(1) + " pueden ser amigos enfermos.");
				amigos = amigos + elDato.getArgument(0) + " y " + elDato.getArgument(1) + " pueden ser amigos enfermos." + "\n";
			}
		}
		return amigos;
	}

	public static String cargarAnswerSet(){
		cargarArchivos();
		return database.showInConsole();
	}

	public String resumen() {
		String resumen = "";
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
					//System.out.println(elDato.getPredicate() + elDato.arguments.toString().replace("[", "(").replace("]",")"));
					resumen = resumen + elDato.getPredicate() + elDato.arguments.toString().replace("[", "(").replace("]",")") + "\n";
				}
				i = i + 1;
			}
		}
		return resumen;
	}

	public void agregar(String aAgregar) {
		cargarArchivos();
		Scanner scanner = new Scanner(System.in);
		if(aAgregar.equals("persona"))
		{
			System.out.println("Ingresa el nombre de la persona");
			String nombre = scanner.nextLine();
			fact = new Fact("persona");
			fact.addArgument(nombre);
			database.addFact(fact);
			database.show();
		}
		if(aAgregar.equals("sintomas"))
		{
			fact = new Fact("tieneSintoma");

			System.out.println("Ingresa el nombre de la persona a asignar sintoma");
			String nombre = scanner.nextLine();
			fact.addArgument(nombre);
			System.out.println("Ingresa el nombre del sitoma");
			nombre = scanner.nextLine();
			fact.addArgument(nombre);

			database.addFact(fact);
			database.show();
		}
	}

}//end ProjectDeductiveDatabase
