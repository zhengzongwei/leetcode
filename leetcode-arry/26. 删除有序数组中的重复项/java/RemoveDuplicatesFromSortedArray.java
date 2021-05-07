class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int size = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            while(i + 1 < nums.length && nums[i] == nums[i + 1] && len > 1) {
                int var;
                for(int j = i + 1;j < nums.length - 1; j++) {
                    var = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = var;
                }
                len--;
            }
            size++;
        }
        return size;
    }
}