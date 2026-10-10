 import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    // Each node has links in both directions.
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> previous;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> cache;

    // Most recently used entries are near the front.
    // Least recently used entries are near the back.
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero.");
        }

        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node<>(null, null);
        tail = new Node<>(null, null);

        head.next = tail;
        tail.previous = head;
    }

    // Remove a node from its current position: O(1).
    private void removeNode(Node<K, V> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Insert a node immediately after head: O(1).
    private void addToFront(Node<K, V> node) {
        node.next = head.next;
        node.previous = head;

        head.next.previous = node;
        head.next = node;
    }

    // Mark a node as most recently used: O(1).
    private void moveToFront(Node<K, V> node) {
        removeNode(node);
        addToFront(node);
    }

    // Get a value: expected O(1).
    // Returns null if the key is not present.
    public V get(K key) {
        Node<K, V> node = cache.get(key);

        if (node == null) {
            return null;
        }

        moveToFront(node);
        return node.value;
    }

    // Add or update a value: expected O(1).
    public void put(K key, V value) {
        Node<K, V> existingNode = cache.get(key);

        if (existingNode != null) {
            existingNode.value = value;
            moveToFront(existingNode);
            return;
        }

        Node<K, V> newNode = new Node<>(key, value);
        cache.put(key, newNode);
        addToFront(newNode);

        if (cache.size() > capacity) {
            Node<K, V> leastRecentlyUsed = tail.previous;

            removeNode(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
    }

    public int size() {
        return cache.size();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // Display entries from most recently used to least recently used.
    public void display() {
        Node<K, V> current = head.next;

        System.out.print("Cache (most recent first): ");

        while (current != tail) {
            System.out.print(
                    "[" + current.key + "=" + current.value + "] ");
            current = current.next;
        }

        System.out.println();
    }
}
