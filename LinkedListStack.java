package assign06;

import java.util.NoSuchElementException;

/**
 * A LinkedListStack for generic type that implements Stack.
 * 
 * @author Paul Nuffer, Nils Streedain
 * @version March 3, 2021
 *
 * @param <E> the type of elements contained in this LinkedListStack
 */
public class LinkedListStack<E> implements Stack<E> {
	
	private SinglyLinkedList<E> list;

	/**
	 * Creates a new LinkedListStack
	 */
	public LinkedListStack() {
		list = new SinglyLinkedList<>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		list.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		return list.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException {
		return list.deleteFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) {
		list.insertFirst(element);
	}
	
	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return list.size();
	}
}
