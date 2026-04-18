// Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.
//Input - 
// n = 9
// arr = 10 5 20 20 4 5 2 25 1

//Output - 
//arr = [2,4]

import java.util.List;
import java.util.ArrayList;

public class breakingRecord{
    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int max = scores.get(0);
        int min = scores.get(0);
        int minp = 0;
        int maxp = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < scores.size();i++){
            if(scores.get(i) < min){
                min = scores.get(i);
                minp++;
            }
            else if(scores.get(i) > max){
                max = scores.get(i);
                maxp++;
            }
        }
        res.add(maxp);
        res.add(minp);
    
    return res;
    }

    //main
    public static void main(String[] args){
        List<Integer> scores = new ArrayList<>();
        //10 5 20 20 4 5 2 25 1
        scores.add(10);
        scores.add(5);
        scores.add(20);              
        scores.add(20);              
        scores.add(4);              
        scores.add(5);
        scores.add(2);
        scores.add(25);
        scores.add(1);
        
        List<Integer> res = breakingRecords(scores);
        System.out.println("Max & Min breaking record Points:"+res);

        //return 0;
    }
}