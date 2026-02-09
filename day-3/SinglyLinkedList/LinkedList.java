
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LinkedList {
    Node head;

    void  insert(int data){
        Node newNode= new Node(data);
        if( head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;

    }

    // Insert at the beginning of the list
    void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at a specific position (0-indexed)
    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    // Search for an element in the list
    int search(int key) {
        Node temp = head;
        int position = 0;
        
        while (temp != null) {
            if (temp.data == key) {
                return position;  // Element found, return position
            }
            temp = temp.next;
            position++;
        }
        
        return -1;  // Element not found
    }

    // Delete the first node
    void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete at a specific position (0-indexed)
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (position == 0) {
            head = head.next;
            return;
        }
        
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        temp.next = temp.next.next;
    }

    // Delete the last node
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == null) {
            head = null;
            return;
        }
        
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    void traverse(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll= new LinkedList();

        ll.insert(2);
        ll.insert(5);
        ll.traverse();
        ll.insertAtFirst(10);
        ll.traverse();

        ll.insertAtPosition(7, 1);
        ll.traverse();

        ll.deleteAtFirst();
        ll.traverse();

        ll.deleteAtPosition(1);
        ll.traverse();

        ll.deleteAtEnd();
        ll.traverse();

        
        }
        
    }