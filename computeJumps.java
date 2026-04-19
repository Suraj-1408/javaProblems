// You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).

// The first kangaroo starts at location  and moves at a rate of  meters per jump.
// The second kangaroo starts at location  and moves at a rate of  meters per jump.
// You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.

public class computeJumps{

    public static String kangaroo(int x1, int v1, int x2, int v2) {
    // Write your code here
    //objective is to find the no of jumps where both kangaroos meet at same position.
    
    //x1 + v1.n == x2 + v2.n
    //(x1  - x2)/(v2-v1) = n
    //if(n%2 ==0) -> YES else NO
    
    //if same speed and same distance.
    if(v1 == v2){
        if(x1 == x2){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    //int jumps = (x1-x2)/(v2-v1);
    int dx = (x1-x2);
    int dv = (v2-v1);

    //check if they are divisible and non-negative
    if(dx%dv == 0 && dx/dv >= 0){
        return "YES";
    }
    // System.out.println(jumps);
    //     if(jumps%2 != 0){
    //         return "NO";
    //     }
    
    return "YES";
    }

    //main
    public static void main(String[] args){
        
        //String answer = kangaroo(0,2,5,3);
        String answer = kangaroo(0,3,4,2);
        System.out.println("Possibility of Kangaroos meeting at same position: " + answer);
    }
}