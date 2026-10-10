public class ArrayStringUtils {

    private ArrayStringUtils() {
        // Prevent creating an object of this utility class.
    }

    // Rotate an array to the right in O(n) time and O(1) space.
    public static void rotateRight(int[] a, int k) {
        if (a == null || a.length <= 1) {
            return;
        }

        k = k % a.length;

        if (k < 0) {
            k += a.length;
        }

        reverseArray(a, 0, a.length - 1);
        reverseArray(a, 0, k - 1);
        reverseArray(a, k, a.length - 1);
    }

    private static void reverseArray(int[] a, int left, int right) {
        while (left < right) {
            int temporary = a[left];
            a[left] = a[right];
            a[right] = temporary;

            left++;
            right--;
        }
    }

    // Check whether two strings are anagrams.
    // O(n) time and O(1) auxiliary space for Java char values.
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int[] counts = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < a.length(); i++) {
            counts[a.charAt(i)]++;
            counts[b.charAt(i)]--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Return the two indices of a pair in a sorted array.
    // O(n) time and O(1) extra space.
    // Returns {-1, -1} if no pair exists.
    public static int[] twoSumSorted(int[] a, int target) {
        if (a == null) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            long sum = (long) a[left] + a[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // Check balanced brackets using our own stack.
    // O(n) time and O(n) extra space.
    public static boolean isBalanced(String expr) {
        if (expr == null) {
            return false;
        }

        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (ch == ')' && opening != '(') {
                    return false;
                }

                if (ch == ']' && opening != '[') {
                    return false;
                }

                if (ch == '}' && opening != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}