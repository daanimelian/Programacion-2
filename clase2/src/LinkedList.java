package clase2.src;

import java.util.Objects;

public class LinkedList<T> implements List<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;
    protected Node<T> current;

    public LinkedList() {}

    private void addFirst(Node<T> n) {
        n.setNext(this.head);
        this.head = n;
        if (this.size == 0) {
            this.tail = n;
        }
        ++this.size;
    }

    public void addFirst(T temp) {
        Node<T> aux = new Node(temp);
        this.addFirst(aux);
    }


    private void addLast(Node<T> n) {
        if (this.head == null) {
            this.head = n;
            this.tail = n;
        }
        else {
            Node<T> aux;
            for(aux=this.head; aux.getNext()!=null; aux=aux.getNext()) {

            }
            aux.setNext(n);
            this.tail = n;
        }

    ++this.size;
    }

    public void addLast(T temp) {
        Node<T> aux = new Node(temp);
        this.addLast(aux);
    }


    public void removeFirst() {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else {
            Node<T> aux = this.head.getNext();
            this.head.setNext(null);
            this.head = aux;
            --this.size;
            if (this.size == 1) {
                this.tail = aux;
            }
        }
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
            Node<T> aux = this.head;
            for (Node<T> aux2=aux.getNext();aux2.getNext() !=null; aux2 = aux2.getNext()) {
                aux=aux2;
            }
            aux.setNext(null);
            this.tail = aux;
        }

        this.size--;
    }


    public void removeElement(T o) {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else {
            if (Objects.equals(this.head.data, o)){
                this.removeFirst();
                return;
            }
            if(Objects.equals(this.tail.data, o)){
                this.removeLast();
                return;
            }
            else {
                Node<T> prev = this.head;
                Node<T> curr = this.head.getNext();

                while (curr != null && !curr.data.equals(o)) {
                    prev = curr;
                    curr = curr.getNext();
                }


                if (curr==null){
                    throw new MyException("Element not found");
                }
                else {
                    prev.setNext(curr.getNext());
                    curr.setNext(null);
                    --this.size;
                }

            }
        }

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
}
