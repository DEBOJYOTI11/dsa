class Solution {

     private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {

 if (grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure chests (0s) to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions: up, down, left, right
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS from all treasures
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check bounds + avoid water + only update if it's INF
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != INF) {
                    continue;
                }

                // Update distance: current cell + 1
                grid[nr][nc] = grid[r][c] + 1;

                // Add updated cell to queue
                queue.offer(new int[]{nr, nc});
            }
        }
         
    }
}
