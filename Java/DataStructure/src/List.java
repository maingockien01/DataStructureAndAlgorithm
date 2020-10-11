package src;

public interface List<E> {

	void insert(E element, int position);
	E get (int position);
	E remove (int position);
	int search (E element);
	boolean isEmpty();
	
	int getLength ();
}
