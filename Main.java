import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // PART 1: LINKED LIST
        System.out.println("===== PART 1: LINKED LIST =====");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);

        System.out.print("Original list: ");
        list.display();

        System.out.println("Item at index 2: " + list.get(2));
        System.out.println("List size: " + list.size());
        System.out.println("Middle item: " + list.findMiddle());

        list.reverse();

        System.out.print("Reversed list: ");
        list.display();

        System.out.println("Removed first item: " + list.removeFirst());

        System.out.print("List after removal: ");
        list.display();


        // PART 2: STACK AND QUEUE
        System.out.println();
        System.out.println("===== PART 2: STACK AND QUEUE =====");

        MyStack<String> stack = new MyStack<>();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack top: " + stack.peek());
        System.out.println("Popped item: " + stack.pop());
        System.out.println("Stack top now: " + stack.peek());

        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Carol");

        System.out.println("Queue first item: " + queue.peek());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Queue first item now: " + queue.peek());

        System.out.println(
                "{[()]} balanced? "
                        + ArrayStringUtils.isBalanced("{[()]}"));

        System.out.println(
                "([)] balanced? "
                        + ArrayStringUtils.isBalanced("([)]"));


        // PART 3: ARRAYS AND STRINGS
        System.out.println();
        System.out.println("===== PART 3: ARRAYS AND STRINGS =====");

        int[] numbers = {1, 2, 3, 4, 5};

        ArrayStringUtils.rotateRight(numbers, 2);

        System.out.println(
                "Array rotated right by 2: "
                        + Arrays.toString(numbers));

        System.out.println(
                "Is 'listen' an anagram of 'silent'? "
                        + ArrayStringUtils.isAnagram("listen", "silent"));

        int[] sortedNumbers = {1, 2, 4, 6, 8, 10};

        int[] result =
                ArrayStringUtils.twoSumSorted(sortedNumbers, 10);

        if (result[0] != -1) {
            System.out.println(
                    "Two-sum indices: "
                            + Arrays.toString(result));
            System.out.println(
                    "Values: "
                            + sortedNumbers[result[0]]
                            + " + "
                            + sortedNumbers[result[1]]);
        } else {
            System.out.println("No matching pair found.");
        }


        // PART 4: LRU CACHE
        System.out.println();
        System.out.println("===== PART 4: LRU CACHE =====");

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "Book");
        cache.put(2, "Laptop");
        cache.put(3, "Phone");

        cache.display();

        // Access key 1, making it the most recently used.
        System.out.println("Get key 1: " + cache.get(1));

        // The cache is full, so key 2 should be evicted.
        cache.put(4, "Tablet");

        cache.display();

        System.out.println("Contains key 1? " + cache.containsKey(1));
        System.out.println("Contains key 2? " + cache.containsKey(2));
        System.out.println("Contains key 4? " + cache.containsKey(4));

        System.out.println();
        System.out.println("All demonstrations completed.");
    }
}
