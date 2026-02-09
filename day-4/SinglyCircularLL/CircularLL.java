class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLL {
    Node head;
    Node tail;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {     // Empty list
            head = tail = newNode;
            tail.next = head;   // Point to itself
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;   // Update tail's next to new head
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {     // Empty list
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;   // Point back to head
        }
    }

    public void insertAtPosition(int data, int position) {

    // Position 0 or negative → insert at beginning
    if (position <= 0 || head == null) {
        insertAtBeginning(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;

    // Traverse to node before the position
    for (int i = 0; i < position - 1 && temp.next != head; i++) {
        temp = temp.next;
    }

    // If reached tail → insert at end
    if (temp == tail) {
        insertAtEnd(data);
        return;
    }

    // Insert in middle
    newNode.next = temp.next;
    temp.next = newNode;
}

    // Delete from beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {     // Only one node
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Delete from end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {    // Only one node
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
    }

    // Delete at position
    public void deleteAtPosition(int position) {

        // Empty list check
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Position 0 or negative → delete at beginning
        if (position <= 0) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;

        // Traverse to node before the position
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        // If reached tail → position out of bounds
        if (temp == tail || temp.next == head) {
            System.out.println("Position out of bounds");
            return;
        }

        // If deleting the tail node
        if (temp.next == tail) {
            deleteAtEnd();
            return;
        }

        // Delete in middle
        temp.next = temp.next.next;
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLL list = new CircularLL();

    }
}
