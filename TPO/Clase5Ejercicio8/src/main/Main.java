package TPO.Clase5Ejercicio8.src.main;

import TPO.Clase5Ejercicio8.src.controller.Controller;
import TPO.Clase5Ejercicio8.src.inout.InOut;

public class Main {
	public static void main (String[] args) {
		String opcion;
		InOut inOut = new InOut();
		Controller controller = new Controller();
		boolean listaMapasSimpleLleno =  !controller.ListaMapasSimpleVacio();
		boolean mapaPrincipalLleno = !controller.PrincipalVacio();
		do {
			opcion = inOut.MenuPrincipal();
			
			switch(opcion) {
			case "0":
				System.out.println("Saliendo.... "); 
				break;
				case "1":
					controller.CargarMapeo(controller.CrearMapa());
					break;
				case "2":
					if(listaMapasSimpleLleno) {
						inOut.MostrarMapeo(controller.getUltimoMapeo());						
					}else {
						System.out.println("Debes cargar un mapeo antes.");
					}
					break;
				case "3":
					if(listaMapasSimpleLleno) {
						controller.AgregarMapeo(controller.getUltimoMapeo());
						System.out.println("---CARGA EXITOSA---");
					}else {
						System.out.println("Debes cargar un mapeo antes.");
					}
					break;
				case "4":
					if(mapaPrincipalLleno) {
						controller.CargarNota(inOut.PedirDniExistente(),inOut.PedirNota());
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				case "5":
					if(mapaPrincipalLleno) {
						controller.QuitarNota(inOut.PedirDniExistente(),inOut.PedirNota());
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				case "6":
					if(mapaPrincipalLleno) {
						controller.QuitarAlumno(inOut.PedirDniExistente());
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				case "7":
					if(mapaPrincipalLleno) {
						inOut.MostrarNotas(controller.GetNotas(inOut.PedirDni()));
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				case "8":
					if(mapaPrincipalLleno) {
						inOut.MostrarAlumnos(controller.GetAlumnos());
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				case "9":
					if(mapaPrincipalLleno) {
						inOut.MostrarAlumnosYPromedios(controller.GetAlumnosYPromedios());
					}else {
						System.out.println("Debes agregar un mapeo al diccionario general antes.");
					}
					break;
				default:
					System.out.println("Opcion inexistente, intente nuevamente."); 
					break;
			}
		}while(!opcion.equals("0"));
	}
}
