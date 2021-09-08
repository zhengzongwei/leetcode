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
    // 动态规划
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] db = new boolean[len];
        db[0] = true;
        for (int i = 0; i < len; i++) {
            if (db[i]) {
                for (int j = 1; j <= nums[i] && i + j < len; j++) {
                    db[i + j] = true;
                }
            }
        }
        return db[len - 1];
    }
}