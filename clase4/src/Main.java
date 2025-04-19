package clase4.src;
import clase2.src.MyException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayPriorityQueue<Integer, String> cola = new ArrayPriorityQueue<>(10);

        cola.insert(5, "Tarea 5");
        cola.insert(2, "Tarea 2");
        cola.insert(8, "Tarea 8");
        cola.insert(1, "Tarea 1");
        cola.insert(3, "Tarea 3");

        System.out.println("Elementos en orden de prioridad (menor a mayor):");

        while (!cola.isEmpty()) {
            Entry<Integer, String> entrada = cola.removeMin();
            System.out.println("Prioridad: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }


        // Crear la cola de prioridad
        LinkedPriorityQueue<Integer, String> colaPrioridad = new LinkedPriorityQueue<>();

        // Insertar elementos con diferentes prioridades
        System.out.println("Insertando elementos:");
        colaPrioridad.insert(5, "Cinco");
        colaPrioridad.insert(2, "Dos");
        colaPrioridad.insert(8, "Ocho");
        colaPrioridad.insert(1, "Uno");
        colaPrioridad.insert(3, "Tres");

        // Mostrar el tamaño después de las inserciones
        System.out.println("Tamaño de la cola de prioridad: " + colaPrioridad.size());

        // Mostrar el mínimo elemento sin removerlo
        try {
            System.out.println("Mínimo (sin remover): " + colaPrioridad.min().getValue());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Remover y mostrar los elementos en orden
        System.out.println("\nRemoviendo elementos (por prioridad):");
        try {
            while (!colaPrioridad.isEmpty()) {
                System.out.println("Elemento removido: " + colaPrioridad.removeMin().getValue());
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el tamaño después de las eliminaciones
        System.out.println("\nTamaño final de la cola de prioridad: " + colaPrioridad.size());
    }
    }
