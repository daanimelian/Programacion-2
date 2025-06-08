package arbol.ejercicios.practica8;
import arbol.ABBClase.ABBImple;
import clase3.ArrayList;
import clase5.Dictionary.Dictionary;
import clase5.Dictionary.Entrada;
import clase5.Dictionary.Node;
import clase5.List.LinkedList;
import clase5.List.MyException;

public class TDADictionary<K, V extends Comparable<V>> implements Dictionary<K, V> {

    ejercicio3 ejercicio3 = new ejercicio3();
    protected Node<Entrada<K, ABBImple<V>>, V> head;
    protected Node<Entrada<K, ABBImple<V>>, V> tail;
    protected int size;

    public TDADictionary() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterable<V> get(K k) {
        if (size == 0) {
            return null;
        }
        Node<Entrada<K, ABBImple<V>>, V> actual = head;
        while (actual != null && !actual.getElem().getKey().equals(k)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            ABBImple<V> listaValores = actual.getElem().getValue();
            ArrayList<V> copiaValores = ejercicio3.elementosInOrder(listaValores.getRaiz());
            return (Iterable<V>) copiaValores;
        }
        else {
            return null;
        }
    }

    @Override
    public void put(K k, V v) {
        // TODO Auto-generated method stub
        if (size == 0) {
            List<V> listaValores = new LinkedList<V>();
            listaValores.addFirst(v);
            Entrada<K, List<V>> entrada = new Entrada<K, List<V>>(k, listaValores);
            Node<Entrada<K, List<V>>, V> nuevoNodo = new Node<Entrada<K, List<V>>, V>(entrada, null, null);
            head = nuevoNodo;
            tail = nuevoNodo;
            size++;
        }
        else if (head.getElem().getKey().equals( k)) {
            head.getElem().getValue().addLast(v);
        }
        else {
            Node<Entrada<K, List<V>>, V> actual = head;
            while (actual != null && !actual.getElem().getKey().equals(k)) {
                actual = actual.getNext();
            }
            if (actual != null) {
                actual.getElem().getValue().addLast(v);
            }
            else {
                List<V> listaValores = new LinkedList<V>();
                listaValores.addFirst(v);
                Entrada<K, List<V>> entrada = new Entrada<K, List<V>>(k, listaValores);
                Node<Entrada<K, List<V>>, V> nuevoNodo = new Node<Entrada<K, List<V>>, V>(entrada, null, tail);
                tail.setNext(nuevoNodo);
                tail = nuevoNodo;
                size++;
            }
        }
    }

    @Override
    public Iterable<V> remove(K k) {
        // TODO Auto-generated method stub
        if (size == 0) {
            return null;
        }
        if (head.getElem().getKey().equals( k)) {
            List<V> listaValores = head.getElem().getValue();
            LinkedList<V> copiaValores = new LinkedList<V>();
            listaValores.First();
            while (!listaValores.atEnd()) {
                copiaValores.addLast(listaValores.getCurrent());
                listaValores.advance();
            }
            head.getNext().setPrevious(null);
            head = head.getNext();
            size--;
            return copiaValores;
        }
        Node<Entrada<K, List<V>>, V> actual = head;
        while (actual != null && actual.getElem().getKey().equals(k)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            List<V> listaValores = actual.getElem().getValue();
            LinkedList<V> copiaValores = new LinkedList<V>();
            listaValores.First();
            while (!listaValores.atEnd()) {
                copiaValores.addLast(listaValores.getCurrent());
                listaValores.advance();
            }
            actual.getPrevious().setNext(actual.getNext());
            if (actual.getNext() != null) {
                actual.getNext().setPrevious(actual.getPrevious());
            }
            else {
                tail = actual.getPrevious();
            }
            size--;
            return copiaValores;
        }
        else {
            return null;
        }
    }

    @Override
    public V remove(K k, V v) {
        // TODO Auto-generated method stub
        if (size == 0) {
            return null;
        }
        Node<Entrada<K, List<V>>, V> actual = head;
        while (actual != null && actual.getElem().getKey() != k) {
            actual = actual.getNext();
        }
        if (actual != null) {
            List<V> listaValores = actual.getElem().getValue();
            try {
                listaValores.remove(v);
                if (listaValores.getSize() == 0) {
                    actual.getPrevious().setNext(actual.getNext());
                    if (actual.getNext() != null) {
                        actual.getNext().setPrevious(actual.getPrevious());
                    }
                    else {
                        tail = actual.getPrevious();
                    }
                    size--;
                }
                return v;
            }
            catch (MyException e) {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public Iterable<K> keys() {
        // TODO Auto-generated method stub
        LinkedList<K> claves = new LinkedList<K>();
        Node<Entrada<K, List<V>>, V> actual = head;
        while (actual != null) {
            claves.addLast(actual.getElem().getKey());
            actual = actual.getNext();
        }
        return claves;
    }

    @Override
    public Iterable<Entrada<K, Iterable<V>>> entries() {
        // TODO Auto-generated method stub
        LinkedList<Entrada<K, Iterable<V>>> entradas = new LinkedList<Entrada<K, Iterable<V>>>();
        Node<Entrada<K, List<V>>, V> actual = head;
        while (actual != null) {
            List<V> listaValores = actual.getElem().getValue();
            LinkedList<V> copiaValores = new LinkedList<V>();
            listaValores.First();
            while (!listaValores.atEnd()) {
                copiaValores.addLast(listaValores.getCurrent());
                listaValores.advance();
            }
            entradas.addLast(new Entrada<K, Iterable<V>>(actual.getElem().getKey(), copiaValores));
            actual = actual.getNext();
        }
        return entradas;
    }
}
