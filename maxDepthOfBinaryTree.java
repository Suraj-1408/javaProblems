import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class maxDepthOfBinaryTree{
    public static int maxDepth(TreeNode root) {
        //using stack data structure to find max depth of binary.
        //approach
        //creating a stack to maintain the node being processed.
        //creating another stack to maintain the len of each corresponding node inserted in first stack.
        //iterate until the nodes in stack doesn't get empty.
        //while iterating, check whether currentNode has left or right child.
        //let say currentNode left & right child is null , i.e currentNode is leafnode?
        //if currentNode is leafNode - update the maxlen by comparing its length with node length being popped out.
        //as soon as stack node get empty return - maxlen
        
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> pathLength = new Stack<>();
        
        int maxlen = 0;
        nodes.push(root);   //pushing first node into nodes stack.
        pathLength.push(1); //pushing node length into pathLength stack.
        
        while(!nodes.isEmpty()){
            TreeNode currentNode = nodes.pop();
            int currLen = pathLength.pop();
            
            //check if currentNode is leafNode
            if(currentNode.left == null || currentNode.right == null){
                //handling case if its first node.
                if(maxlen == 0){
                    maxlen = currLen;
                }
                else{
                    maxlen = (currLen > maxlen) ? currLen : maxlen;
                }
            }
            
            
            //check if left node exist. push into node & its length into stack
            if(currentNode.left != null){
                nodes.push(currentNode.left);
                pathLength.push(currLen+1);
            }
            
            //check if right node exist. push into node and its length into respective stack.
            if(currentNode.right != null){
                nodes.push(currentNode.right);
                pathLength.push(currLen+1);
            }
        }
        
        return maxlen;
    }
    
    //main
    public static void main(String[] args){
    
//         TreeNode root = new TreeNode(3);
// 		TreeNode node1 = new TreeNode(9);
// 	    TreeNode node2 = new TreeNode(20);
// 	    TreeNode node3 = new TreeNode(15);
// 	    TreeNode node4 = new TreeNode(7);  
        TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
	   // TreeNode node2 = new TreeNode(20);
	   // TreeNode node3 = new TreeNode(15);
	   // TreeNode node4 = new TreeNode(7);  
	    
//	    root.left = node1;
	    root.right = node1;
	   // node2.left = node3;
	   // node2.right = node4;
	    
	    int maxlen = maxDepth(root);
	    System.out.println("Maximum Depth of Binary tree is:"+maxlen);
    }
}

