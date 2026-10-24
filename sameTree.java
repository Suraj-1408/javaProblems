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


public class sameTree{
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        //if both same.
        if(p == null && q == null){
            return true;
        }

        //if any of them is null.
        if(p == null || q == null){
            return false;
        }

        //following preorder - root, left , right
        if((p.val != q.val) || (p.left != null && q.left == null) || (p.left == null && q.left !=     null) || (p.right !=  null && q.right == null) || (p.right == null && q.right != null)){
            //isSame = false;
            return false;
        }

        //traverse left subtree
        boolean leftSubtree = isSameTree(p.left , q.left);
        //traverse right subtree
        boolean rightSubtree = isSameTree(p.right , q.right);

        return leftSubtree && rightSubtree;
    }

    //main
    public static void main(String[] args){
        //making two trees
        TreeNode root1 = new TreeNode(1);
        TreeNode bnode1 = new TreeNode(2);
        TreeNode bnode2 = new TreeNode(1);

        root1.left = bnode1;
        root1.right = bnode2;

        //tree2
        TreeNode root2 = new TreeNode(1);
        TreeNode anode1 = new TreeNode(1);
        TreeNode anode2 = new TreeNode(2);

        root2.left = anode1;
        root2.right = anode2;

        boolean result = isSameTree(root1 , root2);
        System.out.println("Are two tree same? "+ result);
    }
}