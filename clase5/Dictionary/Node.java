package clase5.Dictionary;

public class Node<E, V> {
	private E elem;
	private Node<E, V> next;
	private Node<E, V> previous;
	
	public Node(E elem, Node<E, V> next, Node<E, V> previous) {
		this.elem = elem;
		this.next = next;
		this.previous = previous;
	}

	public E getElem() {
		return elem;
	}

	public void setElem(E elem) {
		this.elem = elem;
	}

	public Node<E, V> getNext() {
		return next;
	}

	public void setNext(Node<E, V> next) {
		this.next = next;
	}

	public Node<E, V> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E, V> previous) {
		this.previous = previous;
	}
}
