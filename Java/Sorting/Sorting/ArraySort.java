package Sorting;

public abstract class ArraySort<E> {

    private Comparable<E> comparable;

    public ArraySort(Comparable<E> comparable) {
        this.comparable = comparable;
    }

    public abstract E[] sort(E[] array);
    public abstract E[] sort(E[] array, int startIndex, int endIndex);

    protected void swap(E[] array, int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    protected int compare(E firstElement, E secondElement) {
        return comparable.compare(firstElement, secondElement);
    }

}
