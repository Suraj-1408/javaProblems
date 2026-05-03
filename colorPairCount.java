import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class colorPairCount
{
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int pairCount = 0;
        for(int i = 0 ; i < ar.size();i++){
            
            if(!map.containsKey(ar.get(i))){
                map.put(ar.get(i),ar.get(i));
            }
            else if(map.containsKey(ar.get(i))){
                pairCount++;
                int getKey = map.get(ar.get(i));        // as key & value same, 
                map.remove(getKey);
            }
        }
        return pairCount;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> ar = new ArrayList<>();
		//10 20 20 10 10 30 50 10 20
		ar.add(10);
		ar.add(20);
		ar.add(20);
		ar.add(10);
		ar.add(10);
		ar.add(30);
		ar.add(50);
		ar.add(10);
		ar.add(20);
		
		int totalPairCount = sockMerchant(ar.size(),ar);
		System.out.println(totalPairCount);
	}
}
