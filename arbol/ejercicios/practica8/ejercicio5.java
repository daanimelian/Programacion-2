package arbol.ejercicios.practica8;
import arbol.ABBClase.NodoABB;
import clase4.src.LinkedQueue;

public class ejercicio5<E extends Comparable<E>> {
    //Cree un método que imprima el ABB por niveles.
    public void imprimirNiveles(NodoABB<E> nodo) {
        if (nodo == null || nodo.getElemento() == null) {
            System.out.println("Árbol vacío.");
            return;
        }

        LinkedQueue<NodoABB<E>> cola = new LinkedQueue<>();
        cola.enqueue(nodo);

        while (!cola.isEmpty()) {
            int cantidadEnNivel = cola.size();

            for (int i = 0; i < cantidadEnNivel; i++) {
                NodoABB<E> actual = cola.dequeue();
                System.out.print(actual.getElemento() + " ");

                if (actual.getIzq() != null && actual.getIzq().getElemento() != null) {
                    cola.enqueue(actual.getIzq());
                }
                if (actual.getDer() != null && actual.getDer().getElemento() != null) {
                    cola.enqueue(actual.getDer());
                }
            }

            System.out.println();

        }
    }

}


