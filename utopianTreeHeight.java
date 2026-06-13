// The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer,
//its height increases by 1 meter. A Utopian Tree sapling with a height of 1 meter is planted at the onset of spring. 
//How tall will the tree be after nth growth cycles?

//input - int n: the number of growth cycles to simulate
//output - int: the height of the tree after the given number of cycles
//Input - 3 : 0,1,4
//Output - 1,2,7

//explaination -
// There are 3 test cases.

// In the first case (n=0), the initial height (H=1) of the tree remains unchanged.

// In the second case (n=1), the tree doubles in height and is 2 meters tall after the spring cycle.

// In the third case (n=4), the tree doubles its height in spring (n=1,H=2), then grows a meter in summer (n=2,H=3), 
// then doubles after the next spring (n=3,H=6), and grows another meter after summer (n=4,H=7). Thus, at the end of 4 cycles, 
// its height is 7 meters.

public class utopianTreeHeight
{   
    public static int utopianTree(int n) {
        // Write your code here
        int treeHeight = 1;
        
        if(n == 0){
            return treeHeight;
        }
        
        for(int i = 1; i <= n;i++){ 
            if((i%2 != 0)){
                treeHeight = treeHeight*2;
            }else{
                treeHeight = treeHeight + 1;
            }
        }
        return treeHeight;
    }
    
	public static void main(String[] args) {
		System.out.println("Height of Utopian Tree");
	    int n = 3;
	    int H = utopianTree(n);
	    System.out.println("Height of Utopian tree after "+n+" cycles is:"+H);
	}
}
