import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class findKClosestIntegers{
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // List<Integer> result = new ArrayList<>();

        // for(int i = 0 ; i < arr.length-1;i++){
        //     int num = arr[i];

        //     if((Math.abs(num) - Math.abs(x) < Math.abs(arr[i+1]) - Math.abs(x)) || (Math.abs(num) - Math.abs(x) == Math.abs(arr[i+1]) - Math.abs(x) && num < arr[i+1])){
        //         if(result.size() <= k){
        //             result.add(num);
        //         }
        //     }
        // }        
        // return result;


        //above solution is wrong

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length-k;

        while(left < right){
            int mid = left + (right - left)/2;

            if(x - arr[mid] > arr[mid + k] - x){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        for(int i = left;i < left + k; i++){
            result.add(arr[i]);
        }
        return result;
    }


    //main
    public static void main(String[] args){

        //int[] arr = {1,2,3,4,5};
        int[] arr = {1,1,2,3,4,5};
        int k = 4;
        int x = -1;
        List<Integer> res = findClosestElements(arr, k, x);
        System.out.println("K Integers closest to "+x+" is:"+res);

    }
    
}