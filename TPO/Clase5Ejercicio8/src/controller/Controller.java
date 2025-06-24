package TPO.Clase5Ejercicio8.src.controller;
import TPO.Clase5Ejercicio8.src.inout.InOut;
import TPO.Clase5Ejercicio8.src.list.List;
import TPO.Clase5Ejercicio8.src.map.Map;
import TPO.Clase5Ejercicio8.src.mapSimple.MapSimple;

public class Controller {
	private static Map<String,Integer> MapPrincipal = new Map<String,Integer> ();
	private List<MapSimple<String,Integer>> ListaMapasSimple = new List<MapSimple<String,Integer>>();
	private InOut inout = new InOut();
	
	public boolean PrincipalVacio() {
		return MapPrincipal.isEmpty();
	}
	
	public boolean ListaMapasSimpleVacio() {
		return ListaMapasSimple.isEmpty();
	}
	
	public MapSimple<String,Integer> CrearMapa(){
		MapSimple<String,Integer> materia = new MapSimple<String,Integer>();
		String dni;
		int nota;
		String opcion;
		do{
			opcion = inout.MenuCargaMapa();
			switch(opcion) {
			case "1":
				System.out.println("Recuerde que si ingresa un dni dos veces, la nota ingresada pisara la anterior.");
				dni = inout.PedirDni();
				nota = inout.PedirNota();
				materia.put(dni, nota);
				break;
			case "0":
				System.out.println("Saliendo...");
			break;
			default:
				System.out.println("No se conoce la opcion, intente nuevamente");
				break;
			}
		}while(!opcion.equals("0"));
		
		return materia;
	}
	
	public void CargarMapeo(MapSimple<String,Integer> map) {
		ListaMapasSimple.addElementEnd(map);
	}

	public MapSimple<String,Integer> getUltimoMapeo() {
		return ListaMapasSimple.getAtEnd();
	}

	public void AgregarMapeo(MapSimple<String,Integer> ultimoMapeo) {
		List<String> keys = ultimoMapeo.keys();
		for(int i = 0; i < keys.size(); i++) {
			MapPrincipal.put(keys.getAt(i), ultimoMapeo.get(keys.getAt(i)));
		}
		
	}
	 
	public static boolean existeDni(String Dni) {
		return !(MapPrincipal.get(Dni) == null);
	}
	
	public void CargarNota(String Dni, int nota) {
		MapPrincipal.put(Dni, nota);
	}

	public void QuitarNota(String Dni, int nota) {
		MapPrincipal.remove(Dni, nota);
	}

	public void QuitarAlumno(String Dni) {
		MapPrincipal.remove(Dni);
	}

	public List<Integer> GetNotas(String Dni) {
		return MapPrincipal.get(Dni);
	}

	public List<String> GetAlumnos() {
		return MapPrincipal.keys();
	}

	public MapSimple<String,Float> GetAlumnosYPromedios() {
		List<String> alumnos = GetAlumnos();
		List<Integer> notas;
		MapSimple<String,Float> notasPromedio = new MapSimple<String,Float>();
		float promedio;
		int cantidadNotas;
		int acumuladorNotas;
		for(int i = 0; i < alumnos.size(); i++) {
			promedio = 0;
			acumuladorNotas = 0;
			notas = GetNotas(alumnos.getAt(i));
			cantidadNotas = notas.size();
			for(int j = 0; j < cantidadNotas; j++) {
				acumuladorNotas += notas.getAt(j);
			}
			if(cantidadNotas > 0 ) {
				promedio = acumuladorNotas/(float)cantidadNotas;
			}
			notasPromedio.put(alumnos.getAt(i), promedio);
		}
		return notasPromedio;
		 
	}
	
}
