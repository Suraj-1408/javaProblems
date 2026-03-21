import java.util.*;

public class password{

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        HashSet<Integer> num = new HashSet<>();
        for(int i = 0; i < numbers.length();i++){
            int nms = numbers.charAt(i) - '0';
            num.add(nms);
        }
        
        
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        HashSet<Character> lower = new HashSet<>();
        for(int i = 0; i < lower_case.length();i++){
            lower.add(lower_case.charAt(i));
        }
        
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashSet<Character> upper = new HashSet<>();
        for(int i = 0; i < upper_case.length();i++){
            upper.add(upper_case.charAt(i));
        }
        
        String special_case = "!@#$%^&*()-+";
        HashSet<Character> special = new HashSet<>();
        for(int i = 0; i < special_case.length();i++){
            special.add(special_case.charAt(i));
        }
        
        int count = 0;
        boolean hasNum = false;
        for(int ch : num){
            char nm = (char)(ch + '0');
            if(password.indexOf(nm) != -1){
                hasNum = true;
                break;
            }
        }
        
        if(!hasNum){
            count++;
        }
        
        boolean hasLower = false;
        for(char ch : lower){
            if(password.indexOf(ch) != -1){
                hasLower = true;
                break;
            }
        }
        if(!hasLower){
            count++;
        }
        
        boolean hasUpper = false;
        for(char ch : upper){
            if(password.indexOf(ch) != -1){
                hasUpper = true;
                break;
            }
        }
        if(!hasUpper){
            count++;
        }
        
        boolean hasSpecial = false;
        for(char ch : special){
            if(password.indexOf(ch) != -1){
                hasSpecial = true;
                break;
            }
        }
        if(!hasSpecial){
            count++;
        }
        
        //return count;
        return Math.max(count, 6 - n);
    }

    public static void main(){
        String st = "Ab1";
        int res = minimumNumber(st.length(), st);
        System.out.println(res);
    }
}