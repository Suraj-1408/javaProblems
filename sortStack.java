import java.util.Stack;

public class sortStack{
    
    public static Stack<Integer> sortingStack(Stack<Integer> stack){
        //creating a temp stack
        Stack<Integer> tempStack = new Stack<>();

        while(!stack.isEmpty()){
            int top1 = stack.pop();

            // if(tempStack.isEmpty()){
            //     tempStack.push(top1);
            // }

            //now traver the tempstack and campare is top until smallest is not placed.
            //int top2 = tempStack.peek();
            while(!tempStack.isEmpty() && tempStack.peek() < top1){             //note - here smallest is at top by using - (tempStack.peek() < current)
                int val = tempStack.pop();
                stack.push(val);
            }    
            tempStack.push(top1);   //push the smallest element in temp stack
        }

        //System.out.println(tempStack);
        return tempStack;
    }

    public static void main(String[] args){
        Stack<Integer> stk = new Stack<>();
        
        stk.push(3);
        stk.push(2);
        stk.push(1);
        System.out.println("Top before:"+stk.peek());
        System.out.println(stk);
        Stack<Integer> result = sortingStack(stk);
        System.out.println(result);
        System.out.println("TOp After:"+result.peek());
    }   
}