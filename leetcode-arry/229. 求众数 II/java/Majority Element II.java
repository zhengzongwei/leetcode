class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        int count = Math.floorDiv(nums.length, 3);
        List<Integer> elements = new ArrayList();
        for (Integer k : hash.keySet()) {
            if (count < hash.get(k)) {
                elements.add(k);
            }
        }
        return elements;
    }
}

class Solution2 {
    
}