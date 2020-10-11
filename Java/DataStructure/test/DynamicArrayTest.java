package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.DynamicArray;
import Sorting.Comparable;

class DynamicArrayTest {
	DynamicArray<Integer> array;
	DynamicArray<Integer> prefilledArray;
	@BeforeEach
	void setUp() throws Exception {
		array = new DynamicArray<Integer> (new Comparable<Integer> () {
			@Override
			public int compare(Integer firstE, Integer secondE) {
				
				return firstE - secondE;
			}
		});
		
		prefilledArray = new DynamicArray<Integer> (new Comparable<Integer> () {
			@Override
			public int compare(Integer firstE, Integer secondE) {
				
				return firstE - secondE;
			}
		});
		
		for (int i = 0; i < 10; i ++) {
			prefilledArray.insert(i);
		}
	}

	@Test
	void testInsertFourElementUnsorted() {
		Integer[] insertArray = {4,3,2,1};
		for (int i = 0; i < 4; i ++) {
			array.insert(insertArray[i]);
		}
		
		assertEquals(1, array.get(0));
		assertEquals(2, array.get(1));
		assertEquals(3, array.get(2));
		assertEquals(4, array.get(3));

		assertEquals(4, array.getElementNumber());
	}
	
	@Test
	void testInsertOneElement() {
		Integer[] insertArray = {1};
		array.insert(insertArray[0]);
		assertEquals(insertArray[0], array.get(0));
		
	}
	
	@Test
	void testSearchingElement () {
		for (int i = 0; i < 10; i ++) {
			assertEquals(i, prefilledArray.search(i));
		}
	}
	
	@Test
	void testRemoveLastElement () {
		prefilledArray.remove(9);
		
		assertEquals(null, prefilledArray.get(9));
	
	}
	
	@Test
	void testRemoveFirstElement () {
		prefilledArray.remove(0);
		
		for (int i = 0; i < 9; i ++) {
			assertEquals(i+1, prefilledArray.get(i));
		}
	}

}
