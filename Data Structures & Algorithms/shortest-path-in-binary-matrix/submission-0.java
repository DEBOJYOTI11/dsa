

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
        
        // Edge case: start or end blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Directions (8 directions)
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // row, col, distance

        // Mark visited
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], dist = curr[2];

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(newRow, newCol, grid)) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1; // mark visited
                }
            }
        }

        return -1;


    }


  private boolean isValid(int r, int c, int[][] grid) {
        int n = grid.length;
        return r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 0;
    }
}