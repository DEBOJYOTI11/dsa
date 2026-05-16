class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int n = grid.length, m = grid[0].length;

        for(int i=0; i< n ; i++){
            for(int j = 0 ; j< m; j++){
                
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int time[][] = new int[n][m];

        int maxTime = 0;
        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int[][] adjArr = {{-1, 0}, {1,0} , {0,-1}, {0, 1} };

            for(int[] adj : adjArr){
                
                int x = curr[0] + adj[0];
                int y = curr[1] + adj[1];

                if(x >= 0 && x < n && y >=0 && y < m && grid[x][y] == 1){
                    grid[x][y] = 2;

                    time[x][y] = time[curr[0]][curr[1]] + 1;
                    maxTime = Math.max( maxTime, time[x][y]);
                    queue.offer(new int[]{x,y});
                }
            }
        }

        boolean  allRotten = true;
        for(int i=0; i< n ; i++){
            for(int j = 0 ; j< m; j++){
                System.out.print(grid[i][j]+" ");
                if(grid[i][j] == 1){
                    allRotten = false;
                }
            }
            System.out.println();
        }
        return allRotten?maxTime:-1;      
    }
}
