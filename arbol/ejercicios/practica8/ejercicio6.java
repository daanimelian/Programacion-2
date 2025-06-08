package arbol.ejercicios.practica8;

import arbol.ABBClase.NodoABB;

public class ejercicio6<E extends Comparable<E>>{

    public int altura(NodoABB<E> nodo) {
        if (nodo == null || nodo.getElemento() == null) {
            return 0;
        }

        int alturaIzq = altura(nodo.getIzq());
        int alturaDer = altura(nodo.getDer());

        if (alturaIzq > alturaDer) {
            return 1 + alturaIzq;
        } else {
            return 1 + alturaDer;
        }
    }

}
