import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class threeSumProblemRevise
{
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 3;i++){
            // for(int j = i+1; j < nums.length - 2;j++){
            //     for(int k = j+1; k < nums.length ;k++){
            //         if((nums[i]+nums[j]+nums[k]) == 0){
            //             List<Integer> triplet = new ArrayList<>();
            //             triplet.add(nums[i]);
            //             triplet.add(nums[j]);
            //             triplet.add(nums[k]);
            //             if(!triplets.contains(triplet)){
            //                 triplets.add(triplet);
            //             }
            //         }
            //     }
            // }
            
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if(!triplets.contains(triplet)){
                        triplets.add(triplet);
                    }
                    
                    //skipping left pointer until value of nums[left] & nums[left+1] are same.
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    
                    //skipping left pointer until value of nums[right] & nums[right-1] are same.
                    while(left < right && nums[right] == nums[right-1]){
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
        
        return triplets;
    }    
	public static void main(String[] args) {
        //System.out.println("Hello World");
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("List of triplets for given array nums:"+result);
	}
}
