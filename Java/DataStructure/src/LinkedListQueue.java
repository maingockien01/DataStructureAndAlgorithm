package src;

public class LinkedListQueue<E> implements Queue<E> {
	
	private SingleLinkedList<E> list;
	
	public LinkedListQueue() {
		list = new SingleLinkedList<E>();
	}

	@Override
	public E dequeue() {
		return list.remove(0);
	}

	@Override
	public void queue(E element) {
		list.insert(element, list.getLength());
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E peek() {
		return list.get(0);
	}

}
