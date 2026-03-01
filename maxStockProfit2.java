import java.util.*;

public class maxStockProfit2{

    public static int maxProfit(int[] prices){
        int max  = 0;   //objective - stores maximum profit.
        int maxSoFar  = prices[prices.length - 1];      //this keep track of maximum from right.

        for(int i = prices.length - 2; i >= 0;i--){
            //update max if difference of future max & current stock price is higher than existing max.
            max = Math.max(max, maxSoFar - prices[i]);
            
            //Now, next update maxSoFar if current stock price is higher than existing maxSoFar.
            maxSoFar = Math.max(maxSoFar,prices[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        int max = maxProfit(prices);
        System.out.println("Maximum:"+max);
    }
}
