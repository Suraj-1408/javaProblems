public class wordSearch{
	public static boolean exist(char[][] board, String word) {
        	//traversing each cell of matrix by matching each character of word with current cell value.
		for(int r = 0; r < board.length;r++){
			for(int c = 0; c < board[0].length;c++){
				if(dfs(board,word,r,c,0)){
					return true;
				}
			}
		}
		return false;	
    	}

	//dfs function - for each cell check if matches the current index value of word.
	//index = track the index in word and that we compare with cell value.
	//r = current row
	//c = current col
	//word = given word
	//board = given grid.
	
	public static boolean dfs(char[][] board, String word, int r, int c, int index){
		//checking boundary cell.
		if(r < 0 || r >= board.length || c < 0 || c >= board[0].length){
			return false;
		}

		//check if character doesn't match
		if(board[r][c] != word.charAt(index)){
			return false;
		}

		//if index matches length of word - return true.
		if(index == word.length()-1){
			return true;
		}

		
		//save the current cell character , before marking it as visited- just in case to restore it back again.
		char original = board[r][c];
		board[r][c] = '#';

		//next check posssibility of next character in each for 4 direction.
		boolean found = dfs(board,word,r-1,c,index+1) || dfs(board,word,r+1,c,index+1) || dfs(board,word,r,c-1,index+1) || dfs(board,word,r,c+1,index+1);
		
		//restore
		board[r][c] = original;

		return found;
	}

	//main
	public static void main(String[] args){
		
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		//String word = "SEE";
		String word = "ABCB";
		boolean res = exist(board, word);
		if(res){
			System.out.println("FOUND!");
		}
		else{
			System.out.println("Not Found!");
		}
	} 
}