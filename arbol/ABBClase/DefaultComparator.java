package arbol.ABBClase;

public class DefaultComparator<E> implements java.util.Comparator<E> {

    public int compare( E a, E b ) { return((Comparable)a).compareTo(b); }
}
