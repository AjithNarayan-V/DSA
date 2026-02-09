
import java.util.Scanner;




public class QueueArr1 {
    int arr[];
    int capacity;
    int front;
    int rear;
    int size;   

    QueueArr1(int capacity){
        arr= new int[capacity];
        this.capacity=capacity;
        front=-1;
        rear=-1;
    }
    boolean isEmpty(){
        return front==-1;
    }

    boolean isFull(){
        return front==(rear+1)%capacity;
    }

    void enqueue(int data){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        // if(front ==-1){
        //     front++;
        //     rear=(rear+1)%capacity;
        //     arr[rear]=data;
        // }
        // else{
        //  rear=(rear+1)%capacity;
        // arr[rear]=data;
        // }
        if(front ==-1){
            front++;
        }
         rear=(rear+1)%capacity;
         arr[rear]=data;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        if(front ==rear){
            front =rear=-1;
        }
        int removed= arr[front];
        front =(front+1)%capacity;
        return removed;
    }

    void display(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        int temp= front;
        do { 
            System.out.print(arr[temp]+" <-");
            temp=(temp+1)%capacity;  
        } while (temp!=(rear+1) % capacity);
    }


    public static void main(String[] args) {
 Scanner sc= new Scanner(System.in);
        int capacity;
        System.out.println("enter the capacity of queue");
        capacity=sc.nextInt();
       
        QueueArr1 queue = new QueueArr1(capacity);
        System.out.println("enter no of queue elements");
        int n= sc.nextInt();

        for( int i=1; i<=n;i++){
            int data= sc.nextInt();
            queue.enqueue(data); 
        }
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        queue.enqueue(66);
                queue.display();


        
    }
     
    
}
