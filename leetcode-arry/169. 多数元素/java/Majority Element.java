class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        int count = Math.floorDiv(nums.length, 2);
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = hash.getOrDefault(nums[i], 0) + 1;
            hash.put(nums[i], c);
            if(count < c) {
                element = nums[i];
                break;
            }
        }
        return element;
    }
}

class Solution2 {
    // 空间复杂度 O(1)
    // 时间复杂度 O(n)
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            count += element == num ? 1 : -1;
        }
        return element;
    }
}