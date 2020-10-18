package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import src.ArrayList;

public class ArrayListTest extends TestCase {

	private ArrayList<Integer> array;
	
	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	@Test
	public void testConstructor () {
		array = new ArrayList<Integer>() {

			@Override
			public void insert(Integer element) {
				Integer[] array = getArray();
				array[getElementNumber()] = element;
				increaseElement();
			}

			@Override
			public int search(Integer element) {
				return 0;
			}

			@Override
			public Integer get(int index) {
				return getArray()[index];
			}

			@Override
			public void remove(int index) {
				
			}
			
		};
		
	}
	
	
	
}
