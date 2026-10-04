


import java.util.Queue;
import java.util.LinkedList;

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

public class findBottomLeftValue {
    public static int findBottomLeftValue(TreeNode root) {

        if(root == null){
            return 0;
        }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       int leftMost = 0;
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            leftMost = queue.peek().val;            //imp  updating the leftmost node at each row start

            for(int i = 0; i < currentSize;i++){
                TreeNode current = queue.poll();    //removing the peek element.
                      
                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }
       }
       return leftMost;
    }

    //main
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left =  node6;

        int leftMostNode = findBottomLeftValue(root);
        System.out.println("Finding the bottom left most node in binary tree:"+leftMostNode);
    }
}