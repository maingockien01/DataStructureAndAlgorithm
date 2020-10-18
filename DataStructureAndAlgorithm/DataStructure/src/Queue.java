package src;

public interface Queue<E> {

	E dequeue ();
	E peek ();
	void queue(E element);
	boolean isEmpty ();
	
}
