import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class diffInClimbingHighestHurdle
{
    public static int hurdleRace(int k, List<Integer> height){
        //height.sortArray();
        int dosesReq = 0;
        // for(int i = 0 ; i < height.size()-1;i++){
        //     for(int j = i+1; j < height.size();j++){
        //         if(height.get(i) > height.get(j)){
        //             int temp =height.get(i);
        //             height.set(i,height.get(j));
        //             height.set(j,temp);
        //         }
        //     }
        // }
        Collections.sort(height);
        // for(int i = 0; i < height.size();i++){
        //     System.out.print(height.get(i)+"\t");
        // }
        //System.out.println("");
        
        int lastElement = height.get(height.size()-1);
        if(lastElement > k){
            dosesReq = lastElement - k;        
        }
        return dosesReq;
    }
    
	public static void main(String[] args) {
        //System.out.println("Hello World");
        List<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(6);
        arr.add(3);
        arr.add(5);
        arr.add(2);
        System.out.println("Before Sort:");
        for(int i = 0; i < arr.size();i++){
            System.out.print(arr.get(i)+"\t");
        }
        
        int result = hurdleRace(4,arr);
        System.out.println("\nDoses required:"+result);
	}
}
