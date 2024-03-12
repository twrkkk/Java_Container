import java.util.Iterator;

/**
 * A custom container class for storing integers.
 */
public class MyContainer implements Iterable<Integer> {
    private static final int DEFAULT_LENGTH = 4;
    private int[] array;
    private int pointer;

    public MyContainer() {
        array = new int[DEFAULT_LENGTH];
        pointer = 0;
    }

    /**
     * Adds an integer to the container.
     *
     * @param number the integer to add
     */
    public void add(int number) {
        if (pointer >= array.length) {
            resizeArray();
        }
        array[pointer++] = number;
    }

    /**
     * Removes the integer at the specified index from the container.
     *
     * @param index the index of the integer to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void removeAt(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        for (int i = index; i < pointer - 1; ++i) {
            array[i] = array[i + 1];
        }

        --pointer;
    }

    /**
     * Gets the integer at the specified index from the container.
     *
     * @param index the index of the integer to retrieve
     * @return the integer at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public int getValue(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        return array[index];
    }

    /**
     * Sets the value of the integer at the specified index in the container.
     *
     * @param value the new value to set
     * @param index the index of the integer to set
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void setValue(int value, int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        array[index] = value;
    }

    /**
     * @return the size of the container
     */
    public int size() {
        return pointer;
    }

    private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Compares this container with the specified object for equality.
     *
     * @param obj the object to compare with
     * @return {@code true} if the containers are equal; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        final MyContainer other = (MyContainer) obj;
        for (int i = 0; i < pointer; ++i) {
            if (array[i] != other.array[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return a string representation of the container
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("count: " + size() + "\n elements: \n");
        for (int elem : this) {
            builder.append(elem).append('\n');
        }

        return builder.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < pointer;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements in the container");
            }
            return array[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }
}
