class Solution {
    /**
     * 贪心算法
     * @param nums
     * @return boolean
     */
    public boolean increasingTriplet(int[] nums) {
        int v1 = nums[0];
        int v2 = Integer.MAX_VALUE;
        for (int j = 1; j < nums.length; j++) {
            v1 = Math.min(nums[j], v1);
            if (nums[j] > v1) {
                v2 = Math.min(v2, nums[j]);
            }
            if (nums[j] > v2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 超时时间复杂度O(n^2)
     * @param nums
     * @return boolean
     */
    public boolean abandon(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v1 = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    v1 = Math.min(v1, nums[j]);
                }
                if (nums[j] > v1) {
                    return true;
                }
            }
        }
        return false;
    }
}