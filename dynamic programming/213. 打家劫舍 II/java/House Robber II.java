class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        } else if(len == 1) {
            return nums[0];
        } else if(len == 2) {
            return Math.max(nums[0],nums[1]);
        }
        // 假设抢第一家
        int[] dp_1 = new int[len - 1];
        // 假设抢第二家
        int[] dp_2 = new int[len - 1];

        dp_1[0] = nums[0];
        dp_1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp_1[i] = Math.max(dp_1[i - 1], dp_1[i - 2] + nums[i]);
        }

        dp_2[0] = nums[1];
        dp_2[1] = Math.max(nums[1], nums[2]);
        for (int j = 2,i = 3; i < len; j++,i++) {
            dp_2[j] = Math.max(dp_2[j - 1], dp_2[j - 2] + nums[i]);
        }

        return Math.max(dp_1[len - 2],dp_2[len - 2]);
    }
}