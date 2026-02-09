
import java.util.ArrayDeque;



public class ArrayDequeimpl {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5); //5
        deque.addFirst(15); //15,5
        deque.removeFirst();   //5
        System.out.println("after removeFirst " + deque);
        deque.addLast(10); //5,10
        deque.addLast(8);   //5,10,8
        deque.removeLast(); //5,10
        System.out.println("after removeLast " + deque);


        //queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(4);
        System.out.println("queue " + queue);
        queue.poll();
        System.out.println("peek " + queue.peek());
    }
     
}
