import java.util.List;
import java.util.ArrayList;

public class billDivision{
     public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Write your code here
        int amountExlcudingAnnaItem = 0; 
        for(int i = 0;i < bill.size();i++){
            if(i != k){
                amountExlcudingAnnaItem = amountExlcudingAnnaItem + bill.get(i);
            }
        }
        
        int afterSplit = amountExlcudingAnnaItem/2;
        if( afterSplit != b){
            int totalBrianCharged = amountExlcudingAnnaItem + bill.get(k);
            int difference = (totalBrianCharged/2) - afterSplit;
            System.out.println(difference);
            return;
        }
        
        System.out.println("Bon Appetit");
    }

    //main
    public static void main(String[] args){
        List<Integer> bill = new ArrayList<>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);

        bonAppetit(bill,1,12);
    }
}