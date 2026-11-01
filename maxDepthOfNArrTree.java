import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Node{
    int val;
    List<Node> childrens;

    Node(int val){
        this.val = val;
        this.childrens = new ArrayList<>();     //initially empty
    }

}

public class maxDepthOfNArrTree{
    //approach - using algorithm similar to preOrder - note the childerens not 2 , but n childerens.
    //Using DFS - Since we start with the root, calling a recursive with root & depth i.e 1, of root computed.
    //inside DFS - we always first update the root(here in this problem our objective is to compute maxDepth)
    //so therefore updating the maxDepth first,
    //next - looping through the all childrens BY CALLING THE DFS FOR EACH SEPARATE NODE WITH +1.

    static int maxDepth = 0;
    public static int findingMaximumDepth(Node root) {
        maxDepth = 0;       //reset before use, usefull when having multiple testcases.
        //base case 
        if(root == null){
            return 0;
        }

        dfs(root, 1);

        return maxDepth;    //this variable will keep on updating in dfs function.
    }

    //dfs implementation.
    public static void dfs(Node root, int depth){
        if(root == null){
            return;
        }
        //As preOrder , we always compute the root, now based on problem , objective is to find maxDepth.
        maxDepth = Math.max(maxDepth , depth);

        //looping through all childrens node and for each child node calling dfs with maxDepth and depth incremented by 1
        for(Node child : root.childrens){
            dfs(child, depth + 1);
        }
    }


    //main
    public static void main(String[] args){
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);

        root.childrens.add(n1);
        root.childrens.add(n2);
        root.childrens.add(n3);

        n1.childrens.add(n4);
        n1.childrens.add(n5);

        int maximumDepth = findingMaximumDepth(root);
        System.out.println("Maximum Depth of given tree is:"+maximumDepth);
    }
}