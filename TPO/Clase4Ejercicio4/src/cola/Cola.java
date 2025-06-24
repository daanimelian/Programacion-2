package TPO.Clase4Ejercicio4.src.cola;

public class Cola<Q> implements Queue<Q> {
	private Nodo<Q> head;
	private Nodo<Q> back;
	private int size;
	
	public void enqueue(Q element) {
		Nodo<Q> aux = new Nodo<Q>(element);
		if(isEmpty()) {
			head = aux;
		}else {
			back.setNext(aux);
		}
		
		back = aux;
		size++;
	}
	
	public Q dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Cola Vacia, no hay elemento para sacar de la cola"); 
		}
		Nodo<Q> aux = head;
		head = head.getNext();
		size--;
		if (isEmpty()) {
			back = null; 
		}

		return aux.getValue();
	}
	
	public Q front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Cola Vacia, no hay elemento para mostrar"); 
		}
		return head.getValue();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
