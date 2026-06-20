// A child is playing a cloud hopping game. In this game, there are sequentially numbered clouds that can be thunderheads or cumulus clouds. The character must jump from cloud to cloud until it reaches the start again.

// There is an array of clouds,c and an energy level e = 100 . The character starts from c[0] and uses 1 unit of energy to make a jump of size k to cloud c[(i+k)%n]. If it lands on a thundercloud, c[i]  = 1, its energy (e) decreases by 2 additional units. The game ends when the character lands back on cloud 0.

// Given the values of n, k and the configuration of the clouds as an array , determine the final value e of  after the game ends.

//Example c = [0,0,1,0]; k = 2;
// The indices of the path are 0 -> 2 -> 0. The energy level reduces by 1 for each jump to 98. The character landed on one thunderhead at an additional cost of 2 energy units. The final energy level is 96.
import java.util.HashSet;
public class jumpingOnClouds
{
    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c, int k) {
        HashSet<Integer> visited = new HashSet();
        int index = 0;
        int e = 100;        
        while(!visited.contains(index)){
            visited.add(index);
            
            index = (index + k)%c.length;
            if(c[index] == 1){
                e = e - 1 - 2;
            }else{
                e = e - 1;
            }
        }
        return e;
        
    }
    
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        int[] arr = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        
        int energy = jumpingOnClouds(arr,k);
        System.out.println("Energy value:"+energy);
	}
}
