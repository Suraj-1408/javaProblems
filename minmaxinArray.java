// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
// The minimum sum is  and the maximum sum is . The function prints


import java.util.ArrayList;
import java.util.List;


public class minmaxinArray{

    public static void minmax(List<Integer> arr){
// 2 1 0
        for(int i = 0;i < arr.size()-1;i++){
            System.out.println("getting current index:"+arr.get(i));
            long smallest = arr.get(i);
            for(int j = i+1; j < arr.size();j++){
                System.out.println("Next element:"+arr.get(j));
                //arr.get(j) < smallest ? smallest = arr.get(j) : arr.get(i);
                if(arr.get(j) < smallest){
                    long temp = smallest;
                    smallest = arr.get(j);
                    arr.set(j,(int)temp);          //conveting to int because list is int
                    
                    arr.set(i,(int)smallest);       //converting to int
                }
            }
        }

        System.out.println("ELemnts of after sort:");
        for(int i = 0; i < arr.size();i++){
            System.out.print(arr.get(i)+"\t");
        }

        //main objective- smallest &  largest summation first 4 of 5
        //smallest of first  4 elements
        long smallest = 0;
        for(int i = 0 ;i < arr.size()-1;i++){
            smallest = smallest + arr.get(i);
        }
        
        long largest = 0;
        for(int i = 1;i < arr.size();i++){
            largest = largest + arr.get(i);
        }

        System.out.println("\n\nSmallest & Largest are :"+smallest+"\t"+largest+" respectively.");
    }

    public static void main(String[] args){
        
        //List<Integer> arr = new ArrayList<>();
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(140638725);
        arr.add(436257910);
        arr.add(953274816);
        arr.add(734065819);        
        arr.add(362748590);

        minmax(arr);
    }   
}