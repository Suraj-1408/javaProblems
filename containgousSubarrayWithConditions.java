import java.util.Map;
import java.util.HashMap;

public class containgousSubarrayWithConditions{
    public static boolean checkSubarraySum(int[] nums, int k) {
    
        HashMap<Integer,Integer> store = new HashMap<>();   //track each new remainder and their position
        store.put(0,0);     //very imp - Without it: any answer subarray starting at index 0 is invisible — because there's no left endpoint to subtract from.
        int runningSum = 0;
        for(int i = 0; i < nums.length;i++){
            runningSum = runningSum + nums[i];
            
            int position = (runningSum % k);
            if(store.containsKey(position)){
                int firstStep = store.get(position);        //getting the firststep where we found the remainder
                int currentStep = i + 1;        //fetching current step.

                //main core condition      - if subarray length >=2
                if(currentStep - firstStep >= 2){
                    return true;
                }
            }
            else{
                store.put(position,i+1);            //adding the new remainder, and it position
            }
        }
        return false;        
    }

    //main
    public static void main(String[] args){
        int[] arr = {23,2,4,6,7};
        int k = 6;

        boolean res = checkSubarraySum(arr,k);

        if(res){
            System.out.println("Subarray found with length >= 2 & sum with multiple of k");
        }else{
            System.out.println("No Subarray found with length>=2 & sum with multiple of k");
        }
    }
}