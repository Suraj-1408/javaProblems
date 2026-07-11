
public class findingMinimumCostToBuyBlackAndWhiteGifts
{
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long B = (long)b;
        long W = (long)w;
        long BC = (long)bc;
        long WC = (long)wc;
        long Z = (long)z;
        
        long minCost = 0;
        if(BC > (WC+Z)){
            long totalbuy = (W*WC) + (B*WC);
            long conversionCost = B * Z;
            minCost = (totalbuy + conversionCost);
        }
        else if(WC > (BC+Z)){
            long totalbuy = (B*BC) + (W*BC);
            long conversionCost = W * Z;
            minCost = (totalbuy + conversionCost);
        }
        else{
            minCost = (B*BC)+(W*WC);
        }
        
        return minCost;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		long cost = taumBday(10,10,1,1,1);
		System.out.println("Minimum Cost:"+cost);
	}
}
