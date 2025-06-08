package arbol.ejercicios.practica9;

import arbol.AVLClase.AVL;

public class ejercicio3 <E extends Comparable<E>> {

    public E minimo(AVL<E> arbol) {
        return arbol.min();  // llama directamente al método min() del AVL
    }

}
