package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {
	
	private class Node<E> {
		public E data;
		public Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private int elementCount;
	
	public SinglyLinkedList() {
		head = new Node<T>(null, null);
		elementCount = 0;
	}

	@Override
	public void insertFirst(T element) {
		head.next = new Node<T>(element, head.next);
		elementCount++;
	}

	private Node<T> getPrevNode(int index) {
		Node<T> temp = head.next;
		for(int i = 0; i < index - 1; i++)
			temp = temp.next;
		return temp;
	}
	
	private void insert(T element, Node<T> prevNode) {
		prevNode.next = new Node<T>(element, prevNode.next);
		elementCount++;
	}
	
	@Override
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > elementCount)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			insertFirst(element);
		else
			insert(element, getPrevNode(index));
	}

	@Override
	public T getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		Node<T> temp = head.next;
		for(int i = 0; i < index; i++)
			temp = temp.next;
		return temp.data;
	}

	@Override
	public T deleteFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T element) {
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
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	private class SinglyLinkedListIterator implements Iterator<T> {
		
		public SinglyLinkedListIterator() {
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void remove() {
			
		}
		
	}

}
