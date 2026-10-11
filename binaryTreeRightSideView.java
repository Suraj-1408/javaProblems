import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
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

public class binaryTreeRightSideView{
    public static List<Integer> rightSideView(TreeNode root) {
        
        //check if tree is empty or not
        if(root == null){
            return new ArrayList<>();
        }

        //using Queue data structure to solve the problem.
        //accessing all nodes at each levels , inserting the last node in resultant at each level and
        //then continue to add their childerens at each node in Queue
        Queue<TreeNode> queue = new ArrayDeque<>();

        //creating a resultant array
        List<Integer> allrightNodes = new ArrayList<>();

        //adding the root to queue to start traversin the binary tree
        queue.offer(root);

        //traverse the binary tree UNTIL queue is not empty
        while(!queue.isEmpty()){
            //1. COMPUTE THE QUEUE SIZE
            int levelSize = queue.size();

            //now looping to all nodes in that level.
            for(int i = 0; i < levelSize;i++){
                //1. pop the node from queue
                TreeNode current = queue.poll();

                //ACTUAL LOGIC - GET THE NODE VALUE & INSERT THE POPPED ONLY IF ITS THE LAST NODE IN LEVEL
                if(i == (levelSize-1)){
                    //int lastNodeValue = current.val;
                    allrightNodes.add(current.val);
                } 

                //insert current node childerens if they exist.
                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }

        return allrightNodes;
    }

    //main
    public static void main(String[] args){
        TreeNode root =  new TreeNode(1);
        TreeNode node1= new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);


        root.left = node1;
        root.right = node2;

        node1.right = node4;
        node2.right = node3;

        List<Integer> result = rightSideView(root);
        System.out.println("Printing all nodes visible from right side:"+result);
    }
}