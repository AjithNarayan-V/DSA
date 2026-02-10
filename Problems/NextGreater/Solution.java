import java.util.*;
    
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] tracker = new int[10001];
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            tracker[current] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(current);
        }

        // Update nums1 with next greater elements
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = tracker[nums1[i]];
        }

        return nums1;
    }

    // 🔹 Main method for local execution
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}
