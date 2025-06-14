package grafo;

public class Main2 {
    public static void main(String[] args) {
        GrafoDin<String> grafo = new GrafoDin<>();

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
        grafo.algoritmoDFS("D");
    }
}

