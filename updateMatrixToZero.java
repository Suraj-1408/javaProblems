import java.util.List;
import java.util.ArrayList;

public class updateMatrixToZero
{
    public void setZeroes(int[][] matrix) {

        List<int[]> zeros = new ArrayList();
        
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                
                if(matrix[i][j] == 0){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    
                    zeros.add(arr);
                }
                
            }
            System.out.println("");
        }
        
        
        for(int i = 0 ;i < zeros.size();i++){
            int[] res = zeros.get(i);
            
            int row = res[0];
            for(int k  = 0;k < matrix[0].length;k++){
                matrix[row][k] = 0;
            }
            
            int column = res[1];
            for(int l = 0; l < matrix.length;l++){
                matrix[l][column] = 0; 
            }
        }
        
        
        //printing the Matrix
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(j == matrix[0].length-1){
                    System.out.print(matrix[i][j]+"");
                }
                else{
                    System.out.print(matrix[i][j]+",");
                }
            }
            System.out.println("");
        }
    }
    
	public void main(String[] args) {
		//System.out.println("Hello World");
		
// 		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};		
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
	}
}
