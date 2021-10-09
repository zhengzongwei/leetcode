class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) {
            return 0;
        }

        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                buys[j] = j == 0 ? Math.min(buys[j], prices[i]) : Math.min(buys[j], prices[i] - sells[j - 1]);
                sells[j] = Math.max(sells[j], prices[i] - buys[j]);
            }
        }

        return sells[k - 1];
    }
}