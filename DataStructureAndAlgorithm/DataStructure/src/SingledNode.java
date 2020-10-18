package src;

public class SingledNode<E> {

	public E value;
	public SingledNode<E> next;
	
	public SingledNode() {
		next = null;
	}
	
	public SingledNode (E value) {
		this.value = value;
		this.next = null;
	}
	
	public SingledNode (E value, SingledNode<E> next) {
		this.value = value;
		this.next = next;
	}

}
