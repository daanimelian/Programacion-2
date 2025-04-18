package clase2.src;

public class Node<T> {
    protected Node<T> next;
    protected T data;

    public Node(Node<T> next, T data) {
        this.next = next;
        this.data = data;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node<T> getNext() { return this.next; }
    public void setNext(Node<T> next) { this.next = next; }
}
