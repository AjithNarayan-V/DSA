
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class BCheck {

    Node top;

    void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        if (top == null) {
            System.out.println("Underflow");
            return '\0';
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    char peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return '\0';
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

  boolean isValid(String exp ) {
      BCheck stack = new BCheck();
      for(char c: exp.toCharArray()) {
          if(c == '{' || c == '(' || c == '[') {
              stack.push(c);
          }
          else if(c == '}' || c == ')' || c == ']') {
              if(stack.isEmpty()) {
                  return false;
              }
              char current = stack.pop();
              if((current == '{' && c != '}') ||
                 (current == '[' && c != ']') ||
                 (current == '(' && c != ')')) {
                  return false;
              }
          }
      }
      return stack.isEmpty();
  }

  public static void main(String[] args) {
      BCheck st = new BCheck();
      System.out.println(st.isValid("((a+b))"));
  }
}
