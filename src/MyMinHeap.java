public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap(){
        this.list = new MyArrayList<>();
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T getMin(){
        if (empty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return list.getFirst();
    }

    public void insert(T item){
        list.add(item);
        traverseUp(list.size()-1);
    }

    public T extractMin(){
        if (empty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        T min = list.getFirst();
        int lastIndex = list.size() - 1;

        swap(0, lastIndex);
        list.removeLast();

        if (!empty()){
            heapify(0);
        }
        return min;
    }

    private int leftChildOf(int index){
        return 2*index + 1;
    }

    private int rightChildOf(int index){
        return 2*index + 2;
    }
    private int parentOf(int index){
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2){
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private void traverseUp(int index){
        int parentIndex = parentOf(index);
        while (index > 0 && list.get(index).compareTo(list.get(parentIndex)) < 0){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parentOf(index);
        }
    }

    private void heapify(int index){
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;
        if(left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0){
            smallest = left;
        }
        if(right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0){
            smallest = right;
        }

        if (smallest != index){
            swap(index,smallest);
            heapify(smallest);
        }
    }
}
