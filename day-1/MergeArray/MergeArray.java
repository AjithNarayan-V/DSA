
import java.util.Arrays;


public class MergeArray {
    static void merge(int [] arr, int start ,int mid, int end){
        int arr3l=arr.length;
        int [] arr3= new int [arr3l];
        int i=start,j=mid,k=start;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                arr3[k]=arr[i];
                i++;
                k++;
            }
            else{
                arr3[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<mid){
            arr3[k]=arr[i];
            i++;
            k++;
        }
         while(j<end){
            arr3[k]=arr[j];
            j++;
            k++;
        }
         for(int itr=start; itr<end; itr++){
            arr[itr]=arr3[itr];
         }
    }
    static void mergesort(int [] arr,int start, int end){ //10 ->0-4(5)->
        if(end-start ==1)
            return;
        int mid =(start+end)/2; //5->2
        mergesort(arr, start, mid);
        mergesort(arr, mid, end);
        merge(arr,start,mid, end);
    }

    public static void main(String[] args) {
        // int [] arr1 ={1,2,4,6,7};
        // int [] arr2 ={1,3,5,6,8;
        int [] arr={3,5,7,2,7,1,8,2,4,8,2,7,4};
        mergesort(arr,0,arr.length);


        // merge(arr, 0,mid,arr.length);
        System.out.println(Arrays.toString(arr));
       }
}
