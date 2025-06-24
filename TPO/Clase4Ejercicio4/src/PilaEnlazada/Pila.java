package TPO.Clase4Ejercicio4.src.PilaEnlazada;

public class Pila<T> implements Stack<T> {

	private Nodo<T> top;
	private int size;
	
	public Pila() {
		this.top = null;
		this.size = 0;
	}
	
	public void push(T item) {
		 Nodo<T> aux = new Nodo<T>(item);
		if(!isEmpty()) {
			aux.setNext(top);
		}
		top = aux;
		size++;
	}

	public T pop() {	
		if(isEmpty()) {
			return null;
		}
		Nodo<T> aux = top;
		top = top.getNext();
		size --;
		return aux.getValue();
	}

	public T top() {
		if(isEmpty()) {
			return null;
		}
		return top.getValue();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

}
