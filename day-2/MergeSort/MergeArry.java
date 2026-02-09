
import java.util.Arrays;

public class MergeArry {
    static int [] merge(int [] arr1,int []arr2){
        int a1l=arr1.length;
        int a2l=arr2.length;
        int a3l=a1l+a2l;
        int [] arr3= new int[a3l];
        int i=0, j=0,k=0;
        while(i<a1l && j<a2l){
            if(arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k]=arr2[j];
                j++;
                k++;
            }
        }
        while(i<a1l){
            arr3[k]=arr1[i];
            i++;
            k++;
        }
         while(j<a2l){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        return arr3;
    }

    public static void main(String[] args) {
        int [] arr1={1,3,4,6,8};
        int [] arr2={1,2,5,7,9};
        System.out.println(Arrays.toString(merge(arr1,arr2)));

    }
    
}
