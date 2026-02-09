

public class LinearSearch {
    static int search(int [] arr,int target){
        for(int i=0; i<arr.length;i++){ 
            if(arr[i]==target){
                return i;
            }
        }
        return -1;  
    }
     static boolean find(int [] arr,int target){
        for(int i=0; i<arr.length;i++){ 
            if(arr[i]==target){
                return true;
            }
        }
        return false;  
    }
    static int search(String str, char target){
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr={ 2,3,5,6,7,8,1};
        String str="hello";
                    //  0,1,2,3,4
        int target=10;
        System.out.println(search(arr, target));

        System.out.println(search(str, 'e'));

        System.out.println(find(arr, target));

    }
    
}
