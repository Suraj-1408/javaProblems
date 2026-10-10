import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
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


public class binaryTreeLevelOrderTraversal{
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //check if tree is not empty
        if(root == null){
            return new ArrayList<>();
        }

        //create a Queue of type of node..
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        //Result
        List<List<Integer>> levelOrders = new ArrayList<>();

        while(!queue.isEmpty()){
            //compute the size
            int levelSize = queue.size();

            //create current arraylist to store all the nodes at specific level
            List<Integer> currentLevelNode = new ArrayList<>();


            //processing all node at current level using for loop
            for(int i = 0; i < levelSize;i++){
                //popping the current node
                TreeNode current = queue.poll();

                // getting the node value of popped up node
                int value = current.val;

                currentLevelNode.add(value);        //append it level array
                

                //then check the childerens of current popped up node, if exists, add them to the queue
                if(current.left != null){
                    queue.offer(current.left);
                } 

                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            //appending all nodes collected at specific to final resultant
            levelOrders.add(currentLevelNode);
        }

        return levelOrders;
    }

    //main method
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> levelOrders = levelOrder(root);
        System.out.println("Printing the level orders:"+levelOrders);
    }
}