import java.util.List;
import java.util.ArrayList;

public class pairCount{
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int sum = 0;
        int count = 0;
        for(int i = 0;i < ar.size()-1;i++){
            for(int j = i+1; j < ar.size();j++){
                sum = ar.get(i)+ar.get(j);
                
                if((sum%k) == 0){
                    count++;
                }
            }
        }
        
        return count;
    }

    //main
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(6);
        arr.add(1);
        arr.add(2);

        int n = arr.size();
        int k  = 3;

        int pairCount = divisibleSumPairs(n, k,arr);
        System.out.println("Total Pair Counts divisible by "+k+" is:"+pairCount);
    }
}