import java.util.Stack;

// Approach 1: Queue using Two Stacks (Optimized)
// Enqueue: O(1), Dequeue: Amortized O(1)
class QueueUsingTwoStacks {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: O(1)
    // Always push to stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation: Amortized O(1)
    // Pop from stack2, if empty transfer from stack1
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek operation: Amortized O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get size of queue
    public int size() {
        return stack1.size() + stack2.size();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        System.out.println("=== Testing Queue Using Two Stacks ===");
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("Front element: " + queue.peek());  // 10
        System.out.println("Queue size: " + queue.size());     // 4
        
        System.out.println("Dequeued: " + queue.dequeue());    // 10
        System.out.println("Dequeued: " + queue.dequeue());    // 20
        System.out.println("Front element: " + queue.peek());  // 30
        System.out.println("Queue size: " + queue.size());     // 2
        
        queue.enqueue(50);
        System.out.println("Front element: " + queue.peek());  // 30
        System.out.println("Queue size: " + queue.size());     // 3
        
        System.out.println("\nTime Complexity:");
        System.out.println("Enqueue: O(1)");
        System.out.println("Dequeue: Amortized O(1)");
    }
}
