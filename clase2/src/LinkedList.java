package clase2.src;

import java.util.Objects;

public class LinkedList implements List {
    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;
    protected Node current;

    public LinkedList() {}

    private void addFirst(Node n) {
        n.setNext(this.head);
        this.head = n;
        if (this.size == 0) {
            this.tail = n;
        }
        ++this.size;
    }

    public void addFirst(Float temp) {
        Node aux = new Node(temp);
        this.addFirst(aux);
    }


    private void addLast(Node n) {
        if (this.head == null) {
            this.head = n;
            this.tail = n;
        }
        else {
            Node aux;
            for(aux=this.head; aux.getNext()!=null; aux=aux.getNext()) {

            }
            aux.setNext(n);
            this.tail = n;
        }

    ++this.size;
    }

    public void addLast(Float temp) {
        Node aux = new Node(temp);
        this.addLast(aux);
    }


    public void removeFirst() {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else {
            Node aux = this.head.getNext();
            this.head.setNext((Node)null);
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
            Node aux = this.head;
            for (Node aux2=aux.getNext();aux2.getNext() !=null; aux2 = aux2.getNext()) {
                aux=aux2;
            }
            aux.setNext((Node)null);
            this.tail = aux;
        }

        this.size--;
    }


    public void removeElement(Float o) {
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
                Node prev = this.head;
                Node curr = this.head.getNext();

                while (curr != null && !curr.data.equals(o)) {
                    prev = curr;
                    curr = curr.getNext();
                }


                if (curr==null){
                    throw new MyException("Element not found");
                }
                else {
                    prev.setNext(curr.getNext());
                    curr.setNext((Node)null);
                    --this.size;
                }

            }
        }

    }


    @Override
    public Float getFirst() {
       return this.getHead().data;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    @Override
    public Float getLast() {
        return this.getTail().data;
    }

    @Override
    public Float getCurrent() {
        return this.current.data;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public Node getNodeByIndex(int index) {
        if (this.head == null) {
            throw new MyException("List is empty");
        }

        if(this.getSize()<=index){
                throw new MyException("Index out of bounds");
            }
        Node aux = this.head;
        for(int i=0; i < index;i++) {
            aux = aux.getNext();

        }
        return aux;
    }
}
