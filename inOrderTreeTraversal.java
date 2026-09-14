import java.util.ArrayList;
import java.util.List;

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

public class inOrderTreeTraversal
{
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        res.clear();
        inorder(root);
        return res;
    }

    //helper method
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        // if(root.left != null){
        //     res.add(root.left.val);
        // }
        
        res.add(root.val);
        
        inorder(root.right);
        // if(root.right != null){
        //     res.add(root.right.val);
        // }
        return;
    }
    
	public static void main(String[] args) {
		System.out.println("\t\t Inorder Traversal");
		List<Integer> res = new ArrayList<>();
		
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		
		root.right = node1;
		node1.left = node2;
		
		res = inorderTraversal(root);
		System.out.println("Node Values in INorder:"+res);
	}
}
