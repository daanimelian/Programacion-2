package clase2.src;

import java.util.Objects;

public class LinkedList<T> implements List<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;
    protected Node<T> current;

    public LinkedList() {}

    private void addFirst(Node<T> n) {
        if (this.size == 0) {
            this.head = n;
            this.tail = n;
            n.setPrev(null);
            n.setNext(null);
        } else {
            n.setNext(this.head);
            this.head.setPrev(n);
            n.setPrev(null);
            this.head = n;
        }
        ++this.size;
    }

    public void addFirst(T temp) {
        Node<T> aux = new Node<>(temp);
        this.addFirst(aux);
    }


    private void addLast(Node<T> n) {
        if (this.size == 0) {
            this.head = n;
            this.tail = n;
            n.setPrev(null);
            n.setNext(null);
        } else {
            this.tail.setNext(n);
            n.setPrev(this.tail);
            n.setNext(null);
            this.tail = n;
        }

    ++this.size;
    }

    public void addLast(T temp) {
        Node<T> aux = new Node<>(temp);
        this.addLast(aux);
    }


    public void removeFirst() {
            if (this.head == null) {
                throw new MyException("List is empty");
            }

            if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> newHead = this.head.getNext();
                this.head.setNext(null);
                this.head.setPrev(null); // Por si acaso
                this.head = newHead;
                this.head.setPrev(null);
            }

            --this.size;
        }



    public void removeLast() {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;

        }
        else {
            Node<T> newTail = this.tail.getPrev();
            this.tail.setNext(null);
            this.tail.setPrev(null);
            newTail.setNext(null);
            this.tail = newTail;
        }

        this.size--;
    }


    public void removeElement(T o) {
        if (this.head == null) {
            throw new MyException("List is empty");
        }

        if (Objects.equals(this.head.data, o)) {
            this.removeFirst();
            return;
        }

        if (Objects.equals(this.tail.data, o)) {
            this.removeLast();
            return;
        }

        Node<T> curr = this.head.getNext();

        while (curr != null && !Objects.equals(curr.data, o)) {
            curr = curr.getNext();
        }

        if (curr == null) {
            throw new MyException("Element not found");
        }

        // reconectar los nodos anterior y siguiente
        Node<T> prev = curr.getPrev();
        Node<T> next = curr.getNext();

        prev.setNext(next);
        if (next != null) {
            next.setPrev(prev);
        }

        curr.setNext(null);
        curr.setPrev(null);
        --this.size;
    }



    @Override
    public T getFirst() {
       return this.getHead().data;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    @Override
    public T getLast() {
        return this.getTail().data;
    }

    @Override
    public T getCurrent() {
        return this.current.data;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public Node<T> getNodeByIndex(int index) {
        if (this.head == null) {
            throw new MyException("List is empty");
        }

        if(this.getSize()<=index){
                throw new MyException("Index out of bounds");
            }
        Node<T> aux = this.head;
        for(int i=0; i < index;i++) {
            aux = aux.getNext();

        }
        return aux;
    }

    /*Sobre la implementación de LinkedList, agregar métodos que le
permitan al usuario “indexar” la lista:
• elementAt(int pos): devuelve el elemento ubicado en la posición pos, considerando el
primer elemento como la posición 0.
• removeAt(int pos): elimina el elemento ubicado en la posición pos, considerando el
primer elemento como la posición 0.*/

    public Node<T> elementAt(int pos){
        Node<T> aux = this.head;
        for(int a=0;a < pos; a++ ){
            aux = aux.getNext();
        }
        return aux;

    }

    public void removeElementAt(int pos){
            if (pos < 0 || pos >= size) {
                throw new IndexOutOfBoundsException("Posición fuera de rango: " + pos);
            }

            Node<T> aux = head;
            for (int i = 0; i < pos; i++) {
                aux = aux.getNext();
            }

            if (aux == head) {
                head = aux.getNext();
                if (head != null) {
                    head.setPrev(null);
                }
            } else {
                aux.getPrev().setNext(aux.getNext());
            }

            if (aux == tail) {
                tail = aux.getPrev();
                if (tail != null) {
                    tail.setNext(null);
                }
            } else {
                aux.getNext().setPrev(aux.getPrev());
            }

            aux.setNext(null);
            aux.setPrev(null);
            size--;
        }

    }
