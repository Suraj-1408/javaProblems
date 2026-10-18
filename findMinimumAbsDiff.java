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

public class findMinimumAbsDiff{
    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prev = null;

    public static int getMinimumDiff(TreeNode root){
        minDiff = Integer.MAX_VALUE;       //reset
        prev = null;                    //reset

        inOrder(root);

        return minDiff;
    }

    //inOrder() helper function , computing the actual minDiff
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
    
        //go to extreame left
        inOrder(root.left);

        //now check , if you previous root node exist or not to compute minDiff
        if(prev != null){
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(diff, minDiff);
        }

        //update the prev Node , once found
        prev = root;

        //call for right nodes in the tree
        inOrder(root.right);
    }


    //main
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        int result = getMinimumDiff(root);
        System.out.println("Finding the Minimum Absolute Difference:"+result);
    }
}