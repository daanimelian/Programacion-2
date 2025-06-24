package TPO.Clase5Ejercicio8.src.inout;

import TPO.Clase5Ejercicio8.src.controller.Controller;
import TPO.Clase5Ejercicio8.src.mapSimple.Entrada;
import TPO.Clase5Ejercicio8.src.mapSimple.MapSimple;
import TPO.Clase5Ejercicio8.src.list.List;

import java.util.Scanner;

public class InOut {
	
	private Scanner scanner = new Scanner(System.in); 
	
	private String PedirOpcion() {
		System.out.println("Ingrese una opcion: ");
		String opcion;
		opcion = scanner.nextLine();
		return opcion;
	}
	
	public String MenuPrincipal() {
		System.out.println("----- Bienvenido al Ejercicio 8 -----\n");
		System.out.println("Opciones");
		System.out.println("1.Cargar un mapeo con notas de una materia.");
		System.out.println("2.Mostrar el último mapeo cargado.");
		System.out.println("3.Agregar el último mapeo cargado al Diccionario general.");
		System.out.println("4.Agregar una nota para un DNI específico."); 
		System.out.println("5.Quitar una nota para un DNI específico."); 
		System.out.println("6.Quitar un alumno."); 
		System.out.println("7.Mostrar las notas de un alumno. "); 
		System.out.println("8.Mostrar todos los alumnos."); 
		System.out.println("9.Mostrar todos los alumnos y su promedio de notas."); 
		System.out.println("0.Salir."); 
		return PedirOpcion();
	}
	
	public String MenuCargaMapa() { 
		System.out.println("1.Cargar nota.");
		System.out.println("0.Salir."); 
		return PedirOpcion();
	}
	

	public void MostrarMapeo(MapSimple<String,Integer> ultimoMapeo) {
		List<Entrada<String, Integer>> entradas = ultimoMapeo.entries();
		System.out.println("(DNI\t\tNOTA\t)"); 
		for(int i = 0; i < entradas.size(); i++) {
			System.out.println(entradas.getAt(i).toString());
		}
		System.out.println("(-----------------------)"); 
		System.out.println("Presione enter para continuar."); 
		scanner.nextLine();
		
	}

	public int PedirNota(){
		String notaString;
		int notaInt;
		do {
			System.out.println("Ingrese una Nota (Entre 0 y 10): ");
			notaString = scanner.nextLine();
			try {
				notaInt = Integer.parseInt(notaString);
				
			}catch(NumberFormatException e) {
				System.out.println("Error, no es un numero valido");
				notaInt = PedirNota();
			}
			
		}while(notaInt < 0 || notaInt > 10);
		return notaInt;
	}
	
	public String PedirDniExistente() {
		System.out.println("Ingrese un DNI: ");
		String dni;
		dni = scanner.nextLine();
		while(!Controller.existeDni(dni)) {
			System.out.println("Ese DNI no existe, intente denuevo.");
			System.out.println("Ingrese un DNI: ");
			dni = scanner.nextLine();
		}
		return dni;
	}
	
	public String PedirDni() {
		System.out.println("Ingrese un DNI: ");
		String opcion;
		opcion = scanner.nextLine();
		return opcion;
	}		
		
	public void MostrarNotas(List<Integer> Notas) {
		System.out.println("Lista de Notas del alumno.");
		for(int i = 0; i < Notas.size(); i++) {
			System.out.println(i + ". " + Notas.getAt(i).toString());
		}
	}

	public void MostrarAlumnos(List<String> Alumnos) {
		System.out.println("Lista de alumnos");
		for(int i = 0; i < Alumnos.size(); i++) {
			System.out.println(i + ". " + Alumnos.getAt(i).toString());
		}
	}

	public void MostrarAlumnosYPromedios(MapSimple<String,Float> AlumnosYPromedios) {
		List<Entrada<String, Float>> entradas = AlumnosYPromedios.entries();
		System.out.println("(DNI\t\tPROMEDIO)"); 
		for(int i = 0; i < entradas.size(); i++) {
			System.out.println(entradas.getAt(i).toString());
		}
		System.out.println("(-----------------------)"); 
		System.out.println("Presione enter para continuar."); 
		scanner.nextLine();
		
	}
}
