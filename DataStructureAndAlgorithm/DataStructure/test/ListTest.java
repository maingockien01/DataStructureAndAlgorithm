package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.SettingDefinition;
import src.List;
import src.SingleLinkedList;

class ListTest {
	List<Integer> list;
	
	@BeforeEach
	void setUp () {
		list = new SingleLinkedList<Integer> ();
	}

	@Test
	void testInsertAndGetOneElement() {
		list.insert(1, 1);
		
		assertEquals(1, list.get(0));
		
		//Search out of list bound
		assertEquals(null, list.get(1));
	}

	@Test
	void testInsertAndGetTwoElements() {
		list.insert(1, 1);
		
		assertEquals(1, list.get(0));
		
		list.insert(3, 1);
		
		assertEquals(3, list.get(1));		
		
		//Search out of list bound
		assertEquals(null, list.get(5));

		}

	@Test
	void testSearchEmptyList() {
		assertEquals(-1, list.search(24));
	}
	@Test
	void testSearchOneElementList() {
		list.insert(1, 1);
		
		assertEquals(0, list.search(1));
	}
	@Test
	void testSearchManyElementsList() {
		list.insert(1, 0);
		list.insert(2, 1);
		list.insert(3, 2);
		list.insert(4, 3);
		
		assertEquals(-1, list.search(0));
		assertEquals(0, list.search(1));
		assertEquals(1, list.search(2));
		assertEquals(2, list.search(3));

	}
	
	@Test
	void testSearchUnordered () {
		list.insert(1, 0);
		list.insert(2, 1);
		list.insert(3, 1);
		list.insert(4, 3);
	
		assertEquals(0, list.search(1));
		assertEquals(1, list.search(3));
		assertEquals(2, list.search(2));
	}

	@Test
	void testIsEmptyNoElement() {
		assertEquals(true,list.isEmpty());
	}

	@Test
	void testIsEmptyAfterInsertingElement () {
		assertEquals(true, list.isEmpty());
		
		//Insert
		list.insert(1, 1);
		
		assertEquals(false, list.isEmpty());
	}
	

	@Test
	void testGetLengthEmpty() {
		assertEquals(0, list.getLength());
	}
	
	@Test
	void testGetLengthAfterInsertingElements () {
		list.insert(1, 2);
		
		assertEquals(1, list.getLength());
		
		list.insert(2, 3);
		assertEquals(2, list.getLength());
	}
	
	@Test
	void testGetLengthAfterRemovingAllElements () {
		assertEquals(true, list.isEmpty());

		list.insert(1, 2);
		list.insert(2, 3);
		
		list.remove(0);
		list.remove(0);
		assertEquals(true, list.isEmpty());	}
	@Test
	void testRemoveAndIsEmptyOneElement() {
		assertEquals(true, list.isEmpty());

		list.insert(1, 2);
		
		assertEquals(false, list.isEmpty());
		assertEquals(1, list.remove(0));
		assertEquals(true, list.isEmpty());
	}
	
	@Test
	void testRemoveFirstElements () {
		list.insert(0, 0);
		list.insert(1, 1);
		list.insert(2, 2);
		
		assertEquals(0, list.remove(0));
		assertEquals(1, list.get(0));
		
	}
	
	@Test
	void removeNotFirstElements () {
		list.insert(0, 0);
		list.insert(1, 1);
		list.insert(2, 2);
		
		assertEquals(1, list.remove(1));
		assertEquals(2, list.get(1));
		
	}

}
