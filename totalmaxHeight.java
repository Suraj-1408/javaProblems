// You are in charge of the cake for a child's birthday. It will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Your task is to count how many candles are the tallest.

import java.util.List;
import java.util.ArrayList;

public class totalmaxHeight{
    public static int totalMax(List<Integer> candles){
        int max = candles.get(0);
        for(int i = 1;i < candles.size();i++){
            //(arr[i] > max)?(max = arr[i]): max;
            if(candles.get(i) > max){
                max = candles.get(i);
            }
        }
        
        int count = 0;
        for(int i = 0;i < candles.size();i++){
            if(candles.get(i) == max){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(4);

        int max = totalMax(arr);
        System.out.println(max);
    }
}