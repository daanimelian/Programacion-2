package arbol.ABBClase;

import clase3.src.ArrayList;
import clase5.Map.Map;
import clase5.Map.ArrayMap;
import clase5.Map.Entry;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		// Crear un comparador para elementos genéricos de tipo Integer
		Comparator<Integer> comparator = Integer::compare;

		// Crear el árbol binario de búsqueda (ABB)
		ABBImple<Integer> arbol = new ABBImple<>(comparator);

		// Insertar algunos elementos
		arbol.insertar(12);  // Insertar la raíz
		arbol.insertar(18);   // Insertar el hijo izquierdo de la raíz
		arbol.insertar(6);  // Insertar el hijo derecho de la raíz
		arbol.insertar(7);

		// Llamar al método toMap para obtener el Map con las claves y la cantidad de hijos
		Map<Integer, Integer> mapaHijos = arbol.toMap1();

		// Mostrar el resultado del Map
		System.out.println("Elementos del ABB con la cantidad de hijos:");
		for (Entry<Integer, Integer> entry : mapaHijos.entries()) {
			System.out.println("Elemento: " + entry.getKey() + ", Hijos: " + entry.getValue());
		}

		ArrayList<Integer> rango = arbol.elementosEnRango(1,19);
		System.out.println("Elementos del ABB con la cantidad de rangos:");
		for (int i=0; i<rango.getSize(); i++){
			System.out.println("Elemento: " + rango.get(i));
		}
	}
}
