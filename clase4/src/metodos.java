package clase4.src;
import clase3.src.LinkedStack;
public class metodos {

//    Implemente un método que reciba dos pilas de colas de enteros P1 y P2, y retorne
//    una nueva pila de colas Pout que sea la unión de los elementos de P1 y P2. Cabe
//    aclarar que los elementos de P1 y P2 están ordenados de menor a mayor en
//    función de su tamaño, y que la pila Pout debe quedar ordenada del mismo modo.
//    En el tope de las pilas se encuentra el elemento de mayor tamaño. Resuelva el
//    problema planteado exclusivamente en términos de las operaciones de los TDA
//    Pila y TDACola.

    public static LinkedStack<Queue<Integer>> unirPilas(LinkedStack<Queue<Integer>> p1, LinkedStack<Queue<Integer>> p2) {
        LinkedStack<Queue<Integer>> aux = new LinkedStack<>();
        LinkedStack<Queue<Integer>> pout = new LinkedStack<>();

        while (!p1.isEmpty() || !p2.isEmpty()) {
            Queue<Integer> elem = p1.pop();
            Queue<Integer> elem2 = p2.pop();
            while(!elem2.isEmpty()) {
                Integer num = elem2.dequeue();
                elem.enqueue(num);
            }
            aux.push(elem);

        }

        while(!aux.isEmpty()) {
            Queue<Integer> elem = aux.pop();
            pout.push(elem);
        }

        return pout;
    }


}
