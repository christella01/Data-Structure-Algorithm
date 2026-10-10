public class MyLinkedList<T> {

    // Each node stores data and a link to the next node.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add an item at the beginning: O(1) time, O(1) extra space.
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    // Add an item at the end: O(1) time, O(1) extra space.
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Remove the first item: O(1) time, O(1) extra space.
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }

        T removedItem = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return removedItem;
    }

    // Get an item by index: O(n) time, O(1) extra space.
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index);
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Return the number of items: O(1) time, O(1) extra space.
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Reverse the list in place: O(n) time, O(1) extra space.
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;

        tail = head;

        while (current != null) {
            Node<T> nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    // Find the middle in one pass using slow and fast pointers.
    // O(n) time, O(1) extra space.
    public T findMiddle() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Display the list: O(n) time, O(1) extra space.
    public void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}