package clase4.src;

public interface Entry<K extends Comparable<K>,V>
{
    public K getKey();
    public V getValue();
}

