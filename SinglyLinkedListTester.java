package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assign04.LargestNumberSolver;

class SinglyLinkedListTester {
	
	private SinglyLinkedList<Integer> emptyIntegerList = new SinglyLinkedList<>();
	private SinglyLinkedList<Integer> oneIntegerList = new SinglyLinkedList<>();
	private SinglyLinkedList<Integer> smallIntegerList = new SinglyLinkedList<>();
	
	@BeforeEach
	void setUp() {
		oneIntegerList.insertFirst(1);
		
		smallIntegerList.insertFirst(0);
		smallIntegerList.insertFirst(1);
		smallIntegerList.insertFirst(2);
		smallIntegerList.insertFirst(3);
		smallIntegerList.insertFirst(4);
	}
	
// Exception Tests
	
	@Test
	void testEmptyInteger() {
		assertThrows(NoSuchElementException.class, () -> { 
			emptyIntegerList.deleteFirst();
		});
	}
	
//DeleteFirst Tests

	@Test
	void testOneDeleteInteger() {
		assertEquals(1, oneIntegerList.deleteFirst());
	}
	
	@Test
	void testSmallDeleteInteger() {
		assertEquals(4, smallIntegerList.deleteFirst());
		assertEquals(3, smallIntegerList.deleteFirst());
		assertEquals(2, smallIntegerList.deleteFirst());
		assertEquals(1, smallIntegerList.deleteFirst());
		assertEquals(0, smallIntegerList.deleteFirst());
	}
	
	

}
