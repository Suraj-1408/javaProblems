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

public class kthSmallestElementInBST{
    static int counter = 0; 
    static int result = 0;
    public static int kthSmallest(TreeNode root, int k) {
        //Core Property of BST = All nodes in bst are always sorted from left to right.
        //i.e all nodes in left subtree are smaller than root node
        // and all nodes in right subtree are greater than root node.

        //approach
        //since we indirectly have to kth node in the bst, but the structure is tree.
        //if root not null, first check  k == root.val
        //if k === root.val is false, 
        //move to left node if k < root.val
        //else move to right node if k > root.val

        if(root == null){
            return -1;
        }

        // if(k == root.val){
        //     result = root;
        //     return result;
        // }
        // else if(k < root.val){
        //     result = kthSmallest(root.left, k);
        // }
        // else{
        //     result = kthSmallest(root.right);
        // }

        //ABOVE SOLUTION IS WRONG AS I AM COMPARING K WITH ROOT VALUE, NOTE K IS RANK POSITION.

        //SIMPLEST APPRAOCH IS USE - IN ORDER TRAVERSAL.
        //THROUGH IN ORDER WE ALWAYS DO LEFT ROOT & RIGHT/
        //THEREFORE FIRST GO TO EXTREAME LEFT NODE, NOW SINCE IT BST , LEFT NODE WILL ALWAYS BE
        //SMALLEST NODE VALUE
        //KEEP INCREMENTING K COUNTER UNTIL KCOUNTER == K
        //WHEN KCOUNTER == K RETURN ROOT.VAL
        
        counter  = k;
        result = 0;

        findKSmallest(root);

        return result;
    }

    public static void findKSmallest(TreeNode root){
        if(root == null){
            return;
        }

        findKSmallest(root.left);
        counter--;

        if(counter == 0){
            result = root.val;
            return;
        }

        if(counter > 0){
            findKSmallest(root.right);
        }
    }

    //main
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        node1.right = node3;
    

        int kSmallest = kthSmallest(root,1);
        System.out.println("Kth smallest in given binary search tree is:"+kSmallest);
    }
}