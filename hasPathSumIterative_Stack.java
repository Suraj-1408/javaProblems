import java.util.Stack;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class hasPathSumIterative_Stack
{
    public static boolean hasPathSum(TreeNode root, int targetSum) {
    
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> currSum = new Stack<>();
        
        stk.push(root);
        currSum.push(root.val);
        
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            int sum = currSum.pop();
            
            
            //check if node is leaf node.
            if(node.left == null && node.right == null && sum == targetSum){
                return true;
            }
            
            //check if left node exist-
            if(node.left != null){
                stk.push(node.left);
                currSum.push(sum + node.left.val);
            }
            
            //check if right node exist-
            if(node.right != null){
                stk.push(node.right);
                currSum.push(sum + node.right.val);
            }
        }
        return false;
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        
        int targetSum = 22;
        boolean res = hasPathSum(root,targetSum);
        
        if(res){
            System.out.println("Path Exist to match the given sum:"+targetSum);
        }else{
            System.out.println("Path doesn't exist to match the given sum:"+targetSum);
        }
	}
}
