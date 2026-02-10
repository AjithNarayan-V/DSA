
import java.util.LinkedList;
import java.util.Stack;


class ReverseStack {
    static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        return temp;
    }
    
    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<> ();
       LinkedList <Integer> list = new LinkedList<>();
       stack.push(5);
       stack.push(6);
        stack.push(8);
        stack.push(9);

        System.out.println("before reverse: "+stack);

        
        System.out.println("after reverse: "+reverse(stack));

    }
}
