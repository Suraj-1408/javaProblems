
public class findTotalChocalatesCount
{
    public static int chocolateFeast(int n, int c, int m) {
        // Write your code here
        int ccount = n/c;   
        int wrapperCount = ccount;
        
        while(wrapperCount >= m){
            ccount = ccount + (wrapperCount/m);
            wrapperCount = (wrapperCount%m) + (wrapperCount/m);
            if(wrapperCount < m){
                break;
            }
        }
        return ccount;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int result = chocolateFeast(6, 2, 2);
		System.out.println("Total chocolates eat:"+result);
	}
}
