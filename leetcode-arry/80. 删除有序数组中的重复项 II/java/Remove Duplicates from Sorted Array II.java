class Solution{
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if(i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public int doublePointer(int[] nums) {
        int left = 0;
        int count = 0;
        for(int right = 1;right < nums.length;right++) {
            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
                count = 0;
            } else if(count >= 1) {
                continue;
            } else {
                nums[++left] = nums[right];
                count++;
            }
        }
        return left + 1;
    }
}