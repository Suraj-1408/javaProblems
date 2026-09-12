import java.util.Queue;
import java.util.LinkedList;

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

public class invertingBinaryTree
{
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        //TreeNode currentNode = root;
        //System.out.print(currentNode.val+"\t");
        
        //if(currentNode.left != null && currentNode.right != null){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //}
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    public static void printBinaryTreeLevelWise(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();        //getting first come node.
            System.out.print(current.val);
            
            if(current.left != null){
                queue.add(current.left);
            }
            
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
    
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(9);
		
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right  = node6;
		
		TreeNode res = invertTree(root);
		
		printBinaryTreeLevelWise(res);
	}
}
