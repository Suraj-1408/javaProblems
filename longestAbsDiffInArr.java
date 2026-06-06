// Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to 1.
// 6
// 4 6 5 3 3 1

// We choose the following multiset of integers from the array:{4,3,3} . Each pair in the multiset has an absolute difference <=1 (i.e.|4-3| = 1,  and |3-3| = 0 ), so we print the number of chosen integers, 3, as our answer.
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public static int longestAbsDiffInArr(List<Integer> a) {
    // Write your code here
    //APPROACH 1 - USING SUBARRAY COUNT.
    // int count = 0;
    // int maxsubArrlen = 0;
    // for(int i = 0; i < a.size();i++){
    //     for(int j = i+1;j < a.size();j++){
    //         //checking the absolute difference.
    //         if((a.get(j) - a.get(i)) <= 1){
    //             count = (j - i) + 1;
    //         }else{
    //             break;
    //         }
    //     }
        
    //     //now also update maximum subarray length
    //     if(count > maxsubArrlen){
    //         maxsubArrlen = count;
    //     }
    // }
    // return maxsubArrlen;
    
    
    //HASHMAP
    HashMap<Integer,Integer> freqCount = new HashMap();
    
    for(int i = 0 ;i < a.size();i++){
        if(!freqCount.containsKey(a.get(i))){
            freqCount.put(a.get(i),1);
        }else{
            int currentCount = freqCount.get(a.get(i));
            currentCount++;
            freqCount.put(a.get(i),currentCount);
        }
    }
    
    //printing HASHMAP
    for(Map.Entry<Integer,Integer> item : freqCount.entrySet()){
        System.out.println("Key:"+item.getKey()+" Value:"+item.getValue());
    }
    
    //store distinct
    // List<Integer> unique = new ArrayList();
    // for(Map.Entry<Integer,Integer> item : freqCount.entrySet()){
    //     unique.add(item.getKey());
    // }
    
    //int currCnt = 0;
    int maxlen = 0;
    // for(int i = 0; i < unique.size()-1;i++){
    //     //System.out.println(unique.get(i));
    //     for(int j = i+1 ; j < unique.size();j++){

    //         if(Math.abs(unique.get(j) - unique.get(i)) <= 1){
    //             int ifreq = freqCount.get(unique.get(i));
    //             int jfreq = freqCount.get(unique.get(j));    
    //             currCnt = ifreq + jfreq;
    //         }
    //     }
        
    //     if(currCnt > maxlen){
    //         maxlen = currCnt;
    //     }
    // }
    for(int num : freqCount.keySet()){
        //int len = freqCount.get(num) + freqCount.getOrDefault(num+1,0); 
        int nextFreq = freqCount.containsKey(num + 1)
                ? freqCount.get(num + 1)
                : 0;

        int len = freqCount.get(num) + nextFreq; 
        maxlen = Math.max(maxlen,len);
    }
    
    return maxlen;
}

//main
public static void main(String[] args){
    List<Integer> arr = new ArrayList();
    // arr.add(1);
    // arr.add(1);
    // arr.add(2);
    // arr.add(2);
    // arr.add(4);
    // arr.add(4);
    // arr.add(5);
    // arr.add(5);
    // arr.add(5);
    //test2
    arr.add(4);
    arr.add(6);
    arr.add(5);
    arr.add(3);
    arr.add(3);
    arr.add(1);
    
    //test3
    // arr.add(1);
    // arr.add(2);
    // arr.add(2);
    // arr.add(3);
    // arr.add(1);
    // arr.add(2);
    
    int maxSubArrayLength = longestAbsDiffInArr(arr);
    System.out.println("Longest Subarray Length:"+maxSubArrayLength);
    
}