public class maximumAvgSum{
    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        int start = 0;
        int windowSum = 0;
        double windowAvg = 0;

        for(int end = 0; end < nums.length;end++){
            windowSum = windowSum + nums[end];

            while((end-start+1) > k){
                windowSum = windowSum - nums[start];
                start++;
            }

            if((end-start+1) == k){
                windowAvg = (double)windowSum/k;
                maxAverage = windowAvg > maxAverage ? windowAvg : maxAverage;
            }
        }
        return maxAverage;
    }


    //main
    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result = findMaxAverage(nums,k);
        System.out.println("The Maximum Average for given array and k value is:"+result);
    }
}