public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue(){
        this.list = new MyLinkedList<>();
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T peak(){
        if (empty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return list.getFirst();
    }
    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        if (empty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        T frontElement = list.getFirst();
        list.removeFirst();
        return frontElement;
    }
}
