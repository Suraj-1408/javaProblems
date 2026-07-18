import java.math.BigInteger;

public class extraLargeFactorial
{
    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger res = new BigInteger("1");
        
        BigInteger num = BigInteger.valueOf(n);
        while(!num.equals(BigInteger.ONE)){
            res = res.multiply(num);
            num = num.subtract(BigInteger.ONE);
        }
        System.out.println(res);
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int n = 25;
		System.out.print("Factorial of given number "+n+" is:");
		extraLongFactorials(n);
	}
}
