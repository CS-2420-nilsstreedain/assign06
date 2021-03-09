package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A SinglyLinkedList for generic type that implements List and extends
 * Iterable.
 * 
 * @author Paul Nuffer, Nils Streedain
 * @version March 11, 2021
 *
 * @param <T> the type of elements contained in this SinglyLinkedList
 */
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
		for (int i = 0; i < index - 1; i++)
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
		if (elementCount == 0)
			throw new NoSuchElementException();
		return head.next.data;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		Node<T> temp = head.next;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		return temp.data;
	}

	@Override
	public T deleteFirst() throws NoSuchElementException {
		if (elementCount == 0)
			throw new NoSuchElementException();
		T temp = head.next.data;
		head.next = head.next.next;
		elementCount--;
		return temp;
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > elementCount)
			throw new IndexOutOfBoundsException();
		T temp = get(index);
		getPrevNode(index).next = getPrevNode(index).next.next;
		elementCount--;
		return temp;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		for (int i = 0; i < elementCount; i++)
			if (get(i).equals(element))
				index = i;
		return index;
	}

	@Override
	public int size() {
		return elementCount;
	}

	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}

	@Override
	public void clear() {
		head.next = null;
		elementCount = 0;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[elementCount];
		for (int i = 0; i < elementCount; i++)
			array[i] = get(i);

		return array;
	}

	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}

	private class SinglyLinkedListIterator implements Iterator<T> {
		private int nextIndex;
		private boolean okToRemove;

		public SinglyLinkedListIterator() {
			nextIndex = 0;
			okToRemove = false;
		}

		@Override
		public boolean hasNext() {
			return nextIndex < elementCount;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();

			okToRemove = true;

			T nextElement = get(nextIndex);
			nextIndex++;

			return nextElement;
		}

		public void remove() {
			if (!okToRemove)
				throw new IllegalStateException();

			nextIndex--;
			elementCount--;

			delete(nextIndex);
		}
	}
}
