package TPO.Clase9Ejercicio6.AVL;

public interface AVLTDA <E extends Comparable<E>> {
	public boolean exists( E elemento );
	public void insert( E elemento );
	public void delete( E elemento );
	public String toString();
}
