class Solution {
    // 超时
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum = Math.max(sum, rangeBestBuy(0, i, prices) + rangeBestBuy(i, prices.length, prices));
        }
        return sum;
    }

    private int rangeBestBuy(int start, int end, int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}

class Solution2 {
    // 时间复杂度 O(3n)
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[] l_dp = new int[size];
        int[] r_dp = new int[size];

        int min = prices[0];
        for (int l = 1; l < size; l++) {
            min = Math.min(min, prices[l]);
            l_dp[l] = Math.max(l_dp[l - 1], prices[l] - min);
        }

        int max = prices[prices.length - 1];
        for (int r = prices.length - 2; r >= 0; r--) {
            max = Math.max(max, prices[r]);
            r_dp[r] = Math.max(r_dp[r + 1], max - prices[r]);
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = Math.max(sum, l_dp[i] + r_dp[i]);
        }

        return sum;
    }
}