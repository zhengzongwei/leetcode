class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step = cost.length;
        int[] dp = new int[step + 1];
        for (int i = 2; i <= step; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[step];
    }
}