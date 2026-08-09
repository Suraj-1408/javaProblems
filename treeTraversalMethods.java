class Node{
    int data;
    Node left;
    Node right;
    
    //intialize the Object
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }    
}
public class treeTraversalMethods
{
    static boolean nodeExist = true;
    public static void preOrderTreeTraversal(Node root){
        if(root == null){
            return;
        }
        
        if(!nodeExist){
            System.out.print("->");
        }
        //root->left->right;
        Node currentNode = root;
        System.out.print(currentNode.data);
        nodeExist = false;
        // if(currentNode.left != null){
        //     System.out.print(currentNode.data+"->");     //print parent node
        // }
        // else if(currentNode.left == null || currentNode.right == null){
        //     System.out.print(currentNode.data+"->");
        // }
        
        preOrderTreeTraversal(currentNode.left);
        preOrderTreeTraversal(currentNode.right);
    }
    
    
    //INORDER traversal
    static boolean nodeExist1 = true;
    public static void inOrderTraversal(Node root){
        //left -> root -> right
        if(root == null){
            return;
        }
        
        inOrderTraversal(root.left);
        if(!nodeExist1){
            System.out.print("->");
        }
        System.out.print(root.data);
        nodeExist1 = false;
        inOrderTraversal(root.right);
    }
    
    //POST traversal
    static boolean nodeExist2 = true;
    public static void postOrderTraversal(Node root){
        //left -> root -> right
        if(root == null){
            return;
        }
        
        postOrderTraversal(root.left);
        
        postOrderTraversal(root.right);
        if(!nodeExist2){
            System.out.print("->");
        }
        System.out.print(root.data);
        nodeExist2 = false;
    }
    
	public static void main(String[] args) {
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		
		root.left = node1;
		root.right = node2;
		
		System.out.println("Pre Order traversal");
		preOrderTreeTraversal(root);
		
		System.out.println("\nIn Order traversal");
		inOrderTraversal(root);

        System.out.println("\nPost Order traversal");
		postOrderTraversal(root);

	}
}
