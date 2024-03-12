import java.util.Iterator;

public class MyContainer implements Iterable<Integer> {
    public MyContainer() {
        array = new int[DEFAULT_LENGTH];
        pointer = 0;
    }

    private static final int DEFAULT_LENGTH = 4;
    private int[] array;
    private int pointer;

    public void add(int number) {
        if (pointer >= array.length) {
            resizeArray();
        }
        array[pointer++] = number;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        for (int i = index; i < pointer - 1; ++i) {
            array[i] = array[i + 1];
        }

        --pointer;
    }

    public int getValue(int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        return array[index];
    }

    public void setValue(int value, int index) {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException("Index out of the bounds of the container");
        }

        array[index] = value;
    }

    private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int size() {
        return pointer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        final MyContainer other = (MyContainer) obj;
        for (int i = 0; i < pointer; ++i) {
            if (array[i] != other.array[i])
                return false;
        }

        return true;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("count: " + size() + "\n elements: \n");
        for(int elem : this)
        {
            builder.append(elem + '\n');
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
