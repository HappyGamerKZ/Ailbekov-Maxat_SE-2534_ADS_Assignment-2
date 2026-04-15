public class Main { //Testing class
    public static void main(String[] args) {

        System.out.println("--- Testing MyMinHeap ---");// adding elements to minheap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(1);
        heap.insert(7);

        System.out.println("Min element: " + heap.getMin());// extracting elements from minheap
        System.out.print("Extracting elements: ");
        while (!heap.empty()) {
            System.out.print(heap.extractMin() + " ");
        }
        System.out.println("\n");

        System.out.println("--- Testing MyStack (LIFO) ---");// adding elements to stack
        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Popped from stack: " + stack.pop()); // extracting elements from stack
        System.out.println("Peek stack now: " + stack.peek());
        System.out.println();

        System.out.println("--- Testing MyQueue (FIFO) ---"); // adding elements to queue
        MyQueue<Double> queue = new MyQueue<>();
        queue.enqueue(1.1);
        queue.enqueue(2.2);
        queue.enqueue(3.3);

        System.out.println("Dequeued from queue: " + queue.dequeue()); // extracting elements from queue
        System.out.println("Peek queue now: " + queue.peek()); // peeking at the front of the queue
    }
}