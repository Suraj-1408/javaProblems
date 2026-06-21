import java.lang.StringBuilder;

public class findTotalDivisors
{
    public static int findDigits(int n) {
        // Write your code here
        StringBuilder num = new StringBuilder();
        num.append(n);
        int divisorCount = 0;
        for(int i = 0;i < num.length();i++){
            int digit = Character.getNumericValue(num.charAt(i));
            
            if(digit != 0 && (n % digit) == 0){
                divisorCount = divisorCount + 1;
            }
        }
        return divisorCount;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int totalDivisors = findDigits(1012);
		System.out.println(totalDivisors);
	}
}
