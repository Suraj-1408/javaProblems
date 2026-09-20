import java.lang.Math;

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



public class computeDiameterOfBinaryTree
{
    static int diameter = 0;
    
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        diameter = 0;   //resetting diameter for new testcases
        int res = computeHeight(root);
        return diameter;
    }
    
    public static int computeHeight(TreeNode root){
        
        if(root == null){
            return 0;
        }
        //FOR EACH NODE , computing the height left & right subtree height 
        //recursively using dfs(going as deep as possible until dead end is met)
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        
        int localDiameter = leftHeight + rightHeight;
        
        //updating the global diameter if localDiameter is greater(FINAL RESULTANT)
        diameter = Math.max(diameter , localDiameter);
        
        return 1 + Math.max(leftHeight , rightHeight); //this returns height, not Used.
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		int finaldiameter = diameterOfBinaryTree(root);
		System.out.println("Diameter of binary tree:"+finaldiameter);
	}
}
