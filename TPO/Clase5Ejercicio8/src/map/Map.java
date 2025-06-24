package TPO.Clase5Ejercicio8.src.map;


import TPO.Clase5Ejercicio8.src.list.List;


public class Map<K extends Comparable<K>,V> {
	private int size;
	private Nodo<Entrada<K,V>> head;
	private Nodo<Entrada<K,V>> tail;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public List<V> get(K key) {
		Nodo<Entrada<K,V>> aux;
		List<V> resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
			}else {
				aux = aux.getNext();				
			}
		}
		return resul;
	}
	
	public void put(K key, V value) {
		Nodo<Entrada<K,V>> aux;
		List<V> resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
				aux.getValue().getValue().addElementEnd(value);;
			}else {
				aux = aux.getNext();				
			}
		}
		
		if (resul == null) {
			List<V> auxList = new List<V>();
			auxList.addElementEnd(value);
			Entrada<K,V> nuevaEntry = new Entrada<K,V>(key, auxList);
		    Nodo<Entrada<K,V>> nuevoNodo = new Nodo<Entrada<K,V>>(nuevaEntry);

		    if (isEmpty()) {
		        head = tail = nuevoNodo;
		    } else {
		        tail.setNext(nuevoNodo);
		        tail = nuevoNodo;
		    }
		    size++;
		}
	}
	
	public V remove(K key, V value) {
		Nodo<Entrada<K,V>> aux;
		V resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				if(aux.getValue().getValue().contains(value)) {
					resul = aux.getValue().getValue().removeElement(value);
				}
			}
			aux = aux.getNext();
		}
				
		return resul;
	}
	
	public List<V> remove(K key) {
		Nodo<Entrada<K,V>> aux;
		List<V> resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
				
				if(size == 1) {
					head = null;
					tail = null;
				}else {
					if(aux == head) {
						aux.getNext().setPrev(null);
						head = aux.getNext();
					}else if(aux == tail) {
						aux.getPrev().setNext(null);
						tail = aux.getPrev();
					}else {
						aux.getNext().setPrev(aux.getPrev());
						aux.getPrev().setNext(aux.getNext());
					}					
				}
				
				size--;
			}
			aux = aux.getNext();	
		}
		
		return resul;
	}
	
	public List<K> keys(){
		Nodo<Entrada<K,V>> aux;
		List<K> resul = new List<K> ();
		aux = head;
		while(aux != null) {
			resul.addElementEnd(aux.getValue().getKey()); 
			aux = aux.getNext();		
		}
		return resul;
	}

	
	public List<Entrada<K,V>> entries(){
		Nodo<Entrada<K,V>> aux;
		List<Entrada<K,V>> resul = new List<Entrada<K,V>> ();
		aux = head; 
		while(aux != null) {
			resul.addElementEnd(aux.getValue());
			aux = aux.getNext();		
		}
		return resul;
	}
}

