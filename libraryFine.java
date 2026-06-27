import java.lang.Math;

public class libraryFine
{
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        
        if(y1 > y2){
            return 10000;
        }
        
        if(y1 == y2 && m1 == m2 && d1 > d2){
            int diff = Math.abs(d1-d2);
            return 15*diff;
        }
        
        if(y1 == y2 && m1 > m2){
            int diff = Math.abs(m1-m2);
            return 500*diff;
        }
        
        return 0;
    }
	public static void main(String[] args) {
	//	System.out.println("Hello World");
	    //int fine = libraryFine(14,7,2018,5,7,2018);
	    int fine = libraryFine(9,6,2015,6,6,2015);
	    System.out.println("FIne:"+fine);
	}
}
