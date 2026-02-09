
public class QueueLL {
    class Node{
        int data;
        Node next;
        Node( int data){
            this.data=data;
            next=null;
        }
    }
        Node front=null;
        Node rear=null;

        boolean isEmpty(){
            if(front==null){
                return true;
            }
            else{
                return false;
            }
        }

        void enqueue(int data){
            Node newNode=new Node(data);
            if(front==null){
                front =rear=newNode;
            }
            else{
                rear.next=newNode;
                rear=rear.next;
            }
        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int removed=front.data;
            front=front.next;
            if(front==null){
                rear=null;
            }
            return removed;
        }
        int peekAtStart(){
            return front.data;

        }
        int peekAtEnd(){
            return rear.data;
        }
        int contains(int target){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            Node temp=front;
            int pos=0;
            while(temp!=null){
                if(target==temp.data){
                    return  pos+1;
                }
                pos++;
                temp=temp.next;
            }
            return -1;
        }
        void display(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return;
            }
            Node temp=front;
            while(temp!=null){
                System.out.print(temp.data + " ->");
                temp=temp.next;
            }
            System.out.println(" ");
                
        }

    

    public static void main(String[] args) {
        QueueLL obj= new QueueLL();
        
        obj.enqueue(4);
        obj.enqueue(5);
        obj.enqueue(6);
        obj.enqueue(8);
        obj.display();
        obj.dequeue();
        obj.display();
        System.out.println("peek at start" + obj.peekAtStart());
        System.out.println("peek at end"+ obj.peekAtEnd());
        System.out.println(obj.contains(6));






        


        
    }
    
}
