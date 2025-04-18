package clase2.src;

public class Node {
    protected Node next;
    protected Float data;

    public Node(Node next, Float data) {
        this.next = next;
        this.data = data;
    }

    public Node(Float data) {
        this.data = data;
        this.next = null;
    }

    public Node getNext() { return this.next; }
    public void setNext(Node next) { this.next = next; }
}
