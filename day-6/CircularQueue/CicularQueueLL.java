
public class CicularQueueLL {
    // Node class for linked list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor
    public CicularQueueLL() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add element to the queue (enqueue)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            rear.next = front;  // Make it circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;  // Maintain circular link
        }
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Remove element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue");
            return -1;
        }
        
        int data = front.data;
        
        if (front == rear) {
            // Only one element in queue
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;  // Maintain circular link
        }
        size--;
        return data;
    }

    // Get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Get the rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return rear.data;
    }

    // Get current size of the queue
    public int getSize() {
        return size;
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue: ");
        Node current = front;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != front);
        System.out.println();
    }

    public static void main(String[] args) {
        CicularQueueLL queue = new CicularQueueLL();

        // Test enqueue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        // Test dequeue
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        // Enqueue after dequeue
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        // Test peek and getRear
        System.out.println("Front element: " + queue.peek());
        System.out.println("Rear element: " + queue.getRear());
        System.out.println("Queue size: " + queue.getSize());

        // Dequeue all elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        queue.display();
    }
}
