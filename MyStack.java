public class MyStack<T> {

    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    // Add an item: O(1) time, O(1) extra space.
    public void push(T item) {
        list.addFirst(item);
    }

    // Remove the top item: O(1) time, O(1) extra space.
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return list.removeFirst();
    }

    // View the top item without removing it: O(1).
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return list.get(0);
    }

    // Check whether the stack is empty: O(1).
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Number of items: O(1).
    public int size() {
        return list.size();
    }
}