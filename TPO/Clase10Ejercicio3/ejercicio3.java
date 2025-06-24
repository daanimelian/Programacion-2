package TPO.Clase10Ejercicio3;

import java.util.List;

public class ejercicio3 {
    public static void main(String[] args){
        // Crear el grafo
        GrafoDin<String> grafo = new GrafoDin<>();

        // Agregar vértices
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");

        System.out.println("=== PRUEBA DE NODOS PUENTE ===\n");

        // Caso 1: Grafo con múltiples puentes
        System.out.println("Caso 1: Grafo con múltiples puentes");
        System.out.println("Agregando aristas: A->B, A->C, A->D, B->E, C->E, D->F");
        grafo.agregarArista("A", "B", 1);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("A", "D", 1);
        grafo.agregarArista("B", "E", 1);
        grafo.agregarArista("C", "E", 1);
        grafo.agregarArista("D", "F", 1);

        List<String> puentes = grafo.nodosPuente("A", "E");
        System.out.println("Nodos puente entre A y E: " + puentes);
        System.out.println("Esperado: [B, C] (pueden estar en cualquier orden)\n");

        // Caso 2: Sin nodos puente
        System.out.println("Caso 2: Sin nodos puente");
        puentes = grafo.nodosPuente("A", "F");
        System.out.println("Nodos puente entre A y F: " + puentes);
        System.out.println("Esperado: [D]\n");

        // Caso 3: No hay camino indirecto
        System.out.println("Caso 3: No hay camino indirecto");
        puentes = grafo.nodosPuente("B", "F");
        System.out.println("Nodos puente entre B y F: " + puentes);
        System.out.println("Esperado: [] (lista vacía)\n");

        // Caso 4: Crear un nuevo grafo más complejo
        System.out.println("Caso 4: Grafo más complejo");
        GrafoDin<Integer> grafo2 = new GrafoDin<>();

        // Agregar vértices
        for (int i = 1; i <= 6; i++) {
            grafo2.agregarVertice(i);
        }

        // Crear un grafo como: 1 -> 2, 3, 4 y 2,3,4 -> 5 y 3 -> 6 y 6 -> 5
        System.out.println("Agregando aristas: 1->2, 1->3, 1->4, 2->5, 3->5, 3->6, 4->5, 6->5");
        grafo2.agregarArista(1, 2, 1);
        grafo2.agregarArista(1, 3, 1);
        grafo2.agregarArista(1, 4, 1);
        grafo2.agregarArista(2, 5, 1);
        grafo2.agregarArista(3, 5, 1);
        grafo2.agregarArista(3, 6, 1);
        grafo2.agregarArista(4, 5, 1);
        grafo2.agregarArista(6, 5, 1);

        List<Integer> puentes2 = grafo2.nodosPuente(1, 5);
        System.out.println("Nodos puente entre 1 y 5: " + puentes2);
        System.out.println("Esperado: [2, 3, 4] (pueden estar en cualquier orden)\n");

        puentes2 = grafo2.nodosPuente(3, 5);
        System.out.println("Nodos puente entre 3 y 5: " + puentes2);
        System.out.println("Esperado: [6]\n");

        // Caso 5: Probar con vértices que no existen o casos límite
        System.out.println("Caso 5: Casos límite");
        try {
            puentes = grafo.nodosPuente("A", "Z"); // Z no existe
            System.out.println("Nodos puente entre A y Z: " + puentes);
        } catch (Exception e) {
            System.out.println("Error esperado al buscar vértice inexistente: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE PRUEBAS ===");
    }
}

