import java.util.List;
import java.util.ArrayList;

public class slidingProblem{
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int start  = 0;
        int sum = 0;
        int count = 0;
        for(int end = 0; end < s.size();end++){
            sum = sum + s.get(end);
            
            //update start
            while(sum > d){
                sum = sum - s.get(start);
                start++;
            }
            
            if(sum == d){
                if((end-start + 1) == m){
                    count++;
                }
            }
        }
        
        return count;
    }

    //main
    public static void main(String[] args){
        List<Integer> s = new ArrayList<>();
        // s.add(2);
        // s.add(2);
        // s.add(1);
        // s.add(3);
        // s.add(2);

        s.add(1);
        s.add(1);
        s.add(1);
        s.add(1);
        s.add(1);

        int d = 3;
        int m = 2;
        
        int no_of_ways = birthday(s,d,m);
        System.out.println("No. of possible ways bar can be divided:"+no_of_ways);
    }
}