class Solution {
    // 滑动窗口 + TreeSet集合
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            // ceiling() the least key greater than or equal to key, or null if there is no such key
            Long ceiling = tree.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && Math.abs((long) nums[i] - ceiling) <= t) return true;
            tree.add((long) nums[i]);
            if (tree.size() > k) {
                tree.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

class Solution2 {
    // 桶排序
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return false;
    }
}