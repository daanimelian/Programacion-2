package arbol.ejercicios.practica9;

import arbol.AVLClase.AVL;
import arbol.AVLClase.NodoAVL;
import clase4.src.LinkedQueue;

public class ejercicio4<E extends Comparable<E>> {
    public void imprimirPorNiveles(AVL<E> arbol) {
        NodoAVL<E>  root = arbol.getRoot();
        if (root == null) {
            System.out.println("Árbol vacío.");
            return;
        }

        LinkedQueue<NodoAVL<E>> cola = new LinkedQueue<>();
        cola.enqueue(root);

        while (!cola.isEmpty()) {
            int cantidadEnNivel = cola.size();

            for (int i = 0; i < cantidadEnNivel; i++) {
                NodoAVL<E> actual = cola.dequeue();
                System.out.print(actual.getElemento()+ " ");

                if (actual.getIzq() != null) {
                    cola.enqueue(actual.getIzq());
                }
                if (actual.getDer() != null) {
                    cola.enqueue(actual.getDer());
                }
            }

            System.out.println();
        }
    }

}
