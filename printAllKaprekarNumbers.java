import java.lang.Math;

public class printAllKaprekarNumbers
{
    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        int count = 0;
        while(p <= q){
            long num = p;
            long square = num*num;
            int len = String.valueOf(num).length();
            StringBuilder str = new StringBuilder();
            str.append(square);
            
            String rightStr = str.substring(str.length()-len,str.length());
            long rightHalf = Long.parseLong(rightStr);
            
            String leftStr = str.substring(0,str.length()-len);
            long leftHalf = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
            
            if((rightHalf+leftHalf) == num){
                count++;
                System.out.print(num+" ");
            }
            p++;
        }
        
        if(count == 0){
            System.out.println("INVALID RANGE");
        }
    }
    
	public static void main(String[] args) {
		kaprekarNumbers(1,99999);
	}
}
