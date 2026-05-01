class Solution {

   public int dfs(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        visited[i][j] = true;

        int area = 1; // current cell

        // up
        if (i > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            area += dfs(grid, visited, i - 1, j, rows, cols);
        }

        // down
        if (i < rows - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            area += dfs(grid, visited, i + 1, j, rows, cols);
        }

        // left
        if (j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            area += dfs(grid, visited, i, j - 1, rows, cols);
        }

        // right
        if (j < cols - 1 && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            area += dfs(grid, visited, i, j + 1, rows, cols);
        }

        return area;
    }


    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];


        int maxArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]== 1 && visited[i][j]==false){
                    int area = dfs(grid, visited, i, j, rows, cols);
                    maxArea = Math.max(area, maxArea);
                }

            }
        }
        return maxArea;
    }
}
