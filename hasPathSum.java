class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class hasPathSum
{
    static int currSum = 0; 
    public static boolean hasPathSum(Node root, int targetSum){
        currSum = 0;
        return hasPathSumHelper(root,targetSum);
    }
    public static boolean hasPathSumHelper(Node root, int targetSum) {
        // TreeNode currentNode = root;
        
        // if(currentNode == null){
        //     return false;
        // }
        // currSum = currSum + currentNode.data;
        
        // if(currSum == targetSum){
        //     return true;
        // }
        
        // //move to left
        // if((currentNode.left != null && (currSum + currentNode.left.data)) <= targetSum){
        //     hasPathSum(currentNode.left,targetSum);
        // }
        // //move to right
        // else if((currentNode.right != null && (currSum + currentNode.right.data)) <= targetSum){
        //     hasPathSum(currentNode.right,targetSum);
        // }
        // //move to root
        // else{
        //     currentNode = root;
        //     currSum = currentNode.data;
        //     hasPathSum(currentNode.right,targetSum);
        // }
        Node currentNode = root;
        
        if(currentNode == null){
            return false;
        }
        
        currSum = currSum + currentNode.data;
        
        //if currentNode is leafNode
        if(currentNode.left == null && currentNode.right == null && currSum == targetSum){
            return true;
        }
        
        //check the left node.
        boolean left = false;
        if(currentNode.left != null){
            left = hasPathSumHelper(currentNode.left,targetSum);
            currSum = currSum - currentNode.left.data;
        }
        
        //check for right child
        boolean right = false;
        if(currentNode.right != null){
            right = hasPathSumHelper(currentNode.right,targetSum);
            currSum = currSum - currentNode.right.data;
        }
        
        return left || right;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		Node root = new Node(5);
		Node node1 = new Node(4);
		Node node2 =  new Node(8);
		Node node3 = new Node(11);
		Node node4 = new Node(13);
		Node node5 = new Node(4);
		Node node6 = new Node(7);
		Node node7 = new Node(2);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		int targetSum = 22;
		boolean result = hasPathSum(root,targetSum);
		if(result){
		    System.out.println("Given tree has a path matching given sum:"+targetSum);
		}else{
		    System.out.println("Given tree don't have path matching given sum:"+targetSum);
		}
	}
}
