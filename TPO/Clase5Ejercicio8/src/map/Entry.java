package TPO.Clase5Ejercicio8.src.map;


import TPO.Clase5Ejercicio8.src.list.List;

public interface Entry <K extends Comparable<K>,V> {
	public K getKey();
	public List<V> getValue();
	public void setKey(K key);
	public void setValue(List<V> value);
	public String toString();
}
