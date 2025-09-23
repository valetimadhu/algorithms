package ds.graph;

public class WordSearch {
//    public boolean exist(char[][] board, String word) {
//        int m = board.length;
//        int n = board[0].length;
//        
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if ( board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
//                    return true;
//                }
//            }
//        }
//        
//        return false;
//    }
//
//    private boolean dfs(char[][] board, String word, int i, int j, int index) {
//        if (index == word.length()) {
//            return true;
//        }
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
//            return false;
//        }
//        
//        char temp = board[i][j];
//        board[i][j] = '#';  // mark as visited
//        
//        boolean found = dfs(board, word, i + 1, j, index + 1)
//                || dfs(board, word, i - 1, j, index + 1)
//                || dfs(board, word, i, j + 1, index + 1)
//                || dfs(board, word, i, j - 1, index + 1);
//        
//        board[i][j] = temp;  // unmark
//        
//        return found;
//    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
       System.out.println(ws.exist(board1, "ABCCED"));  // Output: true
       System.out.println(ws.exist(board1, "SEE"));     // Output: true
       System.out.println(ws.exist(board1, "ABCB"));    // Output: false
    }
    
    public boolean exist(char[][] board, String word) {
    	int m = board.length;
    	int n = board[0].length;
    	
    	for(int i=0; i< m; i++) {
    		for(int j=0; j<n; j++) {
    			if(board[i][j] == word.charAt(0) && dfs(board,word, i,j, 0))
    				return true;
    		}
    	}
    	
    	return false;
    	
    }
    
   public boolean exist1( char[][] board, String word) {
	   int m = board.length;
	   int n = board[0].length;
	   
	   for(int i=0; i< m; i++) {
		   for(int j=0; j< n; j++) {
			   if(board[i][j] == word.charAt(0) && dfs1(board,word, i, j, 0)) 
				   return true;
		   }
	   }
	   return false;
   }
   
   private boolean dfs1(char[][] barod, String word, int i, int j, int index) {
	   
	   if(index == word.length()) return true;
	   
	   if( i< 0 || i>= barod.length || j< 0 || j>= barod.length || barod[i][j] != word.charAt(index)) {
		   return false;
	   }
	   char temp = barod[i][j];
	   
	   barod[i][j] = '#';
			   
	boolean found =  dfs(barod,word, i , j, index+1) || 
	dfs(barod,word, i , j, index+1) ||
	dfs(barod,word, i , j, index+1) ||
	dfs(barod,word, i , j, index+1) ;
	   barod[i][j] = temp;
	   
	   return found;
	   
   }
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
    	
    	if(index == word.length()) return true;
    	
    	if(i < 0 || i>= board.length || j< 0 || j>= board[0].length || board[i][j] != word.charAt(index)) {
    		return false;
    	}
    	
    	char temp = board[i][j];
    	
    	board[i][j] = '#';
    	
    	boolean found = dfs(board,word, i+1,j, index+1) ||
    			dfs(board,word, i-1,j, index+1) ||
    			dfs(board,word, i,j+1, index+1) ||
    			dfs(board,word, i,j-1, index+1) ;
    	
    	board[i][j] = temp;
    	
    	return found;
    			
    }
    
    
    
    
}
