import java.util.*;

public class wordCount{
    public static int countWord(String s){
        // String st = "Ca";

        // if(Character.isUpperCase(st.charAt(0))){
        //     System.out.println("Yes!");
        //     return 1;
        // }

        // return 0;
       
        if(s.isEmpty()){
            return 0;
        }
        
        int count = 1;
        for(int i = 0;i < s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String st = "saveChangesInTheEditor";
        int res = countWord(st);

        System.out.println("Result:"+res);
    }
}