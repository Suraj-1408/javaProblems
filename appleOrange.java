import  java.util.List;
import java.util.ArrayList;
public class appleOrange{

    //compute apple & orange count falled in sam's house
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        //1) compute actual distance of fruits falled on x-axis by adding a & b respectively.
        //2) iterate the apple and oranges array havign actual distance where fruits falled.
        //3) while iterating for distance check whethere it lies in range of s & t - 
        
        int apCount = 0;
        for(int i = 0; i < apples.size();i++){
            apples.set(i,apples.get(i)+a);
            
            int actualDis = apples.get(i);
            
            if(actualDis >= s && actualDis <= t){
                apCount++;
            }
        }
        
        int orgCount = 0;
        for(int j = 0; j < oranges.size();j++){
            oranges.set(j,oranges.get(j)+b);
            
            int actualDis = oranges.get(j);
            
            if(actualDis >= s && actualDis <= t){
                orgCount++;
            }
        }
        
        //System.out.println("Apple falled in Sam's House:"+apCount+" Oranges is:"+orgCount);
    
        System.out.println(apCount+"\n"+orgCount);
    }

    //main method
    public static void main(String[] args){
        List<Integer> app = new ArrayList<>();
        app.add(-2);
        app.add(2);
        app.add(1);
        
        List<Integer> org = new ArrayList<>();
        org.add(5);
        org.add(-6);
        
        countApplesAndOranges(7,11,5,15,app,org);
        
    }
}