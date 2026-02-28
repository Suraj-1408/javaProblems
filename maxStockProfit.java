import java.util.*;

public class maxStockProfit{
    public static int maxProfit(int[] arr){
        int max = 0;
        for(int i = 0;i < arr.length;i++){
            int currStock = arr[i];
            for(int j = i+1;j < arr.length;j++){
                if((arr[j] - currStock) > max){
                    max = arr[j] - currStock;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        //int[] price1 ={7, 10, 1, 3, 6, 9, 2};
        int[] price = {7, 6, 4, 3, 1}; 
        for(int i = 0; i < price.length;i++){
            System.out.print(price[i]+"\t");
        }

        int max = maxProfit(price);
        System.out.println("\nMax Profit Possible is:"+max);
    }
}

