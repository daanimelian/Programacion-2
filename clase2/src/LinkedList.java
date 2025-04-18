package clase2.src;

public class LinkedList implements List {
    protected Node head = null;
    protected int size = 0;
    protected Node current;

    public LinkedList() {}

    private void addFirst(Node n) {
        n.setNext(this.head);
        this.head = n;
        ++this.size;
    }

    public void addFirst(Float temp) {
        Node aux = new Node(temp);
        this.addFirst(aux);
    }


    private void addLast(Node n) {
        if (this.head == null) {
            this.head = n;
        }
        else {
            Node aux;
            for(aux=this.head; aux.getNext()!=null; aux=aux.getNext()) {

            }
            aux.setNext(n);
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
        }
    }


    public void removeLast() {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else if (this.size == 1) {
            this.head = null;

        }
        else {
            Node aux = this.head;
            for (Node aux2=aux.getNext();aux2.getNext() !=null; aux2 = aux2.getNext()) {
                aux=aux2;
            }
            aux.setNext((Node)null);
        }

        this.size--;
    }


    public void removeNode(Node n) {
        if (this.head == null) {
            throw new MyException("List is empty");
        }
        else {
            if (this.head==n){
                this.removeFirst();
            }
            else {
                Node aux;
                for (aux=this.head; aux.getNext() != null && aux.getNext() != n; aux=aux.getNext()) {

                }

                if (aux==null){
                    throw new MyException("Element not found");
                }
                else {
                    aux.setNext(n.getNext());
                    n.setNext((Node)null);
                    --this.size;
                }

            }
        }

    }

    @Override
    public void removeElement(Float o) {
        Node n = new Node(o);
        this.removeNode(n);
    }

    @Override
    public Float getFirst() {
       return this.getHead().data;
    }

    public Node getHead() {
        return this.head;
    }

    @Override
    public Float getLast() {
        Node aux;
        for (aux=this.head; aux.getNext() !=null; aux=aux.getNext()) {

        }
        return aux.getNext().data;
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
