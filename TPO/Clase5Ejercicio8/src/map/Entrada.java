package TPO.Clase5Ejercicio8.src.map;


import TPO.Clase5Ejercicio8.src.list.List;

public class Entrada <K extends Comparable<K>,V> implements Entry<K,V> {

	private K key;
	private List<V> value;
	
	public Entrada(K key, List<V> value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() { 
		return key;
	}

	@Override
	public List<V> getValue() { 
		return value;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public void setValue(List<V> value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + getKey() + "," + getValue() + ")" ;
	}
}
