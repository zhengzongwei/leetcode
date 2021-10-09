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