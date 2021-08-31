class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (hash.containsKey(nums[i])) {
                int anther = hash.get(nums[i]);
                if (Math.abs(anther - i) <= k) {
                    return true;
                }
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}

class Solution2 {
    // Leetcode 官方哈希列表解法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}