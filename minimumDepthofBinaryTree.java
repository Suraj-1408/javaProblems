import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    //Initialization
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class minimumDepthofBinaryTree
{
    public static int minDepth(TreeNode root) {
        int shortestPath = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> shortestLen = new Stack<>();
        
        if(root != null){
            nodes.push(root);
            shortestLen.push(1);
        }
        
        
        //travesing the binary tree until stack doesn't get empty
        while(!nodes.isEmpty()){
            TreeNode current = nodes.pop();
            int len = shortestLen.pop();
            
            //check if curr node is leaf node.
            if(current.left == null && current.right == null){
                //check if its the first shortest Path
                if(shortestPath == 0){
                    shortestPath = len;
                }
                else{
                    shortestPath = (len < shortestPath) ? len : shortestPath;
                }
            }
            
            //if left exist - insert node into stack with +1 node count;
            if(current.left != null){
                nodes.push(current.left);
                shortestLen.push(len+1);
            }
            
            if(current.right != null){
                nodes.push(current.right);
                shortestLen.push(len+1);
            }
        }
        return shortestPath;
    }
    
	public static void main(String[] args) {
		
// 		TreeNode root = new TreeNode(3);
// 		TreeNode node1 = new TreeNode(9);
// 	    TreeNode node2 = new TreeNode(20);
// 	    TreeNode node3 = new TreeNode(15);
// 	    TreeNode node4 = new TreeNode(7);
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(3);
	    TreeNode node2 = new TreeNode(4);
	    TreeNode node3 = new TreeNode(5);
	    TreeNode node4 = new TreeNode(6);
	    
	   // root.left = node1;
	   // root.right = node2;
	   // node2.left = node3;
	   // node2.right = node4;
	   root.right = node1;
	   node1.right = node2;
	   node2.right = node3;
	   node3.right = node4;
	    
	    int res = minDepth(root);
	    System.out.println("Shortest Path in binary tree is:"+res);
	}
}
