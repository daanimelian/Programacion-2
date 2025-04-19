package clase4.src;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public interface PriorityQueue<K extends Comparable<K>, V> {
    int size();

    boolean isEmpty();

    Entry<K, V> min();

    void insert(K var1, V var2);

    Entry<K, V> removeMin();
}
