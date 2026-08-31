class Solution {

    public int paths(int m,int n, int i, int j,  int[][] dp){

            
            if(i==m-1 && j==n-1){
                return 1;
            }

            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int[][] arr = {{1,0}, {0,1}};

            int p = 0;
            for(int[] dir : arr){

                int ni = i + dir[0];
                int nj = j + dir[1];

                if(ni>=0 && ni < m && nj>=0 && nj<n){
                    p+=paths(m, n, ni, nj, dp);
                }
            }
            dp[i][j] = p;
            return p;

    }
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return paths(m, n, 0, 0, dp);
        
    }
}
