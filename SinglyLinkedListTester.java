package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTester {
	
	private SinglyLinkedList<Integer> emptyIntegerList = new SinglyLinkedList<>();
	private SinglyLinkedList<Integer> oneIntegerList = new SinglyLinkedList<>();
	private SinglyLinkedList<Integer> smallIntegerList = new SinglyLinkedList<>();
	
	private Random rng = new Random();
	
	@BeforeEach
	void setUp() {
		oneIntegerList.insertFirst(1);
		
		smallIntegerList.insertFirst(0);
		smallIntegerList.insertFirst(1);
		smallIntegerList.insertFirst(2);
		smallIntegerList.insertFirst(3);
		smallIntegerList.insertFirst(4);
	}

// insertFirst() Tests
	@Test
	void insertFirstOne() {
		emptyIntegerList.insertFirst(1);
		assertEquals(1, emptyIntegerList.get(0));
	}
	
	@Test
	void insertFirstMany() {
		emptyIntegerList.insertFirst(1);
		emptyIntegerList.insertFirst(2);
		emptyIntegerList.insertFirst(3);
		emptyIntegerList.insertFirst(4);
		emptyIntegerList.insertFirst(5);

		assertEquals(5, emptyIntegerList.get(0));
		assertEquals(4, emptyIntegerList.get(1));
		assertEquals(3, emptyIntegerList.get(2));
		assertEquals(2, emptyIntegerList.get(3));
		assertEquals(1, emptyIntegerList.get(4));
	}
	
// insert() Tests
	@Test
	void insertIndexOutOfBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyIntegerList.insert(-1, 1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyIntegerList.insert(1, 1);
		});
	}
	
	@Test
	void insertAtFirstIndex() {
		emptyIntegerList.insert(0, 1);
		assertEquals(1, emptyIntegerList.get(0));
	}
	
	@Test
	void insertManyElementsInOrder() {
		for (int i = 0; i < 100; i++) {
			emptyIntegerList.insert(i, i);
			assertEquals(i, emptyIntegerList.get(i));
		}
	}
	
	@Test
	void insertManyElementsRandom() {
		for (int i = 0; i < 100; i++) {
			int randIndex = rng.nextInt(i + 1);
			emptyIntegerList.insert(randIndex, i);
			assertEquals(i, emptyIntegerList.get(randIndex));
		}
	}
	
// getFirst() Tests
	@Test
	void getFirstEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyIntegerList.getFirst();
		});
	}
	
	@Test
	void getFirstOneElement() {
		assertEquals(1, oneIntegerList.getFirst());
	}
	
	@Test
	void getFirstManyElements() {
		assertEquals(4, smallIntegerList.getFirst());
	}
	
// get() Tests
	@Test
	void getOutOfBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			oneIntegerList.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			oneIntegerList.get(1);
		});
	}
	
	@Test
	void getFromEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyIntegerList.get(0);
		});
	}
	
	@Test
	void getFromOneElement() {
		assertEquals(1, oneIntegerList.get(0));
	}
	
// deleteFirst() Tests
	@Test
	void deleteFirstEmptyInteger() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyIntegerList.deleteFirst();
		});
	}
	
	@Test
	void oneDeleteFirstInteger() {
		assertEquals(1, oneIntegerList.deleteFirst());
	}
	
	@Test
	void smallDeleteFirstInteger() {
		assertEquals(4, smallIntegerList.deleteFirst());
		assertEquals(3, smallIntegerList.deleteFirst());
		assertEquals(2, smallIntegerList.deleteFirst());
		assertEquals(1, smallIntegerList.deleteFirst());
		assertEquals(0, smallIntegerList.deleteFirst());
		assertThrows(NoSuchElementException.class, () -> { 
			emptyIntegerList.deleteFirst();
		});
	}
	
//delete() tests
	
	@Test
	void deleteOutOfBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			oneIntegerList.delete(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			oneIntegerList.delete(1);
		});
	}
	
	@Test
	void deleteOneElement() {
		assertEquals(1, oneIntegerList.delete(0));
		assertEquals(0, oneIntegerList.size());
	}
	
	@Test
	void deleteMiddleElement() {
		assertEquals(2, smallIntegerList.delete(2));
		assertEquals(4, smallIntegerList.size());
	}
	
	@Test
	void deleteManyElements() {
		for (int i = 0; i < 100; i++) 
			emptyIntegerList.insertFirst(i);
		for (int i = 99; i >= 0; i--) 
			assertEquals(99-i, emptyIntegerList.delete(i));
		assertEquals(0, emptyIntegerList.size());
		for (int i = 0; i < 100; i++) 
			emptyIntegerList.insertFirst(i);
		for (int i = 0; i < 100; i++) 
			assertEquals(99-i, emptyIntegerList.delete(0));
		assertEquals(0, emptyIntegerList.size());
	}
	
	@Test
	void deleteRandomElements() {
		for (int i = 0; i < 100; i++) 
			emptyIntegerList.insertFirst(i);
		for (int i = 0; i < 100; i++) {
			int randIndex = rng.nextInt(100-i);
			assertEquals(emptyIntegerList.get(randIndex), emptyIntegerList.delete(randIndex));
		}
	}
	
	

}
