class Solution {
    /**
     * 动态规划
     * @param n
     * @return
     *
     * dp[1] = 1;
     * dp[2] = 2;
     * dp[3] = 3;
     * dp[4] = 1;
     * dp[5] = 2;
     * dp[6] = 3;
     * dp[7] = 4;
     * dp[8] = 2;
     * dp[9] = 1;
     * dp[10] = 2;
     * dp[11] = 3;
     * dp[12] = 4;
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if(j * j == i) {
                    dp[i] = 1;
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }
}