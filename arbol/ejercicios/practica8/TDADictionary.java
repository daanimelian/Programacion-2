package arbol.ejercicios.practica8;
import arbol.ABBClase.ABBImple;
import arbol.ABBClase.ABBTDA;
import arbol.ABBClase.DefaultComparator;
import clase3.src.ArrayList;
import clase5.Dictionary.Dictionary;
import clase5.Dictionary.Entrada;
import clase5.Dictionary.Node;
import clase5.List.LinkedList;

public class TDADictionary<K, V extends Comparable<V>> implements Dictionary<K, V> {
    protected Node<Entrada<K, ABBTDA<V>>, V> head;
    protected Node<Entrada<K, ABBTDA<V>>, V> tail;
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
        Node<Entrada<K, ABBTDA<V>>, V> actual = head;
        while (actual != null && !actual.getElem().getKey().equals(k)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            ABBTDA<V> abb = actual.getElem().getValue();
            ejercicio3<V> recorrido = new ejercicio3<>();
            ArrayList<V> temp = recorrido.elementosInOrder(((ABBImple<V>) abb).getRaiz());
            LinkedList<V> resultado = new LinkedList<>();
            for (int i = 0; i < temp.getSize(); i++) {
                resultado.addLast(temp.get(i));
            }
            return resultado;

        }
        return null;
    }



    @Override
    public void put(K k, V v) {
        if (size == 0) {
            ABBTDA<V> abbValores = new ABBImple<>(new DefaultComparator<V>());
            abbValores.insertar(v);
            Entrada<K, ABBTDA<V>> entrada = new Entrada<>(k, abbValores);
            Node<Entrada<K, ABBTDA<V>>, V> nuevoNodo = new Node<>(entrada, null, null);
            head = nuevoNodo;
            tail = nuevoNodo;
            size++;
        } else {
            Node<Entrada<K, ABBTDA<V>>, V> actual = head;
            while (actual != null && !actual.getElem().getKey().equals(k)) {
                actual = actual.getNext();
            }
            if (actual != null) {
                actual.getElem().getValue().insertar(v);
            } else {
                ABBTDA<V> abbValores = new ABBImple<>(new DefaultComparator<V>());
                abbValores.insertar(v);
                Entrada<K, ABBTDA<V>> entrada = new Entrada<>(k, abbValores);
                Node<Entrada<K, ABBTDA<V>>, V> nuevoNodo = new Node<>(entrada, null, tail);
                tail.setNext(nuevoNodo);
                tail = nuevoNodo;
                size++;
            }
        }
    }



    @Override
    public Iterable<V> remove(K k) {
        Node<Entrada<K, ABBTDA<V>>, V> actual = head;
        while (actual != null && !actual.getElem().getKey().equals(k)) {
            actual = actual.getNext();
        }

        if (actual != null) {
            ABBTDA<V> abb = actual.getElem().getValue();
            ejercicio3<V> recorrido = new ejercicio3<>();
            ArrayList<V> copia = recorrido.elementosInOrder(((ABBImple<V>) abb).getRaiz());

            // eliminar nodo como antes
            if (actual == head) {
                head = head.getNext();
                if (head != null) head.setPrevious(null);
            } else {
                actual.getPrevious().setNext(actual.getNext());
                if (actual.getNext() != null) {
                    actual.getNext().setPrevious(actual.getPrevious());
                } else {
                    tail = actual.getPrevious();
                }
            }

            size--;
            LinkedList<V> resultado = new LinkedList<>();
            for (int i = 0; i < copia.getSize(); i++) {
                resultado.addLast(copia.get(i));
            }
            return resultado;
        }

        return null;
    }


    @Override
    public V remove(K k, V v) {
        Node<Entrada<K, ABBTDA<V>>, V> actual = head;
        while (actual != null && !actual.getElem().getKey().equals(k)) {
            actual = actual.getNext();
        }

        if (actual != null) {
            ABBTDA<V> abb = actual.getElem().getValue();
            V eliminado = abb.eliminar(v);

            if (eliminado != null) {
                ejercicio3<V> recorrido = new ejercicio3<>();
                ArrayList<V> valoresRestantes = recorrido.elementosInOrder(((ABBImple<V>) abb).getRaiz());

                if (valoresRestantes.getSize() == 0) {
                    // eliminar toda la entrada
                    if (actual == head) {
                        head = head.getNext();
                        if (head != null) head.setPrevious(null);
                    } else {
                        actual.getPrevious().setNext(actual.getNext());
                        if (actual.getNext() != null) {
                            actual.getNext().setPrevious(actual.getPrevious());
                        } else {
                            tail = actual.getPrevious();
                        }
                    }
                    size--;
                }

                return eliminado;
            }
        }

        return null;
    }




    @Override
    public Iterable<K> keys() {
        LinkedList<K> claves = new LinkedList<>();
        Node<Entrada<K, ABBTDA<V>>, V> actual = head;
        while (actual != null) {
            claves.addLast(actual.getElem().getKey());
            actual = actual.getNext();
        }
        return claves;
    }


    @Override
    public Iterable<Entrada<K, Iterable<V>>> entries() {
        LinkedList<Entrada<K, Iterable<V>>> entradas = new LinkedList<>();
        Node<Entrada<K, ABBTDA<V>>, V> actual = head;

        while (actual != null) {
            K clave = actual.getElem().getKey();
            ABBTDA<V> abb = actual.getElem().getValue();

            ejercicio3<V> recorrido = new ejercicio3<>();
            ArrayList<V> arrayValores = recorrido.elementosInOrder(((ABBImple<V>) abb).getRaiz());

            // Convertir manualmente a LinkedList
            LinkedList<V> copiaValores = new LinkedList<>();
            for (int i = 0; i < arrayValores.getSize(); i++) {
                copiaValores.addLast(arrayValores.get(i));
            }

            entradas.addLast(new Entrada<>(clave, copiaValores));
            actual = actual.getNext();
        }

        return entradas;
    }


}
