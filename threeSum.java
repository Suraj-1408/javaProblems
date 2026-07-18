import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class threeSum
{
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        
        //BRUTE FORCE
        // for(int i = 0;i < nums.length - 2+1;i++){
        //     for(int k = i+1; k < nums.length-1;k++){
        //         for(int j = k+1;j < nums.length;j++){
        //             if((nums[i]+nums[k]+nums[j]) == 0){
        //                 List<Integer> triplet = new ArrayList();
        //                 triplet.add(nums[i]);
        //                 triplet.add(nums[k]);
        //                 triplet.add(nums[j]);
                        
        //                 if(!result.contains(triplet)){
        //                     result.add(triplet);
        //                 }
        //             }
        //         }
        //     }
        // }
        for(int i = 0;i < nums.length - 2;i++){
            //skip i if i is identical to previous i
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    //skip the left pointer if left value is identical to left + 
                    //1
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    //similarly for right pointer
                    while(left > right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> res = threeSum(nums);
		for(int i = 0;i < res.size();i++){
		    System.out.print(res.get(i));
		}
	}
}
