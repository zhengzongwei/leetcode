class Solution {
    public int majorityElement(int[] nums) {
        int count = Math.floorDiv(nums.length, 2);
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        int val = count;
        int key = 0;
        for (Integer k : hash.keySet()) {
            if (val < hash.get(k)) {
                val = hash.get(k);
                key = k;
            }
        }
        return key;
    }
}