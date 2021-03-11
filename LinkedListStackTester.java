package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListStackTester {

	private LinkedListStack<Integer> emptyStack;
	private LinkedListStack<Integer> oneElementStack;
	private LinkedListStack<Integer> smallStack;
	private LinkedListStack<Integer> largeRandomStack;
	
	private Random rng = new Random();

	@BeforeEach
	void setUp() throws Exception {
		emptyStack = new LinkedListStack<>();
		
		oneElementStack = new LinkedListStack<>();
		oneElementStack.push(1);
		
		smallStack = new LinkedListStack<>();
		for (int i = 0; i < 5; i++)
			smallStack.push(i);
		
		largeRandomStack = new LinkedListStack<>();
		for (int i = 0; i < 100; i++)
			largeRandomStack.push(rng.nextInt(100));
	}

	
// clear() and isEmpty() Tests
	@Test
	void clearEmptyStack() {
		emptyStack.clear();
		
		assertTrue(emptyStack.isEmpty());
	}
	
	@Test
	void clearOneElementStack() {
		oneElementStack.clear();
		
		assertTrue(oneElementStack.isEmpty());
	}
	
	@Test
	void clearSmallStack() {
		smallStack.clear();
		
		assertTrue(smallStack.isEmpty());
	}
	
	@Test
	void clearLargeStack() {
		largeRandomStack.clear();
		
		assertTrue(largeRandomStack.isEmpty());
	}
	
	@Test
	void addAndCheckIfEmpty() {
		for (int i = 0; i < 100; i++) {
			int randomLength = rng.nextInt(100);

			for (int j = 0; j < randomLength; j++)
				emptyStack.push(0);
			
			for (int j = 0; j < randomLength; j++)
				emptyStack.pop();
			
			assertTrue(emptyStack.isEmpty());
		}
	}
	
// peek() Tests
	@Test
	void peekEmptyStack() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyStack.peek();
		});
	}
	
	@Test
	void peekOneStack() {
		assertEquals(1, oneElementStack.peek());
	}
	
	@Test
	void peekSmallStack() {
		assertEquals(4, smallStack.peek());
		smallStack.pop();
		assertEquals(3, smallStack.peek());
	}
	
// pop() Tests
	@Test
	void popEmptyStack() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyStack.pop();
		});
	}
	
	@Test
	void popOneStack() {
		assertEquals(1, oneElementStack.pop());
	}
	
	@Test
	void popSmallStack() {
		assertEquals(4, smallStack.pop());
		assertEquals(3, smallStack.pop());
	}
	
	@Test
	void popSmallStackToEmpty() {
		for (int i = 0; i < 5; i++)
			smallStack.pop();
		assertTrue(smallStack.isEmpty());
	}
	
	@Test
	void popSmallStackSizeChange() {
		smallStack.pop();
		assertEquals(4, smallStack.size());
		smallStack.pop();
		assertEquals(3, smallStack.size());
		
	}
	
//push() Tests
	@Test
	void pushEmptyStack() {
		emptyStack.push(0);
		assertEquals(0, emptyStack.peek());
	}
	
	@Test
	void pushOneStack() {
		oneElementStack.push(99);
		assertEquals(99, oneElementStack.peek());
	}
	
	@Test
	void pushSmallStack() {
		smallStack.push(99);
		assertEquals(99, smallStack.peek());
	}
	
	@Test 
	void pushSizeChange() {
		emptyStack.push(0);
		assertEquals(1, emptyStack.size());
		emptyStack.push(0);
		assertEquals(2, emptyStack.size());
		emptyStack.push(0);
		assertEquals(3, emptyStack.size());
	}
	
	@Test
	void pushSizeChangeMany() {
		for (int i = 0; i < 1000; i++) {
			assertEquals(i, emptyStack.size());
			emptyStack.push(i);
		}
	}
	
//size() Tests	
	@Test
	void emptySize() {
		assertEquals(0, emptyStack.size());
	}
	
	@Test
	void oneSize() {
		assertEquals(1, oneElementStack.size());
	}
	
	@Test
	void smallSize() {
		assertEquals(5, smallStack.size());
	}

	@Test
	void sizeUpdate() {
		for (int i = 0; i < 1000; i++) {
			assertEquals(i, emptyStack.size());
			emptyStack.push(0);
		}
	}
	
}
