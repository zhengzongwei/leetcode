class Solution {
    public int firstMissingPositive(int[] nums) {
        // PLAN 1
        int size = nums.length;
        int i = 0;
        while (i < size) {
            if (nums[i] > 0 && nums[i] < size && nums[nums[i] - 1] != nums[i]) {
                int swap = nums[i];
                nums[i] = nums[swap - 1];
                nums[swap - 1] = swap;
            } else {
                i++;
            }
        }

        for (int j = 0; j < size; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return size + 1;


        // PLAN 2
//        Arrays.sort(nums);
//        int min = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == min) {
//                min++;
//            }
//        }
//        return min;
    }
}