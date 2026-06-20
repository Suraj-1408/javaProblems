// Example
// s = "abcac";
// n = 10;
// The substring we consider is abcacabcac, the first 10 characters of the infinite string. There are  4 occurrences of a in the substring.
// Return 4
import java.lang.StringBuilder;

public class infiniterepeatedSubstring
{
    public static long repeatedString(String s, long n) {
        // Write your code here
        // int strlen = s.length();
        // StringBuilder finalStr = new StringBuilder();
        // finalStr = finalStr.append(s);
        // long remLen = n - finalStr.length();
        // while(remLen <= n){
        //     if(remLen < strlen){
        //         finalStr = finalStr.append(s.substring(0,(int)remLen));
        //         break;
        //     }
            
        //     finalStr = finalStr.append(s);
        //     remLen = n - finalStr.length();
        // }
        
        // long frequencyCount = 0;
        // for(int i = 0 ;i < finalStr.length();i++){
        //     if(finalStr.charAt(i) == 'a'){
        //         frequencyCount = frequencyCount + 1;
        //     }
        // }
        // return frequencyCount;
        
        
        //APPROACH 2;
        long aCount = 0;
        for(int i  = 0;i < s.length();i++){
            if(s.charAt(i) == 'a'){
                aCount = aCount + 1;
            }
        }
        
        long totalCount = 0;
        long remainder =  n % s.length();
        long res = n/s.length();
        if(remainder == 0){
            totalCount = aCount * res; 
        }
        else if(remainder != 0){
            long remCount  = 0;
            for(int i = 0;i < (int)remainder;i++){
                if(s.charAt(i) == 'a'){
                    remCount = remCount + 1;
                }
            }
            totalCount = (aCount * res) + remCount; 
        }
        return totalCount;
    }
	public static void main(String[] args){
        	String s = "a";
        	long n = 1000000000000L;
        	long res = repeatedString(s,n);
        	System.out.println("Total count of Character a in given n length is:"+res);
	}
}