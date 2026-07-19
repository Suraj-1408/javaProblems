import java.util.LinkedList;
import java.util.HashMap;

class ListNode{
    int data;
    ListNode next;
    
	public ListNode(int val){
	    this.data = val;
	    this.next = null;
	}
}

public class detectCycleInLinkedList
{
    public static ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        
        HashMap<ListNode,Integer> map = new HashMap();
        int index = 0;
        while(temp != null){
            //int indexvalue = temp.next.data;
            if(!map.containsKey(temp)){
                map.put(temp,index);
                index = index+1;
            }
            else{
                int loopIndex = map.get(temp);
                System.out.println("tail connects to node index "+loopIndex);
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("no cycle");
        return null;
    }
    
	public static void main(String[] args) {
	    
		
		ListNode head = new ListNode(3);
		ListNode first = new ListNode(2);
		head.next = first;
		ListNode second = new ListNode(0);
		first.next = second;
		ListNode third = new ListNode(-4);
		second.next  = third;
		third.next = first;
// 		LinkedList<Integer> ListNode = new LinkedList();
// 		ListNode.add(3);
// 		ListNode.add(2);
// 		ListNode.add(0);
// 		ListNode.add(4);
		
		//detectCycle(head);
		ListNode cycleNode = detectCycle(head);
        
        // Print the result directly from the main method
        if (cycleNode != null) {
            System.out.println("Cycle detected at node with data: " + cycleNode.data);
        } else {
            System.out.println("No cycle found in the linked list.");
        }
	}
}
