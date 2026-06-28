import java.util.List;
import java.util.ArrayList;

public class cutAllTheSticksWithMinLen
{
    public static int findMin(List<Integer> arr){
        int min = arr.get(0);
        for(int i = 1; i < arr.size();i++){
            if(arr.get(i) < min && arr.get(i) != 0){
                min = arr.get(i);
            }
        }
        return min;
    }
    
    public static List<Integer> updatedArr(int min,List<Integer> arr){
        //System.out.println("Size of Arr:"+arr.size());
        for(int i = 0; i < arr.size();i++){
            if(arr.get(i) == 0){
                arr.remove(i);
                i--;
            }
            
            else if(arr.get(i) > 0){
                int remaining = arr.get(i) - min;
                if(remaining <= 0){
                    arr.remove(i);
                    i--;
                }
                else{
                    arr.set(i,remaining);
                }
            }
        }   
        return arr;
    }
    
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList();
        
        while(arr.size() >= 1){
            res.add(arr.size());
            int min = findMin(arr);
            arr = updatedArr(min,arr);
        }
        return res;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> arr = new ArrayList();
// 		arr.add(1);
// 		arr.add(2);
// 		arr.add(3);
        arr.add(5);
		arr.add(4);
		arr.add(4);
        arr.add(2);
		arr.add(2);
		arr.add(8);		
		List<Integer> res = new ArrayList();
		res = cutTheSticks(arr);
		System.out.println("Sticks traversed on each Iteration:"+res);
	}
}
