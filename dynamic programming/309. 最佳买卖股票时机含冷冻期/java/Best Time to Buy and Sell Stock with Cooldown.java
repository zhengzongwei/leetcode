class Solution {
    /**
     * example: [1,2,3,0,2] result: 3 status: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len][3];
        /**
         * 0 持有股票当天买入
         * 1 不持有股票 当天卖出
         * 2 不持有股票 当天不进行买入、卖出操作
         */
        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}