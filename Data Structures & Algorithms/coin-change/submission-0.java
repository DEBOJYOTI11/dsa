class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];

        dp[0] = 0 ;
        for(int i=1;i<amount+1; i++){
            
          int min = Integer.MAX_VALUE;

            for(int coin : coins){
                if ( i- coin >=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    min = Math.min(min, dp[i-coin]+1);
                }
            } 
            dp[i] = min;
        }
        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}
