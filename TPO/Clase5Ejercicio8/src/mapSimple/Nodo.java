package TPO.Clase5Ejercicio8.src.mapSimple;
 

public class Nodo<T> {
	private Nodo<T> next;
	private Nodo<T> prev;
	private T valor;
		
	public Nodo(T valor) {
		this.valor = valor;
		this.next = null;
		this.prev = null;
	}
	
	public Nodo<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Nodo<T> nodo) {
		this.prev = nodo;
	}
	
	public Nodo<T> getNext() {
		return next;
	}
	
	public void setNext(Nodo<T> nodo) {
		this.next = nodo;
	}
	
	public T getValue() {
		return valor;
	}
}
