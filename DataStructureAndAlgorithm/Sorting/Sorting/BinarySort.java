/**
 * 
 */
package Sorting;

/**
 * @author kevin
 *
 */
public class BinarySort<E> extends ArraySort<E> {

	private E[] tempArray;
	private ArrayCreator<E> creator;
	
	public BinarySort(Comparable<E> comparable, E[] tempArray) {
		super(comparable);
		this.tempArray = tempArray;
	}
	
	public BinarySort(Comparable<E> comparable, ArrayCreator<E> creator) {
		super(comparable);
		this.creator = creator;
		this.tempArray = null;
	}
	
	public BinarySort(Comparable<E> comparable, ArrayCreator<E> creator, E[] tempArray) {
		super(comparable);
		this.creator = creator;
		this.tempArray = tempArray;
	};

	@Override
	public E[] sort(E[] array) {
        return sort(array, 0, array.length);
	}

	@Override
	public E[] sort(E[] array, int startIndex, int endIndex) {
		if (tempArray == null || tempArray.length < (endIndex - startIndex)) {
			this.tempArray = creator.createArray(endIndex-startIndex);
		};
		return sort(array, startIndex, endIndex, tempArray);
	}

    private E[] sort(E[] array, int startIndex, int endIndex, E[] tempArray) {
        
        if (endIndex <= startIndex+1) {
            return array;
        };

        int mid = (startIndex + endIndex) /2;

        sort(array, startIndex, mid, tempArray);
        sort(array, mid, endIndex, tempArray);
        merge(array, startIndex, mid, endIndex, tempArray);

        return array;
    }

    private void merge(E[] array, int startIndex, int mid, int endIndex, E[] tempArray) {    	
    	int leftIndex = startIndex;
        int rightIndex = mid;
        
        int tempIndex = 0;
        while (leftIndex < mid && tempIndex < (endIndex - startIndex)) {
        	if(rightIndex >= endIndex || compare(array[leftIndex], array[rightIndex]) < 0) {
        		tempArray[tempIndex] = array[leftIndex];
        		tempIndex ++;
        		leftIndex ++;
        	} else {
        		tempArray[tempIndex] = array[rightIndex];
        		tempIndex ++;
        		rightIndex ++;
        	}
        
        }

        for(int i = 0; i < tempIndex; i ++) {
            array[startIndex + i] = tempArray[i];
        }
        
    }

}

class OutOfBoundTempArray extends Exception {


	
}
