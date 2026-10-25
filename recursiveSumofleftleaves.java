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

public class recursiveSumofleftleaves{
    //static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        boolean flag = false;

        int res = findSum(root,flag);
        return res;
    }

    public static int findSum(TreeNode root , boolean flag){
        if(root == null){
            return 0;
        }
        
        int currentSum = 0;

        currentSum = currentSum + findSum(root.left, true);

        if(root.left == null && root.right == null && flag == true){
            currentSum = currentSum + root.val;
        }

        currentSum = currentSum + findSum(root.right,false);

        return currentSum;
    }

    //main
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);

        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n2.right = n4;

        int result = sumOfLeftLeaves(root);
        System.out.println("Sum of all left leaf node:"+result);
    }
}