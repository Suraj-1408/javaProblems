import java.util.HashSet;

public class containsDuplicates
{
    public static boolean containsDuplicate(int[] nums) {
        
        // HashMap<Integer,Integer> frequency = new HashMap();
        // int count = 1;
        // for(int i = 0; i < nums.length;i++){
        //     if(!frequency.containsKey(nums[i])){
        //         frequency.put(nums[i],count);
        //     }
        //     else{
        //         return true;
        //     }
        // }
        // return false;

        //HASHSET
        // HashSet<Integer> set = new HashSet();
        // for(int i = 0; i < nums.length;i++){
        //     if(!set.contains(nums[i])){
        //         set.add(nums[i]);
        //     }
        //     else{
        //         return true;
        //     }
        // }
        // return false;
        if(nums.length < 2){
            return false;
        }  
        HashSet<Integer> set = new HashSet<>(nums.length * 2);
        for(int i = 0; i < nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
        //System.out.println("Hello World");
        int[] arr = {1,2,3,1};
        boolean duplicatePresent = containsDuplicate(arr);
        if(duplicatePresent){
            System.out.println("Duplicate is present:"+duplicatePresent);
        }
        else{
            System.out.println("No Duplicates:"+duplicatePresent);
        }
    }
}
