import java.lang.Math;

public class maximumLengthOfRepeatedSubarray{
    public static int findLength(int[] nums1, int[] nums2) {
        int maxlen = 0;
        int currlen = 0;

        for(int i = 0 ;i < nums1.length;i++){
            for(int j = 0; j < nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    currlen = findSubarraylen(i,j,nums1,nums2);

                    //update the maxlen based on currlen
                    maxlen = Math.max(currlen,maxlen);
                }
            }
        }

        return maxlen;   
    }

    //helper function - findSubarraylen()
    public static int findSubarraylen(int i, int j, int[] n1,int[] n2){
        int count = 0;
        int s1 = i;
        int s2 = j;

        while(s1 < n1.length && s2 < n2.length){
            if(n1[s1] != n2[s2]){
                break;
            }
            count = count + 1;
            s1++;
            s2++;
        }

        return count;
    }

    //main
    public static void main(String[] args){
        // int[] num1 = {1,2,3,2,1};
        // int[] num2 = {3,2,1,4,7};
        int[] num1 = {70,39,25,40,7};
        int[] num2 = {52,20,67,5,31};

        int result = findLength(num1,num2);
        System.out.println("The maximum length of repeated subarray in given array is:"+result);
    }
}