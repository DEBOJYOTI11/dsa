class Solution {

    // practising DFS

    public void dfs(int n, int m, int i, int j, char[][] grid, boolean[][] visited){

            visited[i][j] = true;
            int[][] directions = {{-1, 0}, {1, 0 }, {0, -1}, {0, 1}};

            for(int[] direction : directions){
                
                int x = i+direction[0];
                int y = j+direction[1];

                if(x >= 0 && x<n && y >= 0 && y<m  && !visited[x][y] && grid[x][y]=='1' ){
                    dfs(n, m, x, y, grid, visited);
                }
            }
           
    }


    

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int island = 0;
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                
                if(!visited[i][j] && grid[i][j] == '1'){

                    dfs(n, m, i, j, grid, visited);
                    island++;
                }

            }
        }   
        return island; 
    }
}
