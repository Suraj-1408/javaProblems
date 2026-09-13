public class numsOfILands
{
    public static int numIslands(char[][] grid) {
        int landCount = 0;
        for(int r = 0; r < grid.length;r++){
            for(int c = 0; c < grid[0].length;c++){
                if(grid[r][c] == '1'){
                    landCount = landCount + 1;
                    isLand(grid,r,c);
                }
            }
        }
        return landCount;
    }
    
    public static void isLand(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
            return;
        }
        
        if(grid[r][c] != '1'){
            return;
        }
        
        grid[r][c] = '#';
    
        isLand(grid,r+1,c);
        isLand(grid,r-1,c);
        isLand(grid,r,c-1);
        isLand(grid,r,c+1);

        //grid[r][c] = ch;
        // return res;
    }
    
	
    
	public static void main(String[] args) {
		// char[][] grid = {
        //         {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}
        //     };
		    char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
            };
		  int landCount = numIslands(grid);
		  System.out.println("Island Count:"+landCount);
    }
}