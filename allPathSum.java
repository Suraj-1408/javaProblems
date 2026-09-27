
import java.lang.StringBuilder;

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

public class allPathSum{
    static int finalSum = 0;
    static StringBuilder currentNum = new StringBuilder();
    public static int findAllPathSums(TreeNode root){
        finalSum  = 0;  //reset for new testcase
        currentNum.setLength(0);    //reset for new testcase

        if(root == null){
            return finalSum;
        }

        dfs(root);

        return finalSum;
    }

    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        currentNum =  currentNum.append(root.val);

        //NOTE BEFORE RECURSING CHECK IF ITS LEAF NODE OR NOT
        if(root.left == null && root.right == null){
            finalSum = finalSum + Integer.parseInt(currentNum.toString());
        }

        //only delete if nodes are not null
        if(root.left != null){
            dfs(root.left);
            currentNum.deleteCharAt(currentNum.length()-1);     //this is called backtrack
        } 

        if(root.right != null){
                dfs(root.right);
                currentNum.deleteCharAt(currentNum.length()-1); //bracking to previous state
        }
    }


    //main
    public static void main(String[] args){
        // TreeNode root = new TreeNode(1);
        // TreeNode node1 = new TreeNode(2);
        // TreeNode node2 = new TreeNode(3);

        // root.left = node1;
        // root.right = node2;

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        int sum = findAllPathSums(root);
        System.out.println("Sum of all Paths:"+sum);
    }
}
