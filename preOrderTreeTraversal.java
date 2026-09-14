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

public class preOrderTreeTraversal
{
    static List<Integer> res = new ArrayList<>();
    
    public static List<Integer> preorderTraversal(TreeNode root) {
        res.clear();
        preOrder(root);

        return res;
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    
	public static void main(String[] args) {
		System.out.println("\t\t Pre Order");
		
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		
		root.right = node1;
		node1.left = node2;
		
		List<Integer> res = preorderTraversal(root);
		System.out.println("Node Values in Pre Order:"+res);
		
	}
}
