import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class equalizeArray
{
    public static int findMinCountToDeleteToEqualizeTheArray(List<Integer> arr) {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap();
        
        int count = 1;
        for(int i = 0;i < arr.size();i++){
            if(!map.containsKey(arr.get(i))){
                map.put(arr.get(i),count);
            }    
            else{
                int currCount = map.get(arr.get(i));
                map.put(arr.get(i),currCount+1);
            }
        }
        
        int maxValue = 0;
        for(Map.Entry<Integer,Integer> allias : map.entrySet()){
            if(allias.getValue() > maxValue){
                maxValue = allias.getValue();
            }
        }
        
        return arr.size() - maxValue;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		List<Integer> arr = new ArrayList();
// 		arr.add(1);
// 		arr.add(2);
// 		arr.add(2);
// 		arr.add(3);
        arr.add(3);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		
		int minDeleteCount = findMinCountToDeleteToEqualizeTheArray(arr);
		System.out.println("Minimum elements to delete:"+minDeleteCount);
	}
}
