import java.util.*;

public class dialognalDiff{

    //user defined method.
    // public static int diagonalDifference(int[][] matrix){
    //     int left = 0;

    //     for(int i = 0;i < matrix.length;i++){
    //         System.out.print(matrix[i][i]+"\t");
    //         left += matrix[i][i];
    //     }
        
    //     //right diagonal
    //     int right = 0;
    //     for(int j = 0;j < matrix.length;j++){
    //         System.out.print(matrix[j][matrix.length - 1 - j]+"\t");
    //         right += matrix[j][matrix.length - 1 - j];
    //     }

    //     int absolute = Math.abs(left - right);
        
    //     return absolute;
    // }

    public static int dialognalDiff(List<List<Integer>> matrix){
        int left = 0;

        for(int i = 0;i < matrix.size();i++){
            System.out.print(matrix.get(i).get(i)+"\t");
            left += matrix.get(i).get(i);
        }

        int right = 0;
        for(int j = 0;j < matrix.size();j++){
            System.out.print(matrix.get(j).get(matrix.size()- 1 - j)+"\t");
            right += matrix.get(j).get(matrix.size()-1-j);
        }
        return Math.abs(left - right);
    }
    
public static void main(String[] args){
    //int matrix[][] = {{2,3,5},{6,8,7},{0,2,1}};
    //List<List<Integer>> arr = [[2,3,5],[6,8,7],[0,2,1]];
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(Arrays.asList(2,3,5));
    arr.add(Arrays.asList(6,8,5));
    arr.add(Arrays.asList(0,2,1));

    int result = dialognalDiff(arr);
    System.out.println("Left Diagonal Sum is:"+result);
}
}