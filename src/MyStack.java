public class MyStack<T extends Comparable<T>> {

    private MyLinkedList<T> list;

    public MyStack(){
        this.list = new MyLinkedList<>();
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        if (empty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return list.getFirst();
    }

    public void push(T item){
        list.addFirst(item);
    }

    public T pop(){
        if (empty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T topElement = list.getFirst();
        list.removeFirst();
        return topElement;
    }
}
