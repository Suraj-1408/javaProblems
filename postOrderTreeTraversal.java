import java.util.List;
import java.util.ArrayList;

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

public class postOrderTreeTraversal
{
    static List<Integer> res = new ArrayList<>();
    
    public static List<Integer> postorderTraversal(TreeNode root) {
        res.clear();        //for new testcase resetting the previous res declared.
        if(root == null){
            return res;
        }
        
        postOrder(root);
        
        return res;
    }
    
    
    public static void postOrder(TreeNode root){
    
        if(root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2  = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node4.left = node5;
		node4.right = node6;
		
		node2.right = node7;
		node7.left = node8;
		
		List<Integer> res = postorderTraversal(root);
		System.out.println("Nodes in Post Order:"+res);
		
	}
}
