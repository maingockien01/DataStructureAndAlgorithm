package Sorting;
public class InsertSort<E> extends ArraySort<E> {
    public InsertSort (Comparable<E> comparable) {
        super(comparable);
    }

    public E[] sort(E[] array) {
        array = sort(array, 0, array.length);
        return array;
    }

    public E[] sort(E[] array, int startIndex, int endIndex) {
        for (int i = startIndex + 1; i < endIndex; i ++) {
            int thisElementIndex = i;
            while (thisElementIndex > startIndex && compare(array[thisElementIndex-1],array[thisElementIndex]) > 0) {
                swap(array, thisElementIndex, thisElementIndex-1);
                thisElementIndex --;
            }

        }
        
        return array;
    }

}
