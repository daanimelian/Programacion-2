package clase4.src;
import clase2.src.MyException;
import clase3.LinkedStack;

import static clase4.src.metodos.unirPilas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ArrayPriorityQueue<Integer, String> cola = new ArrayPriorityQueue<>(10);
//
//        cola.insert(5, "Tarea 5");
//        cola.insert(2, "Tarea 2");
//        cola.insert(8, "Tarea 8");
//        cola.insert(1, "Tarea 1");
//        cola.insert(3, "Tarea 3");
//
//        System.out.println("Elementos en orden de prioridad (menor a mayor):");
//
//        while (!cola.isEmpty()) {
//            Entry<Integer, String> entrada = cola.removeMin();
//            System.out.println("Prioridad: " + entrada.getKey() + ", Valor: " + entrada.getValue());
//        }
//
//
//        // Crear la cola de prioridad
//        LinkedPriorityQueue<Integer, String> colaPrioridad = new LinkedPriorityQueue<>();
//
//        // Insertar elementos con diferentes prioridades
//        System.out.println("Insertando elementos:");
//        colaPrioridad.insert(5, "Cinco");
//        colaPrioridad.insert(2, "Dos");
//        colaPrioridad.insert(8, "Ocho");
//        colaPrioridad.insert(1, "Uno");
//        colaPrioridad.insert(3, "Tres");
//
//        // Mostrar el tamaño después de las inserciones
//        System.out.println("Tamaño de la cola de prioridad: " + colaPrioridad.size());
//
//        // Mostrar el mínimo elemento sin removerlo
//        try {
//            System.out.println("Mínimo (sin remover): " + colaPrioridad.min().getValue());
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // Remover y mostrar los elementos en orden
//        System.out.println("\nRemoviendo elementos (por prioridad):");
//        try {
//            while (!colaPrioridad.isEmpty()) {
//                System.out.println("Elemento removido: " + colaPrioridad.removeMin().getValue());
//            }
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // Mostrar el tamaño después de las eliminaciones
//        System.out.println("\nTamaño final de la cola de prioridad: " + colaPrioridad.size());

        LinkedStack<Queue<Integer>> p1 = new LinkedStack<>();
        LinkedStack<Queue<Integer>> p2 = new LinkedStack<>();

        // Crear colas de menor a mayor tamaño y agregarlas a la pila (menor arriba)
        // Pila 1
        p1.push(crearCola(3));          // [3]
        p1.push(crearCola(1, 2));       // [1, 2]
        p1.push(crearCola(4, 5, 6));    // [4, 5, 6]

        // Pila 2
        p2.push(crearCola(9));                  // [9]
        p2.push(crearCola(7, 8));               // [7, 8]
        p2.push(crearCola(10, 11, 12, 13));     // [10, 11, 12, 13]

        // Mostrar pilas antes de unir
        System.out.println("\nContenido de P1 antes de unir:");
        imprimirPilaSinDestruir(p1);

        System.out.println("\nContenido de P2 antes de unir:");
        imprimirPilaSinDestruir(p2);

        // Unir pilas
        LinkedStack<Queue<Integer>> resultado = unirPilas(p1, p2);

        // Mostrar pila unida
        System.out.println("\nContenido de la pila resultante:");
        imprimirPilaSinDestruir(resultado);
    }

    // Crea una cola con los elementos dados
    public static Queue<Integer> crearCola(int... valores) {
        Queue<Integer> cola = new LinkedQueue<>();
        for (int val : valores) {
            cola.enqueue(val);
        }
        return cola;
    }

    // Imprime una pila sin modificar su contenido
    public static void imprimirPilaSinDestruir(LinkedStack<Queue<Integer>> pilaOriginal) {
        LinkedStack<Queue<Integer>> aux = new LinkedStack<>();

        while (!pilaOriginal.isEmpty()) {
            Queue<Integer> cola = pilaOriginal.pop();
            aux.push(cola);

            System.out.print("[ ");
            Queue<Integer> copia = copiarCola(cola);
            while (!copia.isEmpty()) {
                System.out.print(copia.dequeue() + " ");
            }
            System.out.println("]");
        }

        while (!aux.isEmpty()) {
            pilaOriginal.push(aux.pop());
        }
    }

    // Copia una cola sin modificar la original
    public static Queue<Integer> copiarCola(Queue<Integer> original) {
        Queue<Integer> copia = new LinkedQueue<>();
        Queue<Integer> temp = new LinkedQueue<>();

        while (!original.isEmpty()) {
            int val = original.dequeue();
            copia.enqueue(val);
            temp.enqueue(val);
        }

        while (!temp.isEmpty()) {
            original.enqueue(temp.dequeue());
        }

        return copia;
    }

}

