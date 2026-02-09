
import java.util.Arrays;

public class SortArray {
    static void merge(int [] arr, int start, int mid, int end){
        int a3l=arr.length;
        int [] arr3= new int[a3l];
        int i=start, j=mid,k=start;
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
        
        for(int itr=0; itr<arr3.length;itr++){
            arr[itr]=arr3[itr];
        }
    }

    public static void main(String[] args) {
        int [] arr1={1,3,4,6,8,1,2,5,7,9};
        // int [] arr2={1,2,5,7,9};
        int mid= arr1.length/2;

        merge(arr1,0,mid,arr1.length);
        System.out.println(Arrays.toString(arr1));

    }
    
}
