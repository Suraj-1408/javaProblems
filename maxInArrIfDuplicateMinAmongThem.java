// Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

// Example
//Arr = [1,1,2,2,3];
//return = 1
// There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type .
import java.util.*;

public class maxInArrIfDuplicateMinAmongThem
{
	public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    HashMap<Integer,Integer> eleCount  = new HashMap<>();
    
    int count = 0;
    for(int i = 0 ;i < arr.size();i++){
        if(!eleCount.containsKey(arr.get(i))){
            count++;
            eleCount.put(arr.get(i),count);
            count = 0;          
        } 
        
        else{
            int curCount = eleCount.get(arr.get(i));
            eleCount.put(arr.get(i),curCount+1);
        }
    }
    int minKey  = 0;
    int maxvalue = 0;
    for(Map.Entry<Integer,Integer> k: eleCount.entrySet()){
        if(k.getValue() > maxvalue){
            minKey = k.getKey();
            maxvalue = k.getValue();
        }
        
        else if(k.getValue() == maxvalue){
            //update max to set the minimum key.
            //compare two keys.
            if(k.getKey() < minKey){
                minKey = k.getKey();
            }
        }
    }
    
    return minKey;
    }
    
    
	
	public static void main(String[] args) {
	 ArrayList<Integer> arr = new ArrayList<>();
	 
// 	 arr.add(1);
// 	 arr.add(1);
// 	 arr.add(2);
// 	 arr.add(2);
// 	 arr.add(3);
	 arr.add(1);
	 arr.add(4);
	 arr.add(4);
	 arr.add(4);
	 arr.add(5);
	 arr.add(3);
	 
	 int minKey = migratoryBirds(arr);
    System.out.println("Minimum key:"+minKey);
	}
}
