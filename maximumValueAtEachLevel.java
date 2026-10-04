import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

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

public class maximumValueAtEachLevel{

    public static ArrayList<Integer> largestNodeAteachLevel(TreeNode root){
        // if(root == null){
        //     return null;
        // }

        // ArrayList<Integer>  res = new ArrayList<>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root.val);

        // while(!queue.isEmpty()){
        //     TreeNode curr = queue.poll();
        //     int peekElem;

        //     if(!queue.isEmpty()){
        //         peekElem = queue.peek();
        //     }
            
        //     if(curr.val > peekElem){
        //         res.add(curr.val);
        //     }

        //     if(curr.left != null){
        //         queue.offer(curr.left);
        //     }

        //     if(curr.right != null){
        //         queue.offer(curr.right);
        //     }

        // }
        // return res;



        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int currentSize = queue.size();
            int maxValue  = Integer.MIN_VALUE;

            for(int i = 0; i < currentSize; i++){
                TreeNode curr = queue.poll();

                maxValue = Math.max(curr.val , maxValue);

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        ArrayList<Integer> res = largestNodeAteachLevel(root);
        System.out.println("Largest node at each levels:"+res);
    }
}