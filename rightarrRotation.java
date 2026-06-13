// For each array, perform a number of right circular rotations and return the values of the elements at the given indices.
// a = [3,4,5];
// k = 2;
// queries = [1,2];
// First we perform the two rotations: [3,4,5]  ->[5,3,4] -> [4,5,3]

// Now return the values from the zero-based indices 1 and 2 as indicated in the queries array.
// a[1] = 5 , a[2] = 3

// Sample input - 
// 3 2 3 : n , k , query indexes
// 1 2 3 : arr elements
// 0 //indexes
// 1   //indexes
// 2   //indexes

// Sampe output = 2 ,3 , 1
import java.util.List;
import java.util.ArrayList;

public class rightarrRotation
{
    public static List<Integer> circularArrayRotation(List<Integer> a,int k,List<Integer> queries) {
        // Write your code here
        //RIGHT ROTATION-
        //1) reverse complete array.
        //2) reverse first 0 to k-1`
        //3) reverse k to n-1
        k = k % a.size();       //prevent duplicate rotations when final result same as given array
        
        int s1 = 0;
        int e1 = a.size()-1;
        while(s1 < e1){
            int first = a.get(s1);
            a.set(s1,a.get(e1));
            a.set(e1,first);
            s1++;
            e1--;
        }
        
        //reversing first 0 to k-1 elements
        int s2 = 0;
        int e2 = k-1;
        while(s2 < e2){
            int first = a.get(s2);
            a.set(s2,a.get(e2));
            a.set(e2,first);
            s2++;
            e2--;
        }
        
        //reverse k to n-1
        int s3 = k;
        int e3 = a.size()-1;
        while(s3 < e3){
            int first = a.get(s3);
            a.set(s3,a.get(e3));
            a.set(e3,first);
            s3++;
            e3--;
        }
        
        //resultant arr
        List<Integer> query = new ArrayList();
        for(int i = 0 ; i < queries.size();i++){
            int value = a.get(queries.get(i));
            query.add(value);
        }
        
        return query;
    }
    
	public static void main(String[] args) {
		System.out.println("Reversing complete array");
		List<Integer> arr = new ArrayList();
		//arr.add(3);
		arr.add(1);
		arr.add(2);
		arr.add(3);
        
        List<Integer> indexes = new ArrayList();
        indexes.add(0);
        indexes.add(1);
        indexes.add(2);
        
		System.out.println("Before Reverse:");
        for(int i = 0; i < arr.size();i++){
            System.out.print(arr.get(i)+"\t");
        }
        System.out.println("\n\n After Reverse:");
        List<Integer> res = new ArrayList();
        res = circularArrayRotation(arr,2,indexes);
        for(int i = 0; i < arr.size();i++){
            System.out.print(arr.get(i)+"\t");
        }
        

        
        //List<Integer> values = new ArrayList();
        //values = circularArrayRotation(arr,2,indexes);
        System.out.println("\n\nValues of asked indexes after 2 rotation:");
	    for(int i = 0; i < res.size();i++){
            System.out.print(res.get(i)+"\t");
        }
	    
	}
}
