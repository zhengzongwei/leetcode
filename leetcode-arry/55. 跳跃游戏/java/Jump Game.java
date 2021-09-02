class Solution {
    // 贪心算法
    // 时间复杂度 O(n)
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int farthest = nums[0];
        for (int i = 0; i < len; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean canJump(int[] nums) {
        return false;
    }
}