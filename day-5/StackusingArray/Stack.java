

class Stack {
    int top;
    int size;
    int[] stack;

    // Constructor
    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push operation
    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    // Pop operation
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Peek operation
    int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // Check empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check full
    boolean isFull() {
        return top == size - 1;
    }
    int getSize() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());   // 30
        System.out.println(s.peek());  // 20
        System.out.println(s.isEmpty()); // false
    }
}

    
