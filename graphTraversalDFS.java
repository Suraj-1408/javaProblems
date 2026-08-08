import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Node{
    int data;
    List<Node> neighbors;
    
    public Node(int data){
        this.data = data;
        this.neighbors = new ArrayList<>();
    }
}
public class graphTraversalDFS
{
    public static void printVertexes(Node start){
        Stack<Node> stk = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        
        stk.push(start);
        visited.add(start.data);
        System.out.print(start.data+"\t");
        
        while(!stk.isEmpty()){
            Node currentNode = stk.peek();
            
            //traverse to all neighbors
            Node nextNode = null;
            for(int i = 0; i < currentNode.neighbors.size();i++){
                if(!visited.contains(currentNode.neighbors.get(i).data)){
                    nextNode = currentNode.neighbors.get(i);
                    break;
                }
            }
            
            if(nextNode != null && !visited.contains(nextNode.data)){
                //currentNode = currentNode.next;
                currentNode = nextNode;
                visited.add(currentNode.data);
                stk.push(currentNode);
                System.out.print(nextNode.data + "\t");

            }else{
                stk.pop();
            }   
        }
    }
	public static void main(String[] args) {
		System.out.println("Graph Vertex traversal");
		Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node3);
        
        System.out.print("DFS Traversal: ");
        printVertexes(node0);
	}
}
