package src;

public class LinkedListStack<E> implements Stack<E> {
	private List<E> list;
	public LinkedListStack() {
		list = new SingleLinkedList<E> ();
	}

	@Override
	public void push(E element) {
		list.insert(element, list.getLength());
	}

	@Override
	public E pop() {
		return list.remove(list.getLength()-1);
	}

	@Override
	public E peek() {
		return list.get(list.getLength()-1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
