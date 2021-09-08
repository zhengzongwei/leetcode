class Solution {
    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;
    }
}