import java.util.Collection;
import java.util.Arrays;

public class minDiffBetweenHighAndLow{
    public static int findMinDiffBetweenLowHigh(int[] nums,int k){
        

        //Collections.sort(nums);
        Arrays.sort(nums);
        //System.out.println(nums);


        //BELOW IS WRONG
        // if(nums.length < 2){
        //     return 0;
        // }

        // int high = nums[k-1];
        // int low = nums[0];

        // int minDiff = high - low;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i <= nums.length - k;i++){
            if(nums[i+k-1] - nums[i] < minDiff)){
                minDiff = nums[i+k-1] - nums[i];
            }
        }
        return minDiff;
    }

    //main
    public static void main(String[] args){
        int[] nums = {5,6,3,2,8,1};
        int res = findMinDiffBetweenLowHigh(nums,3);
        System.out.println(res);
    }
}