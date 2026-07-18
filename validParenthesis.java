import java.util.Stack;

public class validParenthesis
{
    public static boolean isValid(String str) {
        
        StringBuilder s = new StringBuilder(str);
        if(str.length() == 1 || (str.charAt(0) == ')' || 
                str.charAt(0) == '}' || str.charAt(0) == ']')){
            return false;
        }
        
        Stack<Character> stk = new Stack();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(s.charAt(i));
            }
            else{
                if(!stk.empty()){
                    Character top = stk.peek();
                    
                    if((top == '(' && s.charAt(i) != ')') || (top == '{' && s.charAt(i) != '}') ||
                        (top == '[' && s.charAt(i) != ']')){
                        return false;
                    }
                    
                    stk.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        return stk.empty();
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
        boolean res = isValid("[])");
        System.out.println("Result:"+res);
	}
}
