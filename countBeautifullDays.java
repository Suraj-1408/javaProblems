//Sample Input - 20(start number) 23(end number) 6(divisor)
//sample output = 2;
// Lily may go to the movies on days 20,21 ,22 , and 23. We perform the following calculations to determine which days are beautiful:

// Day 20 is (|20 - 02(reverse)|/6) beautiful because the following evaluates to a whole number: 3
// Day 21 is (|21 - 12(reverse)|/6) not beautiful because the following doesn't evaluate to a whole number: 
// Day 22 is (|22 - 22(reverse)|/6) beautiful because the following evaluates to a whole number: 
// Day 23 is (|23 - 32(reverse)|/6) not beautiful because the following doesn't evaluate to a whole number: 
// Only two days, 20 and ,22 in this interval are beautiful. Thus, we print 2 as our answer.
import java.lang.StringBuilder;

public class countBeautifullDays
{
    public static int reverse(String i){
        StringBuilder num = new StringBuilder();
        num.append(i);
        
        int s = 0;
        int e = num.length()-1;
        
        while(s < e){
            char first = num.charAt(s);
            num.setCharAt(s,num.charAt(e));
            num.setCharAt(e,first);
            
            s++;
            e--;
        }
        
        return Integer.parseInt(num.toString());
    }
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int dayCount = 0;
        for(int p = i; p <= j;p++){
            String n = p + "";
            int revNum = reverse(n);
            
            int num1 = Math.abs(p - revNum);
            if(num1 % k == 0){
                dayCount++;
            }
        }
        return dayCount;
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int res = beautifulDays(20,23,6);
		System.out.println(res);
	}
}