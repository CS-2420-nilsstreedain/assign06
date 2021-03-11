package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListStackTester {

	private LinkedListStack<Integer> emptyStack;
	private LinkedListStack<Integer> oneElementStack;
	private LinkedListStack<Integer> smallStack;
	private LinkedListStack<Integer> largeStack;
	
	private Random rng = new Random();

	@BeforeEach
	void setUp() throws Exception {
		emptyStack = new LinkedListStack<>();
		
		oneElementStack = new LinkedListStack<>();
		oneElementStack.push(1);
		
		smallStack = new LinkedListStack<>();
		for (int i = 0; i < 5; i++)
			smallStack.push(i);
		
		largeStack = new LinkedListStack<>();
		for (int i = 0; i < 100; i++)
			largeStack.push(rng.nextInt(100));
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
		largeStack.clear();
		
		assertTrue(largeStack.isEmpty());
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
}
