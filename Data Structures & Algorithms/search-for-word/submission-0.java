class Solution {
public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Treat every cell as a potential starting node in our graph
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: we matched all characters
        if (index == word.length()) return true;
        
        // Out of bounds check or character mismatch
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Graph Step: Mark node as visited
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        // Traverse to 4 connected neighbor nodes (Up, Down, Left, Right)
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        
        // Backtrack: Unmark node for other potential paths
        board[r][c] = temp;
        
        return found;
    }
}
