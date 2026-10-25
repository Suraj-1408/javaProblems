import java.util.Queue;
import java.util.ArrayDeque;


class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}

public class sumOfAllLeftLeaves{
    public static int findSumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }

        //define Queue of type TreeNode track nodes in binary tree.
        Queue<TreeNode> queue = new ArrayDeque<>();

        //define another queue of type integer, to track whether each node is left or right.
        Queue<Integer> intQueue = new ArrayDeque<>();   // 0 - right node ; 1 - leftnode    

        queue.offer(root);
        intQueue.offer(0); 

        int sum = 0;    //track sum of all left leaves
        while(!queue.isEmpty() && !intQueue.isEmpty()){
            int currentsize = queue.size();

            for(int i = 0; i < currentsize;i++){
                TreeNode currentNode = queue.poll();    //pop the first node in quue.
                int flag = intQueue.poll();

                //core logic
                if(currentNode.left == null && currentNode.right == null && flag == 1){
                    sum = sum + currentNode.val;
                }

                //check if currentNode child exist and add them in queue.
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                    intQueue.offer(1);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                    intQueue.offer(0);
                }
            }
        }
System.out.println("Reaching before RETURN");
        return sum;
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

        int resultant =  findSumOfLeftLeaves(root);
        System.out.println("Sum of all leaves node in the Binary Tree:"+resultant);
    }
}