class Solution {
private List<List<String>> result = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>(); // row - col
    private Set<Integer> diag2 = new HashSet<>(); // row + col

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        
        backtrack(0, n, board);
        return result;
    }

    private void backtrack(int row, int n, char[][] board) {
        // Base Case: All queens successfully placed
        if (row == n) {
            result.add(construct(board));
            return;
        }

        // Try placing a queen in every column of the current 'row'
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue; // Under attack! Skip this column.
            }

            // 1. Make Choice
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // 2. Explore next row
            backtrack(row + 1, n, board);

            // 3. Undo Choice (Backtrack)
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) res.add(new String(board[i]));
        return res;
    }
}
