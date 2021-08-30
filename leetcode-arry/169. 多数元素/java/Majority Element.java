class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        int element = 0;
        for (Integer k : hash.keySet()) {
            if (count < hash.get(k)) {
                count = hash.get(k);
                element = k;
            }
        }
        return element;
    }
}

class Solution2 {

}