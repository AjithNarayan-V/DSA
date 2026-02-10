// MinStack implementation USING Java Collections (Stack class)

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;      // Main stack
    private Stack<Integer> minStack;   // Stack to track minimum values

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Push element - O(1)
    public void push(int val) {
        // Push to main stack
        stack.push(val);

        // Push to minStack if it's empty or val is <= current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop element - O(1)
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        int removed = stack.pop();

        // If removed element is the current minimum, pop from minStack too
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get top element - O(1)
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.peek();
    }

    // Get minimum element - O(1)
    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return minStack.peek();
    }

    // Main method (for VS Code / local run)
    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        System.out.println("Top: " + minStack.top());       // 2
        System.out.println("Min: " + minStack.getMin());    // 2

        minStack.pop();

        System.out.println("Top after pop: " + minStack.top());   // 7
        System.out.println("Min after pop: " + minStack.getMin()); // 3
    }
}
