package TPO.Clase5Ejercicio8.src.mapSimple;

public class Entrada <K extends Comparable<K>,V>{

	private K key;
	private V value;
	
	public Entrada(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	
	public K getKey() { 
		return key;
	}

	public V getValue() { 
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public String toString() {
		return "(" + getKey() + "\t" + getValue() + "\t)" ;
	}
}

