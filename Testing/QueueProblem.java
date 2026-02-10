import java.util.Scanner;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLL {
    QueueNode front, rear;

    // Enqueue
    void enqueue(int data) {
        QueueNode node = new QueueNode(data);
        if (front == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    // Display
    void display() {
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Delete by position from front
    int deleteByPosition(int pos) {
        if (front == null) return -1;

        if (pos == 1) {
            int val = front.data;
            front = front.next;
            if (front == null) rear = null;
            return val;
        }

        QueueNode curr = front;
        for (int i = 1; i < pos - 1 && curr.next != null; i++) {
            curr = curr.next;
        }

        int val = curr.next.data;
        curr.next = curr.next.next;
        if (curr.next == null) rear = curr;
        return val;
    }

    // Search
    void search(int key) {
        QueueNode temp = front;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Customer " + key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Customer not found");
    }

    // Minimum element
    int findMin() {
        QueueNode temp = front;
        int min = Integer.MAX_VALUE;
        while (temp != null) {
            min = Math.min(min, temp.data);
            temp = temp.next;
        }
        return min;
    }
}

public class QueueProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLL queue = new QueueLL();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            queue.enqueue(sc.nextInt());

        queue.display();

        int pos = sc.nextInt();
        System.out.println("Customer at position " + pos + " is " + queue.deleteByPosition(pos));

        int search = sc.nextInt();
        queue.search(search);

        System.out.print("Updated Queue: ");
        queue.display();

        System.out.println("Minimum Element: " + queue.findMin());
    }
}
