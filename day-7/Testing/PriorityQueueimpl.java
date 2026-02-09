import java.util.Collections;
import java.util.*;

public class PriorityQueueimpl {
    public static void main(String[] args) {
        // Min-Heap (default - smallest element first)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Max-Heap (largest element first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // === IMPORTANT FUNCTIONS ===
        
        // 1. offer() - Insert element
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(5);
        System.out.println("After insertions: " + minHeap);
        
        // 2. peek() - View top element (without removing)
        System.out.println("Peek: " + minHeap.peek());
        
        // 3. poll() - Remove and return top element
        System.out.println("Poll: " + minHeap.poll());
        System.out.println("After poll: " + minHeap);
        
        // 4. size() - Get number of elements
        System.out.println("Size: " + minHeap.size());
        
        // 5. isEmpty() - Check if empty
        System.out.println("Is Empty: " + minHeap.isEmpty());
        
        // Polling all elements (gets them in sorted order)
        System.out.println("\nPolling all (sorted order):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
