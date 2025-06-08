package arbol.ejercicios.practica9;

import arbol.AVLClase.AVL;
import arbol.AVLClase.NodoAVL;

public class ejercicio5<E extends Comparable<E>> {
    public int altura(AVL<E> arbol) {
        return calcularAltura(arbol.getRoot());
    }

    private int calcularAltura(NodoAVL<E> nodo) {
        if (nodo == null) return -1; // Por convención: árbol vacío tiene altura -1
        int altIzq = calcularAltura(nodo.getIzq());
        int altDer = calcularAltura(nodo.getDer());
        return (altIzq > altDer ? altIzq : altDer) + 1;
    }

}
