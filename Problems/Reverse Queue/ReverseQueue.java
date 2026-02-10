import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    
    // Reverse queue using Stack
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        // Pop all elements from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    
    // Helper method to print queue
    public static void printQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>(queue);
        System.out.print("Queue: ");
        while (!temp.isEmpty()) {
            System.out.print(temp.poll() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        System.out.println("Original Queue:");
        printQueue(queue);
        
        reverse(queue);
        
        System.out.println("Reversed Queue:");
        printQueue(queue);
    }
}
