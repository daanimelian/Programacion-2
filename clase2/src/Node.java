package clase2.src;

public class Node<T> {
    protected Node<T> next;
    protected Node<T> prev;
    protected T data;

    public Node(Node<T> next, T data) {
        this.next = next;
        this.data = data;
        this.prev = null;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node<T> getNext() { return this.next; }
    public Node<T> getPrev() { return this.prev; }
    public void setNext(Node<T> next) { this.next = next; }
    public void setPrev(Node<T> prev) { this.prev = prev; }
}
