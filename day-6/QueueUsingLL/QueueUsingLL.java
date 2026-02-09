
public class QueueUsingLL {
  class Node {
      int data;
      Node next;
      Node(int data) {
          this.data = data;
          this.next = null;
      }
  }

  Node front, rear;

  void enqueue(int data) {
      Node newNode = new Node(data);
      if (front == null) {
          front = newNode;
          rear = newNode;
          return;
      }
      rear.next = newNode;
      rear = rear.next;
  }

  int dequeue() {
      if (isEmpty()) {
          throw new IndexOutOfBoundsException("Queue is Empty");
      }
      int temp = front.data;
      front = front.next;
      if (front == null) {
          rear = null; // Reset rear when queue becomes empty
      }
      return temp;
  }

  // Check if queue is empty
  boolean isEmpty() {
      return front == null;
  }

  // Get the front element without removing it
  int peek() {
      if (isEmpty()) {
          throw new IndexOutOfBoundsException("Queue is Empty");
      }
      return front.data;
  }

  // Get the rear element
  int peekRear() {
      if (isEmpty()) {
          throw new IndexOutOfBoundsException("Queue is Empty");
      }
      return rear.data;
  }

  // Get the size of the queue
  int size() {
      int count = 0;
      Node temp = front;
      while (temp != null) {
          count++;
          temp = temp.next;
      }
      return count;
  }

  // Traverse and print all elements
  void traverse() {
      if (isEmpty()) {
          System.out.println("Queue is Empty");
          return;
      }
      System.out.print("Queue: ");
      Node temp = front;
      while (temp != null) {
          System.out.print(temp.data + " ");
          temp = temp.next;
      }
      System.out.println();
  }


  // Check if an element exists in the queue
  boolean contains(int data) {
      Node temp = front;
      while (temp != null) {
          if (temp.data == data) {
              return true;
          }
          temp = temp.next;
      }
      return false;
  }

  public static void main(String[] args) {
      QueueUsingLL q = new QueueUsingLL();
      
      // Test isEmpty on empty queue
      System.out.println("Is Empty: " + q.isEmpty());
      
      // Enqueue elements
      q.enqueue(10);
      q.enqueue(20);
      q.enqueue(30);
      q.enqueue(40);
      
      // Test traverse
      q.traverse();
      
      // Test size
      System.out.println("Size: " + q.size());
      
      // Test peek
      System.out.println("Front element (peek): " + q.peek());
      System.out.println("Rear element (peekRear): " + q.peekRear());
      
      // Test contains
      System.out.println("Contains 20: " + q.contains(20));
      System.out.println("Contains 100: " + q.contains(100));
      
      // Test dequeue
      System.out.println("Dequeued: " + q.dequeue());
      q.traverse();
      
      // Test isEmpty after operations
      System.out.println("Is Empty: " + q.isEmpty());
      
      System.out.println("After clear - Is Empty: " + q.isEmpty());
  }
}
