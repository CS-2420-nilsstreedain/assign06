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

	/**This private class acts as the framework for the linked list, allowing 
	 * an element to be attached to a reference for another element.
	 * Both the contents of the node, the element, and the reference of the next element
	 * are public, so nodes' info within the SinglyLinkedList class can be accessed freely.
	 * 
	 * @author Paul Nuffer, Nils Streedain
	 *
	 * @param <E> the type of element to be contained in a node
	 */
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

	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(T element) {
		head.next = new Node<T>(element, head.next);
		elementCount++;
	}

	/**This method returns the node that precedes the node at the passed in index.
	 * @param index - The index for which we want the node previous to
	 * @return the node previous to the node at index
	 */
	private Node<T> getPrevNode(int index) {
		Node<T> temp = head;
		for (int i = -1; i < index - 1; i++)
			temp = temp.next;
		return temp;
	}

	/**This method inserts a new element in a node after the node passed in/
	 * @param element - the element to be added into the list
	 * @param prevNode - the node that will point to the new added node
	 */
	private void insert(T element, Node<T> prevNode) {
		prevNode.next = new Node<T>(element, prevNode.next);
		elementCount++;
	}

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > elementCount)
	 */
	@Override
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > elementCount)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			insertFirst(element);
		else
			insert(element, getPrevNode(index));
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T getFirst() throws NoSuchElementException {
		if (elementCount == 0)
			throw new NoSuchElementException();
		return head.next.data;
	}

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= elementCount)
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= elementCount)
			throw new IndexOutOfBoundsException();
		Node<T> temp = head.next;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		return temp.data;
	}

	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T deleteFirst() throws NoSuchElementException {
		if (elementCount == 0)
			throw new NoSuchElementException();
		T temp = head.next.data;
		head.next = head.next.next;
		elementCount--;
		return temp;
	}
	
	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= elementCount)
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= elementCount)
			throw new IndexOutOfBoundsException();
		T temp = get(index);
		getPrevNode(index).next = getPrevNode(index).next.next;
		elementCount--;
		return temp;
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(T element) {
		for (int i = 0; i < elementCount; i++)
			if (get(i).equals(element))
				return i;
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return elementCount;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		head.next = null;
		elementCount = 0;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[elementCount];
		for (int i = 0; i < elementCount; i++)
			array[i] = get(i);

		return array;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence (from first 
	 * element to last element)
	 */
	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * This iterator iterates over the elements in this list in proper sequence (from first 
	 * element to last element), and also contains a remove method.
	 * @author Paul Nuffer, Nils Streedain
	 *
	 */
	private class SinglyLinkedListIterator implements Iterator<T> {
		private Node<T> prevNode;
		private Node<T> currNode;
		private Node<T> nextNode;
		private boolean okToRemove;

		public SinglyLinkedListIterator() {
			prevNode = head;
			currNode = prevNode.next;
			nextNode = currNode.next;
			okToRemove = false;
		}

		@Override
		public boolean hasNext() {
			return currNode != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();

			okToRemove = true;

			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.next;
			
			return prevNode.data;
		}

		public void remove() {
			if (!okToRemove || elementCount < 1)
				throw new IllegalStateException();

			prevNode.next = nextNode;
			
			currNode = nextNode;
			nextNode = nextNode.next;
			
			elementCount--;
		}
	}
}
