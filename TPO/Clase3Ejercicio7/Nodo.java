package TPO.Clase3Ejercicio7;

public class Nodo<T> {
	private Nodo<T> next;
	private T valor;
		
	public Nodo(T valor) {
		this.valor = valor;
		this.next = null;
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
