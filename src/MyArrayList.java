import java.util.Iterator; // Import the Iterator interface

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() { // Constructor
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void resize() { // Resize the array if needed
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2]; // Double the size
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements; // Update the reference
        }
    }

    private void checkIndex(int index) { // Check if the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void add(T item) { // Add an item to the list
        resize();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) { // Set an item at a specific index
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) { // Add an item at a specific index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        resize();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) { // Add an item at the beginning of the list
        add(0, item);
    }

    @Override
    public void addLast(T item) { // Add an item at the end of the list
        add(size, item);
    }

    @Override
    public T get(int index) { // Get an item at a specific index
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() { //
        return get(0);
    }

    @Override
    public T getLast() { // Get the last item in the list
        return get(size - 1);
    }

    @Override
    public void remove(int index) { // Remove an item at a specific index
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public void removeFirst() { // Remove the first item in the list
        remove(0);
    }

    @Override
    public void removeLast() { // Remove the last item in the list
        remove(size - 1);
    }

    @Override
    public void sort() { // Sort the list in ascending order
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) elements[j];
                T b = (T) elements[j + 1];
                if (a.compareTo(b) > 0) {
                    elements[j] = b;
                    elements[j + 1] = a;
                }
            }
        }
    }
    @Override
    public int indexOf(Object Object) { // Find the index of an item in the list
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(Object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object Object) { // Find the last index of an item in the list
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(Object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object Object) { // Check if an item exists in the list
        return indexOf(Object) != -1;
    }

    @Override
    public Object[] toArray() { // Convert the list to an array
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public void clear() { // Clear the list
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    @Override
    public int size() {// Get the size of the list
        return size;
    }

    @Override
    public Iterator<T> iterator(){ // Get an iterator for the list
        return new Iterator<T>(){
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("List is empty");
                }
                return (T) elements[index++];
            }
        };
    }
}
