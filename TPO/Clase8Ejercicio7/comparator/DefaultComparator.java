package TPO.Clase8Ejercicio7.comparator;

public class DefaultComparator <T> implements java.util.Comparator<T>{
    public int compare( T a, T b ) {
        return((Comparable)a).compareTo(b); }
}
