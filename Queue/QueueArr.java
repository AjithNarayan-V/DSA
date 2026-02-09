
public class QueueArr {
    int capacity;
    int arr[];
    int front;
    int rear;
    int size;
    QueueArr(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    void enqueue(int data){
        if(rear==capacity-1){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front++;
            rear++;
            arr[rear]=data;
            size++;
            return;
        }
        rear++;
        arr[rear]=data;
        size++;
    }

    int dequeue(){
        if(front==-1 ||front>rear){
            System.out.println("queue empty");
            return -1;
        }
        int removed=arr[front];
        front++;
        size--;
        return removed;
        // return arr[front++];
    }
    boolean isEmpty(){
        if(front==-1 || front>rear){
            return true;
        }
        else{
            return false;
        }
    }
    int peekAtFirst(){
        if(isEmpty()){
            System.out.println("queue empty");
            return -1;
        }
        return arr[front];

    }
    int peekAtEnd(){
         if(isEmpty()){
            System.out.println("queue empty");
            return -1;
        }
    return arr[rear];
    }
    int contains(int target){
         if(isEmpty()){
            System.out.println("queue empty");
            return -1;
        }
        for(int i=front;i<=rear;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    int size(){

         if(isEmpty()){
            System.out.println("queue empty");
            return -1;
        }
        // int count=0;
        // for(int i=front;i<=rear;i++){
        //    count++;
        // }
        // return count;
        return size;
    }
    void display(){
         if(isEmpty()){
            System.out.println("queue empty");
            return ;
        }
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
        
        QueueArr obj= new QueueArr(5);
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.display();
        obj.enqueue(6);
        obj.dequeue();
        obj.dequeue();
        obj.display();
        System.out.println(obj.size());




    }
    
}
