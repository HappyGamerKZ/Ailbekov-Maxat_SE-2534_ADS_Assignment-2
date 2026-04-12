import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode{
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element, MyNode next, MyNode prev)
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    
}
