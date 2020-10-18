package src;


public abstract class ArrayList<E> {
    final int DEFAULT_LENGTH = 3;
    final int LOAD_FACTOR_THRESHOLD_PERCENTAGE = 60;
    final int NOT_FOUND = -1;
    protected E[] array;
    protected int length;
    protected int elementNum;
    
    public ArrayList () {
        this.array = createArray(DEFAULT_LENGTH);
        this.length = DEFAULT_LENGTH;

    }

	@SuppressWarnings("unchecked")
	protected E[] createArray (int length) {
		Object[] array = new Object[length];
		
		return (E[]) array;
    }

    protected int loadFactorPercentage () {
        return  100 * elementNum / length;
    }

    protected void resize () {
        
        if (loadFactorPercentage() > LOAD_FACTOR_THRESHOLD_PERCENTAGE) {
            int newLength = length * 2;
            E[] newArray = createArray(newLength);
            
            for (int i = 0; i < length; i ++) {
                newArray[i] = array[i];
            }

            this.length = newLength;
            this.array = newArray;
        }
    }

    public boolean isEmpty () {
        return elementNum == 0;
    }

    public int getElementNumber () {
        return this.elementNum;
    }

    protected void swap(int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public abstract void insert (E element);
    public abstract int search (E element);
    public abstract E get (int index);
    public abstract void remove (int index);

} 
