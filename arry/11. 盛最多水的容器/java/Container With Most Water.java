class Solution {
    /**
     * 双指针
     * example: [1,8,6,2,5,4,8,3,7] result 49 (2,9)
     * example: [8,20,1,2,3,4,5,6]
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = Math.min(height[l], height[r]) * (r - l);

        for (; l < r; ) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
        }

        return area;
    }
}