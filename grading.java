import java.util.List;
import java.util.ArrayList;
//import java.until.ArrayList;
public class grading{

    // public static int[] grade(int arr[]){
    //     for(int i = 0;i < arr.length;i++){
    //         if(arr[i] % 5 == 0 && arr[i] > 40){
    //             arr[i] = arr[i]+5;
    //         }
    //         else{
    //             float div = (float)(arr[i]/5.0);
    //             System.out.println("Div result:"+div);
    //             //check if division result returns any decimal point
    //             int num = 0;
    //             if(div%1 != 0){
    //                 num = (int)div + 1;
    //                 //System.out.println("Num Value:"+num);
    //             }
                
    //             int nextMul = num*5;
                
    //             if((nextMul - arr[i]) < 3 && arr[i] > 40){
    //             //System.out.println("nextMul:"+nextMul+" current number:"+arr[i]);
    //                 arr[i] = nextMul;
    //             }
    //         }
    //     }
        
    //     return arr;
    // }
        public static List<Integer> grade(List<Integer> grades){
            for(int i = 0;i < grades.size();i++){ 
                int curr = grades.get(i);
                if(curr < 38) continue;
                
                float div = (float)(curr/5.0);
                
                int num;
                //checking if division results any fraction values.
                if(div%1 == 0){
                    num = (int)div;    
                }else{
                    num = (int)div+1;
                }
                
                int nextMul = num*5;
                
                if((nextMul - curr) < 3){
                    grades.set(i,nextMul);
                }
            }
        
        return grades;
    }
    
    public static void main(String[] args){
    
        // int arr[] = {73,67,38,33};
        
        // int[] res = grade(arr);
        List<Integer> arr = new ArrayList<>();
        arr.add(73);
        arr.add(67);
        arr.add(38);
        arr.add(33);
        
        List<Integer> res = grade(arr);
        for(int i = 0;i < res.size();i++){
            System.out.print(res.get(i)+"\t");
            
        }
    }
}