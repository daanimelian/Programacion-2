package TPO.Clase4Ejercicio4.src.PilaEnlazada;

public interface Stack<T> {
	public void push(T item);
	public T pop();
	public T top();
	public boolean isEmpty();
	public int size();
}
