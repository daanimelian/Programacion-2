//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package clase4.src;

import clase2.src.MyException;

public class LinkedPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    protected Node<Entrada<K, V>> head = null;
    protected Node<Entrada<K, V>> tail = null;
    protected int size = 0;

    public LinkedPriorityQueue() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Entry<K, V> min() throws MyException {
        if (this.isEmpty()) {
            throw new MyException("Esta vacia");
        } else {
            return (Entry)this.head.getElement();
        }
    }

    public Entry<K, V> removeMin() throws MyException {
        if (this.size == 0) {
            throw new MyException("Esta vacia");
        } else {
            Entrada<K, V> salida = (Entrada)this.head.getElement();
            this.head = this.head.getNext();
            --this.size;
            return salida;
        }
    }

    public void insert(K key, V value) {
        Entrada<K, V> elementoNodo = new Entrada(key, value);
        Node<Entrada<K, V>> nuevoNodo = new Node(elementoNodo, (Node)null);
        if (this.size != 0 && ((Entrada)this.head.getElement()).getKey().compareTo(key) <= 0) {
            Node<Entrada<K, V>> actual;
            for(actual = this.head; actual.getNext() != null && ((Entrada)actual.getNext().getElement()).getKey().compareTo(key) < 1; actual = actual.getNext()) {
            }

            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        } else {
            nuevoNodo.setNext(this.head);
            this.head = nuevoNodo;
        }

        ++this.size;
    }
}
