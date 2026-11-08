public class countNumofNonEmptySubarrayMeetingGivenTarget{
    public static int numSubarraysWithSum(int[] nums, int goal) {
        // int sum = 0;
        // int left = 0;
        // int count = 0;

        // for(int right = 0; right < nums.length;right++){
        //     sum = sum + nums[right];

        //     while(sum > goal){
        //         sum = sum - nums[left];
        //         left++;
        //     }

        //     if(sum == goal){
        //         count = count + 1;

        //         //extra subarray having zero element
        //         while(left < right && nums[left] == 0){
        //             count++;
        //             left++;
        //         }
        //     }
        // }
        // return count;

        //NOTE - ABOVE SOLUTION FAILS SOME TEST CASE AND ALSO PROPER SOLUTION.
        //SOLUTION - CREATE ONE HELPER FUNCTION THAT WILL COUNT VALID SUBARRAY WHERE SUM <= GIVEN GOAL.
        
        //THEN USE THIS SET DIFFERENCE PROPERTY
        // exactly(goal) = atMost(goal) - atMost(goal-1)
        // [sum <= goal] - [sum <= goal-1] = [sum == goal]
        return atMost(nums,goal) - atMost(nums,goal-1);
    }

    //helper function - 
    //this function will compute the total valid subarray count where sum <= goal.
    public static int atMost(int[] nums , int goal){

        if(goal < 0) return 0;

        int sum  = 0;
        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length;right++){
            sum = sum + nums[right];

            while(sum > goal){
                sum = sum - nums[left++];       //first deduct sum and then increment left++;
            }

            count = count + (right - left + 1);
        }
        return count;
    }
    

    //main
    public static void main(String[] args){
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        int res = numSubarraysWithSum(nums, goal);
        System.out.println("Count of non-empty subarray matching given sum is:"+res);
    }
}