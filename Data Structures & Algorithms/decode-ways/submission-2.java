class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base case: An empty string has 1 valid decoding way
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            // If the current character is '0', it cannot form a valid single-digit code
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // Take the ways from the single-digit decoding
                dp[i] = dp[i + 1];

                // Check if a valid two-digit code can be formed (10 to 26)
                if (i + 1 < n) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }

        return dp[0];
    }
}