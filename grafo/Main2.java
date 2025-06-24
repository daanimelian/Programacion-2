package grafo;

public class Main2 {
    public static void main(String[] args) {
        /*GrafoDin<String> grafo = new GrafoDin<>();

        // Agregar vértices
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        // Agregar aristas
        grafo.agregarArista("A", "B", 1);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 1);
        grafo.agregarArista("C", "D", 1);
        grafo.agregarArista("D", "E", 1);

        // Imprimir recorrido DFS desde A
        System.out.println("DFS desde A:");
        grafo.algoritmoDFS("D");*/

        GrafoDin<String> grafo = new GrafoDin<>(); // o GrafoDin<> si usás otro nombre

            // Caso SIN ciclo:
            grafo.agregarVertice("A");
            grafo.agregarVertice("B");
            grafo.agregarVertice("C");
            grafo.agregarVertice("D");

            grafo.agregarArista("A", "B", 1);
            grafo.agregarArista("B", "C", 1);
            grafo.agregarArista("C", "D", 1);

            if (grafo.hayCiclos()) {
                System.out.println("Hay ciclo (caso sin ciclo)");
            } else {
                System.out.println("No hay ciclo (caso sin ciclo)");
            }

            // Caso CON ciclo:
            grafo.agregarArista("D", "B", 1); // crea un ciclo: B → C → D → B

            if (grafo.hayCiclos()) {
                System.out.println("Hay ciclo (caso con ciclo)");
            } else {
                System.out.println("No hay ciclo (caso con ciclo)");
            }
        }
}

