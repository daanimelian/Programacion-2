package clase4.src;
import clase3.ArrayStack;
import clase3.Stack;
import clase3.LinkedStack;
public class metodos {

//    Implemente un método que reciba dos pilas de colas de enteros P1 y P2, y retorne
//    una nueva pila de colas Pout que sea la unión de los elementos de P1 y P2. Cabe
//    aclarar que los elementos de P1 y P2 están ordenados de menor a mayor en
//    función de su tamaño, y que la pila Pout debe quedar ordenada del mismo modo.
//    En el tope de las pilas se encuentra el elemento de mayor tamaño. Resuelva el
//    problema planteado exclusivamente en términos de las operaciones de los TDA
//    Pila y TDACola.

    public static Stack<Queue<Integer>> unirPilas(Stack<Queue<Integer>> p1, Stack<Queue<Integer>> p2) {
        Stack<Queue<Integer>> aux = new LinkedStack<>();
        Stack<Queue<Integer>> pout = new LinkedStack<>();

        while (!p1.isEmpty() && !p2.isEmpty()) {
            Queue<Integer> q1 = p1.pop();
            Queue<Integer> q2 = p2.pop();

            int size1 = contarYRestaurar(q1);
            int size2 = contarYRestaurar(q2);

            if (size1 < size2) {
                aux.push(q2);
                pout.push(q1);
            } else {
                aux.push(q1);
                pout.push(q2);
            }
        }

        while (!p1.isEmpty()) {
            pout.push(p1.pop());
        }

        while (!p2.isEmpty()) {
            pout.push(p2.pop());
        }

        // Restauramos aux si hizo falta usarlo
        while (!aux.isEmpty()) {
            pout.push(aux.pop());
        }

        return pout;
    }

    public static int contarYRestaurar(Queue<Integer> q) {
        int count = 0;
        Queue<Integer> aux = new ArrayQueue<>(100); // o LinkedQueue

        while (!q.isEmpty()) {
            int elemento = q.dequeue();
            aux.enqueue(elemento);
            count++;
        }

        // Restauramos la cola original
        while (!aux.isEmpty()) {
            q.enqueue(aux.dequeue());
        }

        return count;
    }


}
