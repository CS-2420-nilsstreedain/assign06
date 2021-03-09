package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {
	
	private class Node<E> {
		public E data;
		public Node next;
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node head;
	private int elementCount;
	
	public SinglyLinkedList() {
		head = new Node(null, null);
		elementCount = 0;
	}

	@Override
	public void insertFirst(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E deleteFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	private class SinglyLinkedListIterator implements Iterator<E> {
		
		public SinglyLinkedListIterator() {
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void remove() {
			
		}
		
	}

}
