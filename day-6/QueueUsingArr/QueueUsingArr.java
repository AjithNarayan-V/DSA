
public class QueueUsingArr {
  int size;
  int arr[];
  int front = -1;
  int rear = -1;
  int count = 0;    

  QueueUsingArr( int size) {
    this.size=size;
      arr = new int[size];
  }

  void enqueue(int data) {
      if (rear == size - 1) {
          throw new IndexOutOfBoundsException("Queue is Full");
      }
      if (front == -1 && rear == -1) {
          front++;
      }
      arr[++rear] = data;
      count++;
  }

  int dequeue() {
      if (front == -1 || rear == -1 || front > rear) {
          throw new IndexOutOfBoundsException("Queue is Empty");
      }
      count--;
      return arr[front++];
  }
  int peek() {
      if (front == -1 || rear == -1 || front > rear) {
          throw new IndexOutOfBoundsException("Queue is Empty");
      }
      return arr[front];
  }
    int peekRear() {
        if (front == -1 || rear == -1 || front > rear) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        return arr[rear];
    }
    int size() {
        return count;
    }

    boolean contains(int data) {
        if (front == -1 || rear == -1 || front > rear) {
            return false;
        }
        for (int i = front; i <= rear; i++) {
            if (arr[i] == data) {
                return true;
            }
        }
        return false;
    }

  public static void main(String[] args) {
      QueueUsingArr q = new QueueUsingArr(3);
      q.enqueue(10);
      q.enqueue(0);
      q.enqueue(50);

      System.out.println(q.peek());
      System.out.println("r" + q.peekRear());
      System.out.println(q.size());

      // q.enqueue(50);
      System.out.println("d" + q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
  }
}
