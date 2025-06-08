package arbol.ejercicios.practica8;

import arbol.ABBClase.NodoABB;
import clase3.ArrayList;

public class ejercicio4<E extends Comparable<E>> {

    public E min(NodoABB<E> nodov) {
        ejercicio3<E> ejercicio3 = new ejercicio3<>();
        ArrayList<E> elementos = ejercicio3.elementosInOrder(nodov);

        if (elementos.getSize() > 0) {
            return elementos.get(0);  // Mínimo
        } else {
            return null;
        }
    }
}
