public class BinarySearch{
    static int search(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target)
                start=mid+1;
            
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {15,14,10,9,6,4,3,2,1};
        int target= 3;
        System.out.println(search(arr,target));         
    }
}