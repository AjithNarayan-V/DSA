import java.util.Stack;

class DeleteMiddleStack {

    public static void deleteMiddle(Stack<Integer> stack) {

        int size = stack.size();
        int mid = size / 2;   // middle index (0-based from top)

        Stack<Integer> temp = new Stack<>();

        // Step 1: Remove elements till middle
        for (int i = 0; i < mid; i++) {
            temp.push(stack.pop());
        }

        // Step 2: Remove middle element
        stack.pop();

        // Step 3: Push elements back
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // Driver code
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMiddle(stack);

        System.out.println(stack); // [1, 2, 4, 5]
    }
}
