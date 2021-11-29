class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < 0) {
                max = nums[i];
            } else {
                max += nums[i];
            }
            result = Math.max(max, result);
        }
        return result;
    }
}