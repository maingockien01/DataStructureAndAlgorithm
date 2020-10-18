package src;

import java.lang.Comparable;

public class SingleLinkedList<E> implements List<E> {
	
	SingledNode<E> top;
	int length;
	
	public SingleLinkedList() {
		top = null;
	}

	@Override
	public void insert(E element, int position) {
		SingledNode<E> newNode = new SingledNode<E>(element);
		
		if (isEmpty())
		{
			top = newNode;
		}
		else 
		{
			SingledNode<E> iterator = top;
			
			for(int i = 0; iterator.next != null && i < position-1; i ++) {
				iterator = iterator.next;
			}
			
			newNode.next = iterator.next;
			iterator.next = newNode;
			
		}
		
		this.length ++;
	}

	@Override
	public E get(int position) {
		if (isEmpty() || position >= getLength())
		{
			return null;
		}
		SingledNode<E> iterator = top;
		
		for (int i = 0; i < position; i ++) {
			iterator = iterator.next;
		}
		
		
		return iterator.value;
	}

	@Override
	public int search(E element) {
		if (isEmpty())
		{
			return -1;
		}
		
		int position = 0;
		SingledNode<E> temp = top;
		
		//TODO: update comparable generic for value E
		while(temp != null)
		{
			if(isEqual(temp.value, element)) {
				return position;
			}
			temp = temp.next;
			position ++;
		}
		
		return -1;
		
	}
	
	private boolean isEqual(E element1, E element2) {
		if (element1 instanceof Comparable && element2 instanceof Comparable) {
			return ((Comparable) element1).compareTo(element2) == 0;
		} else {
			return element1 == element2;
		}
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public E remove(int position) {
		if (isEmpty() || position >= getLength())
		{
			return null;
		} else if (getLength() == 1)
		{
			SingledNode<E> temp = top;
			this.top = null;
			this.length --;
			return temp.value;
		}
		else if (position == 0) 
		{
			SingledNode<E> temp = top;
			top = top.next;
			this.length --;
			return temp.value;
		} 
		else
		{
			SingledNode<E> temp = top;
			for (int i = 0; i < position - 1; i ++) {
				temp = temp.next;
			}
			SingledNode<E> returnNode = temp.next;
			temp.next = returnNode.next;
			this.length --;

			return returnNode.value;
		}
	}

}
