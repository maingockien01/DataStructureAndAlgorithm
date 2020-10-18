package Test;

import Sorting.Sor
ting.ArrayCreator;
import Sorting.Sorting.ArraySort;
import Sorting.Sorting.BinarySort;
import junit.framework.TestCase;

public class BinarySortTest extends TestCase {
	Integer[] array1 = new Integer[] {1};
	Integer[] array2 = new Integer[] {3,2};
	Integer[] array3 = new Integer[] {3,1,2};
	Integer[] array4 = new Integer[] {10,9,8,7,6,5,4,3,2,1,};

	Comparable<Integer> intCompare = new Comparable<>() {

		@Override
		public int compare(Integer firstE, Integer secondE) {
			
			return firstE - secondE;
		}
	
	};
	
	ArrayCreator<Integer> intArrayCreator = new ArrayCreator<>() {
		@Override
		public Integer[] createArray (int length) {
			return new Integer[length];
		}

	};
	
	ArraySort<Integer> sort = new BinarySort<Integer>(intCompare, intArrayCreator);
	
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testBinaryEArrayIntInt() {

		assertEquals(true, isArraySorted(new Integer[] {1,2,3,4,5}));
		
		sort.sort(array1);
		assertEquals(true, isArraySorted(array1));
	
		assertEquals(false, isArraySorted(array2));
		sort.sort(array2);
		assertEquals(true, isArraySorted(array2));
		
		assertEquals(false, isArraySorted(array3));
		sort.sort(array3);
		assertEquals(true, isArraySorted(array3));
		
		assertEquals(false, isArraySorted(array4));
		sort.sort(array4);
		assertEquals(true, isArraySorted(array4));
		
	}
	
	private boolean isArraySorted (Integer[] array) {
		if (array.length <= 1) {
			return true;
		};
		for (int i = 0; i < array.length-1; i ++) {
			if (intCompare.compare(array[i], array[i+1]) >0) {
				return false;
			}
			
		}
		
		return true;
		
	}

}
