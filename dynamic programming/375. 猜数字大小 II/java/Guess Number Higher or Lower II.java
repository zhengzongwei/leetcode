class Solution {
    /**
     * 动态规划
     *
     * example: n = 1 result: 0
     * example: n = 2 result: 1
     * example: n = 3 result: 2
     * example: n = 4 result: 4
     * example: n = 5 result: 6
     * example: n = 6 result: 8
     * example: n = 7 result: 10
     * example: n = 10 result: 16
     * example: n = 11 result: 18
     * example: n = 12 result: 20
     * example: n = 19 result: 46
     * example: n = 20 result: 49
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = j + dp[i][j - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}

class Solution2 {
    // 动规 + 递归
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return dsf(dp, 1, n);
    }

    private int dsf(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            result = Math.min(result, i + Math.max(dsf(dp, start, i - 1), dsf(dp, i + 1, end)));
        }
        dp[start][end] = result;
        return result;
    }
}