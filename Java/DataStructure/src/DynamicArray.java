package src;

import Sorting.Comparable;

public class DynamicArray<E> extends ArrayList<E> {
    private Comparable<E> compare;
    
    public DynamicArray (Comparable<E> compare) {
        this.compare = compare;
    }

    @Override
    public void insert(E element) {
        
        array[elementNum] = element;
        elementNum ++;

        int index = getElementNumber() - 1;
        while (index > 0 && compare.compare(get(index),get(index-1)) < 0) {
            swap(index, index-1);
            index --;
        }

        resize();
    }



    @Override
    public int search(E element) {
        if (isEmpty()){
            return NOT_FOUND;
        } else {
            return binarySearch(element, array, 0, getElementNumber());
        }
    }

    protected int binarySearch(E element, E[] array, int start, int end) {
        if (end <= start) {
            return NOT_FOUND;
        };

        int mid = (start + end) / 2;
        int compareElementAndMid = compare.compare(element, get(mid));
        if (compareElementAndMid == 0) {
            return mid;
        } else if (compareElementAndMid > 0) {
            return binarySearch(element, array, mid+1, end);
        } else {
            return binarySearch(element, array, start, mid);
        }

    }

    @Override
    public void remove (int index) {
        array[index] = null;
        elementNum --;

        while (index < length && array[index] == null && array[index+1] != null) {
            swap(index, index+1);
            index ++;
        }
        
    }

    @Override
    public E get (int index) {
        return array[index];
    }

}
