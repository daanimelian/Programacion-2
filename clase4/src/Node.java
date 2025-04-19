package clase4.src;

public class Node<E> {
    private E dato;
    private Node<E> next;

    public Node(E d, Node<E> n) {
        this.dato = d;
        this.next = n;
    }

    public E getElement() {
        return this.dato;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setElement(E d) {
        this.dato = d;
    }

    public void setNext(Node<E> n) {
        this.next = n;
    }
}
