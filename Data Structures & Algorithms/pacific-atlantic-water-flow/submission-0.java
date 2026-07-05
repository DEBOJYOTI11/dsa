class Solution {
public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();

        if (heights == null || heights.length == 0)
            return ans;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific: top row
        for (int c = 0; c < n; c++) {
            pacific[c == c ? 0 : 0][c] = true;
            pacificQueue.offer(new int[]{0, c});
        }

        // Pacific: left column
        for (int r = 1; r < m; r++) {
            pacific[r][0] = true;
            pacificQueue.offer(new int[]{r, 0});
        }

        // Atlantic: bottom row
        for (int c = 0; c < n; c++) {
            atlantic[m - 1][c] = true;
            atlanticQueue.offer(new int[]{m - 1, c});
        }

        // Atlantic: right column
        for (int r = 0; r < m - 1; r++) {
            atlantic[r][n - 1] = true;
            atlanticQueue.offer(new int[]{r, n - 1});
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] heights,
                     Queue<int[]> queue,
                     boolean[][] visited) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] dir : dirs) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                // Reverse flow:
                // Can only move from lower/equal to higher/equal.
                if (heights[nr][nc] < heights[r][c])
                    continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
