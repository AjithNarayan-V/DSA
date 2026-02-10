import java.util.Scanner;

class StackArray {
    int[] stack;
    int top;
    int size;

    StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push
    void push(int data) {
        if (top == size - 1) return;
        stack[++top] = data;
    }

    // Display
    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Delete by position from top
    int deleteByPosition(int pos) {
        if (top == -1 || pos > top + 1) return -1;

        int index = top - pos + 1;
        int val = stack[index];

        for (int i = index; i < top; i++) {
            stack[i] = stack[i + 1];
        }
        top--;
        return val;
    }

    // Search value
    void search(int key) {
        for (int i = top, pos = 1; i >= 0; i--, pos++) {
            if (stack[i] == key) {
                System.out.println("Element " + key + " found at position " + pos + " from top");
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Minimum element
    int findMin() {
        if (top == -1) return -1;
        int min = stack[0];
        for (int i = 1; i <= top; i++) {
            if (stack[i] < min) min = stack[i];
        }
        return min;
    }
}

public class StackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StackArray stack = new StackArray(n);

        for (int i = 0; i < n; i++)
            stack.push(sc.nextInt());

        stack.display();

        int pos = sc.nextInt();
        System.out.println("Element at position " + pos + " is " + stack.deleteByPosition(pos));

        int search = sc.nextInt();
        stack.search(search);

        System.out.print("Updated Stack: ");
        stack.display();

        System.out.println("Minimum Element: " + stack.findMin());
    }
}
