class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days <= 1) {
            return 0;
        }
        int[] dp = new int[days];
        dp[1] = Math.max(dp[0], prices[1] - prices[0]);
        for (int i = 2; i < days; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[days - 1];
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        if (days <= 1) {
            return 0;
        }
        int[][] dp = new int[days][2];
        // 当天未购入股票
        dp[0][0] = 0;
        // 当天购入股票
        dp[0][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[days - 1][0];
    }
}