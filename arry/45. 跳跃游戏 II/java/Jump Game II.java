class Solution {
    // [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
    // 参考贪心算法思路，遍历寻找最优解
    public int jump(int[] nums) {
        int len = nums.length;
        int jump = len == 1 ? 0 : 1;
        int farthest = nums[0];
        for (int i = 1; i < len && farthest < len - 1; i++) {
            int possibleMostFarthestJump = 0;
            for (int j = i; j <= farthest; j++) {
                possibleMostFarthestJump = Math.max(possibleMostFarthestJump, nums[j] + j);
            }
            jump++;
            farthest = possibleMostFarthestJump;
        }
        return jump;
    }
}

class Solution2 {
    // 动态规划 (dynamic programming)
    public int jump(int[] nums) {
        int len = nums.length;

        return 0;
    }
}