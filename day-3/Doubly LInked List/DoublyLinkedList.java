class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class DoublyLinkedList {
    Node head;
    Node tail;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {     // Empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end (using tail)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {     // Empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at position
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        // Traverse to the node before the position
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        if (temp.next == null) {    // Insert at end
            insertAtEnd(data);
            return;
        }

        // Insert in middle
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {    // Only one node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from end
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {    // Only one node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete at position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position <= 0) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;

        // Traverse to the node at the position
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        if (temp == tail) {    // Delete at end
            deleteAtEnd();
            return;
        }

        // Delete in middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Display forward
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(15);
        list.insertAtBeginning(3);
        list.insertAtEnd(20);
        list.insertAtBeginning(2);
        list.insertAtEnd(25);
        list.insertAtBeginning(1);

        list.displayForward();  // 1 <-> 2 <-> 3 <-> 5 <-> 10 <-> 15 <-> 20 <-> 25 <-> null
        list.displayBackward(); // 25 <-> 20 <-> 15 <-> 10 <-> 5 <-> 3 <-> 2 <-> 1 <-> null
        


       
    }
}