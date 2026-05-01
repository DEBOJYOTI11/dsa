class Solution {

    public void dfs(int i, int j, int rows, int cols, char[][] grid, boolean[][] visited ){
        
      
        visited[i][j] = true;

        // System.out.println(i+" "+j);
        // up
        if(i>0 && grid[i-1][j]=='1' && !visited[i-1][j]){
            dfs(i-1, j, rows,cols, grid, visited);
        }

        // down
       if(i<rows-1 && grid[i+1][j]=='1' && !visited[i+1][j]){
            dfs(i+1, j, rows,cols, grid, visited);
        }

        // left
       if(j>0 && grid[i][j-1]=='1' && !visited[i][j-1]){
            dfs(i, j-1, rows,cols, grid, visited);
        }
          // right
       if(j<cols-1 && grid[i][j+1]=='1' && !visited[i][j+1]){
            dfs(i, j+1, rows,cols, grid, visited);
        }

    }
    public int numIslands(char[][] grid) {
        
        int cols = grid[0].length;
        int rows = grid.length;
        boolean[][] visisted = new boolean[rows][cols];

        int islands = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                if(grid[i][j] == '1' && !visisted[i][j]){
                    islands++;
                    dfs(i, j, rows, cols, grid, visisted);
                }
            }
        }
        return islands;
    }
}
