public class MyQueue<T> {

    private MyStack<T> inputStack;
    private MyStack<T> outputStack;

    public MyQueue() {
        inputStack = new MyStack<>();
        outputStack = new MyStack<>();
    }

    // Add an item: O(1) time.
    public void enqueue(T item) {
        inputStack.push(item);
    }

    // Move items only when the output stack is empty.
    private void moveItems() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    // Remove the oldest item.
    // Amortized O(1); one individual call can take O(n).
    public T dequeue() {
        moveItems();

        if (outputStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return outputStack.pop();
    }

    // View the oldest item without removing it.
    // Amortized O(1); one individual call can take O(n).
    public T peek() {
        moveItems();

        if (outputStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return outputStack.peek();
    }

    // O(1) time.
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}