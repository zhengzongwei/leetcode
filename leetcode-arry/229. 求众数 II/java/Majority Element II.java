class Solution {
    /**
     * 利用哈希Map存储每个元素出现总数
     */
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        List<Integer> elements = new ArrayList();
        int count = Math.floorDiv(nums.length, 3);
        for (int num : nums) {
            int c = hash.getOrDefault(num, 0) + 1;
            hash.put(num, c);
            if (count < c && !elements.contains(num)) {
                elements.add(num);
            }
        }
        return elements;
    }
}

class Solution2 {
    public List<Integer> majorityElement(int[] nums) {

    }
}