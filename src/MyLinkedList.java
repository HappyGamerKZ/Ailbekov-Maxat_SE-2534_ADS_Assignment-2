import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode{
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element, MyNode next, MyNode prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item){
        addLast(item);
    }

    @Override
    public void set(int index, T item){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    }

    @Override
    public void add(int index, T item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0){
            addFirst(item);
            return;
        }
        if (index == size){
            addLast(item);
            return;
        }
        MyNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        MyNode newNode = new MyNode(item, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }
    @Override
    public void addFirst(T item){
        if (head == null){
            head = new MyNode(item, null, null);
            tail = head;
        }else{
            MyNode newNode = new MyNode(item, head, null);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    @Override
    public void addLast(T item){
        MyNode newNode = new MyNode(item, null, null);
        if (tail == null){
            head = new MyNode(item, null, null);
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    @Override
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    @Override
    public T getFirst(){
        if (head == null){
            throw new IndexOutOfBoundsException("List is empty");        }
        return head.element;
    }

    @Override
    public T getLast(){
        if (tail == null){
            throw new IndexOutOfBoundsException("List is empty");        }
        return tail.element;
    }

    @Override
    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0){
            removeFirst();
            return;
        }
        if (index == size - 1){
            removeLast();
            return;
        }

        MyNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }
    @Override
    public void removeFirst(){
        if (head == null){
            throw new IndexOutOfBoundsException("List is empty");        }
        if (head.next == null){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    @Override
    public void removeLast(){
        if (tail == null){
            throw new IndexOutOfBoundsException("List is empty");        }
        if (head == tail){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    @Override
    public void sort(){
        if (size > 1){
            boolean wasChanged;
            do{
                MyNode current = head;
                wasChanged = false;
                while (current.next != null){
                    if (current.element.compareTo(current.next.element) > 0){
                        T temp = current.element;
                        current.element = current.next.element;
                        current.next.element = temp;
                        wasChanged = true;
                    }
                    current = current.next;
                }
            } while (wasChanged);
        }
    }
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.element;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new IndexOutOfBoundsException("List is empty");
                T item = current.element;
                current = current.next;
                return item;
            }
        };
    }
}
