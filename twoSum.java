import java.util.HashMap;
import java.util.Map;
public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // for(int i = 0;i < nums.length-1;i++){
        //     for(int j = i+1; j < nums.length;j++){
        //         if((nums[i]+nums[j]) == target){
        //             result[0] = i;
        //             result[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return result;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int compliment = target - nums[i];
            //check in map if compliment exist
            if(map.containsKey(compliment)){
                result[0] = map.get(compliment);
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};

        int[] res = twoSum(nums, 9);
        System.out.println("Indexes of two elements meeting target:"+res[0]+" "+res[1]);
    }
}