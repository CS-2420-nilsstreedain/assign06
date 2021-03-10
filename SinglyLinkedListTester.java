package assign06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
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
	
// indexOf() Tests
	@Test
	void noIndexOfElement() {
		assertEquals(-1, smallIntegerList.indexOf(5));
	}

	@Test
	void firstIndexOfElement() {
		assertEquals(0, smallIntegerList.indexOf(4));
	}

	@Test
	void lastIndexOfElement() {
		assertEquals(4, smallIntegerList.indexOf(0));
	}

	@Test
	void duplicateIndexOfElement() {
		for (int i = 0; i < 10; i++)
			emptyIntegerList.insertFirst(0);
		
		assertEquals(0, emptyIntegerList.indexOf(0));
	}
	
	@Test
	void randomIndexOfElement() {
		for (int i = 0; i < 100; i++)
			emptyIntegerList.insert(i, i);
		for (int i = 0; i < 100; i++) {
			int randIndex = rng.nextInt(100);
			assertEquals(randIndex, emptyIntegerList.indexOf(randIndex));
		}
	}
	
// size() Tests
	@Test
	void emptyListSize() {
		assertEquals(0, emptyIntegerList.size());
	}
	
	@Test
	void randomListSize() {
		for (int i = 0; i < 100; i++) {
			int randSize = rng.nextInt(100);
			
			for (int j = 0; j < randSize; j++)
				emptyIntegerList.insertFirst(1);
			
			assertEquals(randSize, emptyIntegerList.size());
			emptyIntegerList.clear();
		}
	}
	
	@Test
	void randomListSizeAndDeletions() {
		for (int i = 0; i < 100; i++) {
			int randSize = rng.nextInt(100);
			int randDeletions = rng.nextInt(randSize + 1);
			
			for (int j = 0; j < randSize; j++)
				emptyIntegerList.insertFirst(1);
			for (int j = 0; j < randDeletions; j++)
				emptyIntegerList.deleteFirst();
			
			assertEquals(randSize - randDeletions, emptyIntegerList.size());
			emptyIntegerList.clear();
		}
	}
	
// isEmpty() Tests
	@Test
	void emptyListIsEmpty() {
		assertTrue(emptyIntegerList.isEmpty());
	}
	
	@Test
	void largeListIsEmpty() {
		assertFalse(smallIntegerList.isEmpty());
	}
	
// clear() Tests
	@Test
	void clearEmptyList() {
		emptyIntegerList.clear();
		assertTrue(emptyIntegerList.isEmpty());
	}
	
	@Test
	void clearSmallIntegerList() {
		smallIntegerList.clear();
		assertTrue(smallIntegerList.isEmpty());
	}
	
	@Test
	void clearRandomSizeAndIntegerList() {
		for (int i = 0; i < 100; i++) {
			int randSize = rng.nextInt(100);
			for (int j = 0; j < randSize; j++)
				emptyIntegerList.insertFirst(rng.nextInt(100));
			emptyIntegerList.clear();
			assertTrue(emptyIntegerList.isEmpty());
		}
	}
	
// toArray() Tests
	@Test
	void emptyListToArray() {
		assertArrayEquals(new Integer[] {}, emptyIntegerList.toArray());
	}
	
	@Test
	void randomizedListToArray() {
		for (int i = 0; i < 100; i++) {
			int randSize = rng.nextInt(100);
			Integer[] array = new Integer[randSize];
			
			for (int j = 0; j < randSize; j++) {
				int randValue = rng.nextInt(100);
				emptyIntegerList.insert(j, randValue);
				array[j] = randValue;
			}
			
			assertArrayEquals(array, emptyIntegerList.toArray());
			emptyIntegerList.clear();
		}
	}
	
// ITERATOR TESTS
	
// hasNext() Tests	
	@Test
	void emptyHasNext() {
		Iterator<Integer> emptyIterator = emptyIntegerList.iterator();
		assertFalse(emptyIterator.hasNext());
		
	}
	
	@Test
	void oneHasNext() {
		Iterator<Integer> oneIterator = oneIntegerList.iterator();
		assertTrue(oneIterator.hasNext());
	}
	
// forEach Loop Test	
	@Test
	void forEachTest() {
		int total = 0;
		for (int i : smallIntegerList) 
			total += i;
		assertEquals(10, total);
	}

}
