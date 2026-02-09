import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Create ArrayDeque using Collections
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("=== ArrayDeque Using Collections ===\n");

        // Insert at rear (addLast / offerLast)
        deque.addLast(10);
        System.out.println("Inserted 10 at rear");
        deque.addLast(20);
        System.out.println("Inserted 20 at rear");

        // Insert at front (addFirst / offerFirst)
        deque.addFirst(5);
        System.out.println("Inserted 5 at front");
        deque.addFirst(3);
        System.out.println("Inserted 3 at front");
        deque.addLast(30);
        System.out.println("Inserted 30 at rear");

        System.out.println("\nDeque: " + deque);
        System.out.println("Size: " + deque.size());

        // Peek operations (peekFirst / peekLast)
        System.out.println("\nFront element (peekFirst): " + deque.peekFirst());
        System.out.println("Rear element (peekLast): " + deque.peekLast());

        // Delete from front (removeFirst / pollFirst)
        System.out.println("\nDeleted from front: " + deque.removeFirst());
        
        // Delete from rear (removeLast / pollLast)
        System.out.println("Deleted from rear: " + deque.removeLast());

        System.out.println("\nDeque after deletions: " + deque);
        System.out.println("Size: " + deque.size());

        // Check if empty
        System.out.println("\nIs empty? " + deque.isEmpty());

        // Add more elements
        deque.addFirst(1);
        System.out.println("\nInserted 1 at front");
        deque.addLast(40);
        System.out.println("Inserted 40 at rear");

        System.out.println("\nFinal Deque: " + deque);

        // Using as Stack (LIFO)
        System.out.println("\n=== Using Deque as Stack ===");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(100);  // addFirst
        stack.push(200);
        stack.push(300);
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());  // removeFirst
        System.out.println("Peek: " + stack.peek());  // peekFirst

        // Using as Queue (FIFO)
        System.out.println("\n=== Using Deque as Queue ===");
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(100);  // addLast
        queue.offer(200);
        queue.offer(300);
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());  // removeFirst
        System.out.println("Peek: " + queue.peek());  // peekFirst
    }
}
