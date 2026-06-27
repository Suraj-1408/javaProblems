import java.util.ArrayList;
import java.util.List;
public class findMinimumJumpToReachLastCloud
{
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int jumpCount = 0;
        int currentStep = 0;
        
        while(currentStep < c.size()-1){
            if(currentStep + 2 < c.size()  && c.get(currentStep+2) == 0){
                currentStep = currentStep + 2;
                jumpCount = jumpCount + 1;
            }
            else{
                currentStep = currentStep + 1;
                jumpCount = jumpCount + 1;
            }
        }
        return jumpCount;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> arr = new ArrayList();
// 		arr.add(0);
// 		arr.add(1);
// 		arr.add(0);
// 		arr.add(0);
// 		arr.add(0);
// 		arr.add(1);
// 	    arr.add(0);
        arr.add(0);
		arr.add(0);
		arr.add(0);
		arr.add(0);
		arr.add(1);
		arr.add(0);
	    //arr.add(0);
		int totalCount = jumpingOnClouds(arr);
		System.out.println("Minimum Jumps required:"+totalCount);
	}
}
