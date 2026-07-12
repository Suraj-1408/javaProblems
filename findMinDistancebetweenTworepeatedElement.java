import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class findMinDistancebetweenTworepeatedElement
{
    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        int minimum = -1;
        HashMap<Integer,List<Integer>> mymap = new HashMap();
    
        for(int i = 0; i < a.size();i++){
            
            if(!mymap.containsKey(a.get(i))){
                List<Integer> indexes = new ArrayList();
                indexes.add(i);    
                mymap.put(a.get(i),indexes);
            }
            else{
                List<Integer> prevListValue = mymap.get(a.get(i));
                prevListValue.add(i);
                mymap.put(a.get(i),prevListValue);
            }
        }
        
        //loop the hashMap using entrySet();
        for(Map.Entry<Integer,List<Integer>> allias : mymap.entrySet()){
            int k = allias.getKey();
            int v = allias.getValue().size();
            System.out.println("Key:"+k+" Value:"+allias.getValue());
            if(v > 1){
                int dif = allias.getValue().get(v-1) - allias.getValue().get(0);
                System.out.println("Difference Generated:"+dif);
                if(minimum == -1 || dif < minimum){
                    minimum = dif;
                }
            }
        }
        
        return minimum;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		List<Integer> ar = new ArrayList();
// 		ar.add(3);
// 		ar.add(2);
// 		ar.add(1);
// 		ar.add(2);
// 		ar.add(3);
        ar.add(7);
		ar.add(1);
		ar.add(3);
		ar.add(4);
		ar.add(1);
		ar.add(7);
		
		int result = minimumDistances(ar);
		System.out.println("Minimum Distance:"+result);
	}
}
