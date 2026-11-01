import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Collections;
import java.lang.Math;

public class findLongestSubstringAfterKOperation{
    public static int characterReplacement(String s, int k) {
        // HashMap<Character,Integer> frequency = new HashMap<>();

        // StringBuilder str = new StringBuilder(s);
        
        // int count = 1;
        // for(int i = 0; i < str.length();i++){
        //     if(!frequency.containsKey(str.charAt(i))){
        //         frequency.put(str.charAt(i),count);
        //     }

        //     else{
        //         int currentCount = frequency.get(str.charAt(i));
        //         frequency.put(str.charAt(i),currentCount+1);
        //     }
        // }

        // //getting the entry object - key,Value having maximum & minimum frequency value. USING COLLECTION.
        // Map.Entry<Character,Integer> maxEntry = Collections.max(frequency.entrySet(), Map.Entry.comparingByValue());

        // Map.Entry<Character,Integer> minEntry = Collections.min(frequency.entrySet(), Map.Entry.comparingByValue());     //get the entry object both key & value.
        // //here Map.Entry.comparingByValue() - helps us in getting values based on sorting and comparing multiple entries.

        // //now fetching key from entry object having max occurrence.
        // char maxKey = maxEntry.getKey();

        // //also fetching key from entry object havign min occurrence.
        // char minKey = minEntry.getKey();

        // //looping the str and updating the minKey with maxKey
        // for(int i = 0; i < str.length();i++){
        //     if(str.charAt(i) == minKey){
        //         str.setCharAt(i,maxKey);
        //     }
        // }


        // //finding the length of longest substring with repeating character.
        // int maxcount = 0;
        // int left = 0;
        // for(int right = 0; right < str.length();right++){
        //     //only reset the window - when right > 0 && charAt(right Index) != charAt(right - 1 index)
        //     if(right > 0 && str.charAt(right) != str.charAt(right - 1)){
        //         left = right;   //eliminating window left to right , and updating left to right +1
        //     }

        //     maxcount = Math.max(maxcount,right - left +1);
        // } 

        //return maxcount;


        //NEW WORKING APPROACH - ABOVE APPROACH IS NOT AT ALL CORRECT.
        int[] count = new int[26];      //this creates 26 variable with 0 value tracking each letter count.
        int left = 0;   //left pointer.
        int maxcount = 0;   ///track most common count of letter in the window.
        int result = 0;

        for(int right = 0;right < s.length();right++){
            count[s.charAt(right) - 'A']++;     //add right character

            maxcount = Math.max(maxcount, count[s.charAt(right) - 'A']);

            //check whether the window is valid or not.
            int windowSize = right - left + 1;
            if(windowSize - maxcount > k){
                //remove character from left
                count[s.charAt(left) - 'A']--;
                left++;
            } 

            result = Math.max(result , right - left + 1);
        }

        return result;
    }

    //main
    public static void main(String[] args){
        String str = "ABAB";

        int count = characterReplacement(str,2);
        System.out.println("Maximum length of longest substring after K operations:"+count);
    }
}