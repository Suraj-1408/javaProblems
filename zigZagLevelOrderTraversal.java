import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Collections;
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


public class zigZagLevelOrderTraversal{
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    
        //define a queue of type Treenod
        //loop until queue is not empty
        //while looping , 
        // get the queue size as each size represent specific level in binary tree. 
        //now use for loop to through the current size
        //pop the front node in queue one by one ,
        //add the node value into levelnodes array , further check if any child nodes exist for popped up node.
        //if exist, add them to ongoing queue.
        //once the for loop ends

        //check if iterated binary level was even or odd ,
        //if even , call helper function to reverse the array , and then add the resultant array to final resultant
        //if odd, directly add resultant to final resultant.
        //increment the level by one;

        //at last once all nodes in queue are processed , return the final resultant.

        //if root is null return empty list
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        //creating a final resultant
        List<List<Integer>> zigzagLevelNodes = new ArrayList<>();
        int level = 1;
        //loop through while loop until queue nodes are processed.
        while(!queue.isEmpty()){
            int qsize = queue.size();

            //creating a array for storing current level nodes
            List<Integer> levelNodes = new ArrayList<>();

            for(int i = 0; i < qsize;i++){
                TreeNode current = queue.poll();

                levelNodes.add(current.val);

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }

            if(level % 2 == 0){
                //List<Integer> reversed = reversenodes(levelNodes);
                Collections.reverse(levelNodes);
                zigzagLevelNodes.add(levelNodes);
            }else{
                zigzagLevelNodes.add(levelNodes);
            }
            level++;
        }

        return zigzagLevelNodes;
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

        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println("Nodes in Zig Zag LEvel:"+res);
    }
}