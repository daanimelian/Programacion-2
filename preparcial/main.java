package preparcial;
import clase2.src.MyException;
import clase4.src.Entrada;

public class main {
    public static void main(String[] args) {
        try {
            // Crear una lista con capacidad inicial 5
            ArrayPriorityList<Integer, String> lista = new ArrayPriorityList<>(5);

            // Agregar elementos al principio y al final
            lista.addLast("Zorro", 5);
            lista.addFirst("Gato", 3);
            lista.addLast("Perro", 1);
            lista.addLast("Conejo", 2);
            lista.addFirst("Tigre", 4);

            System.out.println("Elementos agregados:");
            imprimirLista(lista);

            // Eliminar el primero
            lista.removeFirst();
            System.out.println("\nDespués de removeFirst:");
            imprimirLista(lista);

            // Eliminar el último
            lista.removeLast();
            System.out.println("\nDespués de removeLast:");
            imprimirLista(lista);

            // Eliminar por valor
            lista.remove("Perro");
            System.out.println("\nDespués de remove(\"Perro\"):");
            imprimirLista(lista);

            // Volver a agregar algunos elementos
            lista.addLast("León", 1);
            lista.addFirst("Elefante", 2);
            lista.addLast("Jirafa", 2);

            System.out.println("\nDespués de agregar más elementos:");
            imprimirLista(lista);

            // Eliminar por prioridad
            lista.removeAllPriority(2);
            System.out.println("\nDespués de removeAllPriority(2):");
            imprimirLista(lista);

            // Recorrer con First y advance
            System.out.println("\nRecorriendo con First y advance:");
            lista.First();
            do {
                System.out.println("Actual: " + lista.getCurrent());
                if (!lista.atEnd()) {
                    lista.advance();
                } else {
                    break;
                }
            } while (true);

            // Mostrar elementos ordenados por prioridad
            System.out.println("\nElementos ordenados por prioridad:");
            Object[] ordenados = lista.sortedByPriority();
            for (Object s : ordenados) {
                System.out.println(s.toString());
            }

        } catch (MyException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void imprimirLista(ArrayPriorityList<Integer, String> lista) {
        lista.First();
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println(" - " + lista.getCurrent());
            if (i < lista.getSize() - 1) {
                lista.advance();
            }
        }
    }
}

