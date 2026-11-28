import java.util.List;
import java.util.ArrayList;

public class  findingNumberOfPartition{
    public static ArrayList<ArrayList<Integer>> findPartitions(int[] nums, int k){
        int size = nums.length;
        ArrayList<ArrayList<Integer>> partitions = new ArrayList<>();

        for(int i = 0; i < nums.length;){
            //int p = Math.min(nums.length,k);
            int step = Math.max(1, size / k); 
            //int base = (p/\/ k);
            if(partitions.size() == k){
                int lastPartitionsize = partitions.size() - 1;
                ArrayList<Integer> lastPartition = partitions.get(lastPartitionsize);

                for(int j = i; j < nums.length;j++){
                    int element = nums[j];
                    lastPartition.add(element);
                }
                break;   
            }else{
                ArrayList<Integer> subPartition = createPartition(nums,i,Math.min(i + step - 1, nums.length - 1));
                partitions.add(subPartition);
                i= i+step;
            }
        }
        return partitions;
    }    

    //partition creations.
    public static ArrayList<Integer> createPartition(int[] nums, int start, int end){
        ArrayList<Integer> partition = new ArrayList<>();
        for(int i = start;i <= end;i++){
            int element = nums[i];
            partition.add(element);
            // nums.remove(i);
        }
        return partition;
    }


    public static void main(String[] args){
        int[] nums = {9,1,2,3,9,6};
        int k = 3;
        ArrayList<ArrayList<Integer>> results = findPartitions(nums,k);
        System.out.println("Maximums Partitions that can obtained for array size:"+nums.length+" is:"+results.size());

        System.out.println("Partitions are as follows:"+results);
    }
}
