import java.util.LinkedList;
import java.util.Queue;

// Approach 1: Stack using Single Queue
// Push operation is O(n), Pop operation is O(1)
class StackUsingSingleQueue {
    private Queue<Integer> queue;

    public StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    // Push operation: O(n)
    // Add new element and rotate all previous elements
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        
        // Rotate the queue so that the new element is at front
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    // Pop operation: O(1)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.remove();
    }

    // Peek operation: O(1)
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get size of stack
    public int size() {
        return queue.size();
    }
}

// Approach 2: Stack using Two Queues
// Push operation is O(1), Pop operation is O(n)
class StackUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation: O(1)
    // Simply add to queue1
    public void push(int x) {
        queue1.add(x);
    }

    // Pop operation: O(n)
    // Move all elements except last from queue1 to queue2
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Get the last element (top of stack)
        int popped = queue1.remove();

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return popped;
    }

    // Peek operation: O(n)
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
    

        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Peek the last element
        int top = queue1.peek();
        queue2.add(queue1.remove());

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get size of stack
    public int size() {
        return queue1.size();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        System.out.println("=== Testing Stack Using Single Queue ===");
        StackUsingSingleQueue stack1 = new StackUsingSingleQueue();
        
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);
        
        System.out.println("Top element: " + stack1.top());  // 40
        System.out.println("Stack size: " + stack1.size());  // 4
        
        System.out.println("Popped: " + stack1.pop());  // 40
        System.out.println("Popped: " + stack1.pop());  // 30
        System.out.println("Top element: " + stack1.top());  // 20
        System.out.println("Stack size: " + stack1.size());  // 2
        
        stack1.push(50);
        System.out.println("Top element: " + stack1.top());  // 50
        
        System.out.println("\n=== Testing Stack Using Two Queues ===");
        StackUsingTwoQueues stack2 = new StackUsingTwoQueues();
        
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        stack2.push(40);
        
        System.out.println("Top element: " + stack2.top());  // 40
        System.out.println("Stack size: " + stack2.size());  // 4
        
        System.out.println("Popped: " + stack2.pop());  // 40
        System.out.println("Popped: " + stack2.pop());  // 30
        System.out.println("Top element: " + stack2.top());  // 20
        System.out.println("Stack size: " + stack2.size());  // 2
        
        stack2.push(50);
        System.out.println("Top element: " + stack2.top());  // 50
        
        System.out.println("\n=== Comparison ===");
        System.out.println("Single Queue: Push O(n), Pop O(1)");
        System.out.println("Two Queues: Push O(1), Pop O(n)");
    }
}
