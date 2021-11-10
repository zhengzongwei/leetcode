class Solution {
    /**
     * example [2,2,3,3,3,4]
     * example [2,2,3,3,3,4,4,5]
     * example [2,2,3,4,5]
     * example [2,3,3,4,5]
     * <p>
     * maxA: 不能允许相加的最大值
     * maxB: 能允许相加的最大值
     * addition: 当前相同值累加
     * dp[i] = Math.max(maxA,addition + maxB)
     */
    public int deleteAndEarn(int... nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int[] dp = new int[size];
        int maxA = 0, maxB = 0;
        dp[0] = nums[0];
        int addition = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                addition += nums[i];
                dp[i] = Math.max(maxA, addition + maxB);
            } else {
                addition = nums[i];
                maxB = nums[i] == nums[i - 1] + 1 ? maxA : dp[i - 1];
                maxA = dp[i - 1];
                dp[i] = Math.max(maxA, addition + maxB);
            }
        }
        return dp[size - 1];
    }
}