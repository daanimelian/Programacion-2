package arbol.ejercicios.practica8;

import arbol.ABBClase.NodoABB;
import clase3.ArrayList;

public class ejercicio3<E extends Comparable<E>> {

    public ArrayList<E> elementosInOrder(NodoABB<E> nodov) {
        ArrayList<E> elementos = new ArrayList<>(100);
        recorrerIn(nodov, elementos);
        return elementos;
    }

    private void recorrerIn(NodoABB<E> nodo, ArrayList<E> elementos) {
        if (nodo != null && nodo.getElemento() != null) {
            recorrerIn(nodo.getIzq(), elementos);
            elementos.addLast(nodo.getElemento());
            recorrerIn(nodo.getDer(), elementos);
        }
    }

    public ArrayList<E> elementosPreOrder(NodoABB<E> nodov) {
        ArrayList<E> elementos = new ArrayList<>(100);
        recorrerPre(nodov, elementos);
        return elementos;
    }

    private void recorrerPre(NodoABB<E> nodo, ArrayList<E> elementos) {
        if (nodo != null && nodo.getElemento() != null) {
            elementos.addLast(nodo.getElemento());
            recorrerPre(nodo.getIzq(), elementos);
            recorrerPre(nodo.getDer(), elementos);
        }
    }

    public ArrayList<E> elementosPostOrder(NodoABB<E> nodov) {
        ArrayList<E> elementos = new ArrayList<>(100);
        recorrerPost(nodov, elementos);
        return elementos;
    }

    private void recorrerPost(NodoABB<E> nodo, ArrayList<E> elementos) {
        if (nodo != null && nodo.getElemento() != null) {
            recorrerPost(nodo.getIzq(), elementos);
            recorrerPost(nodo.getDer(), elementos);
            elementos.addLast(nodo.getElemento());
        }
    }
}
