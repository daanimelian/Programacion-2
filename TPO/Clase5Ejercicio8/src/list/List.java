package TPO.Clase5Ejercicio8.src.list;

public class List<T> {
	private Nodo<T> head;
	private Nodo<T> tail;
	private int size;
	
	public List() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addElementEnd(T element) {
		Nodo<T> aux = new  Nodo<T>(element);
		if(isEmpty()) {
			head = tail = aux;
		}else {
			tail.setNext(aux);
			aux.setPrev(tail);
			tail = aux;
		}
		
		size ++;
	}
	
	public void addElementBegining(T element) {
		Nodo<T> aux = new  Nodo<T>(element);
		if(isEmpty()) {
			head = tail = aux;
		}else {
			head.setPrev(aux);
			aux.setNext(head);
			head = aux;
		}
		
		size ++;
	}
	
	public T removeElement(T element) {
		T resul = null;
		Nodo<T> aux = head; 
		while(aux != null && resul == null) {
			
			if(aux.getValue().equals(element)) {
				resul = aux.getValue();
				
				if (aux.getPrev() != null) {
	                aux.getPrev().setNext(aux.getNext());
	            } else {
	                head = aux.getNext();
	            }
				
				if (aux.getNext() != null) {
	                aux.getNext().setPrev(aux.getPrev());
	            } else {
	                tail = aux.getPrev();
	            }
				size--;
				
			}
			aux = aux.getNext();
		}
		return resul;
	}
	
	public T getAtEnd() {
		T resul = null;
		if(!isEmpty()) {
			resul = tail.getValue();
		}
		return resul;
	}
	
	public T getAt(int i) {
		T resul = null;
		Nodo<T> aux;
		if((i < size() && i >= 0) && !isEmpty()) {
			if(i == 0) {
				resul = head.getValue();
			}else if (i == size()-1) {
				resul = tail.getValue();
			}else {
				aux = head;
				while(i > 0) {
					aux = aux.getNext();
					i--;
				}
				resul = aux.getValue();
			}
		}
		return resul;
	}
	
	public boolean contains(T element) {
		T elementAux = null;
		boolean resul = false;
		Nodo<T> aux = head; 
		while(aux != null && elementAux == null) {
			if(aux.getValue() == element) {
				resul = true;
			}
			aux = aux.getNext();
		}
		return resul;
	}
}
