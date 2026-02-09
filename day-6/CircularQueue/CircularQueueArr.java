


public class CircularQueueArr {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    // Constructor to initialize the circular queue
    public CircularQueueArr(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    // Add element to the queue (enqueue)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + data);
            return;
        }
        if (isEmpty()) {
            front ++;
        }
        rear = (rear + 1) % capacity;  // Circular increment
        arr[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Remove element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue");
            return -1;
        }
        int data = arr[front];
        if (front == rear) {
            // Queue becomes empty after this dequeue
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;  // Circular increment
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
        return arr[front];
    }

    // Get the rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[rear];
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
        int i = front;
        do {
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity;
        } while (i != (rear + 1) % capacity);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueArr queue = new CircularQueueArr(5);
        

        // Test enqueue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        // Try to enqueue when full
        queue.enqueue(60);

        // Test dequeue
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        // Enqueue after dequeue (demonstrates circular nature)
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        // Test peek and getRear
        System.out.println("Front element: " + queue.peek());
        System.out.println("Rear element: " + queue.getRear());
        System.out.println("Queue size: " + queue.getSize());
    }
}
