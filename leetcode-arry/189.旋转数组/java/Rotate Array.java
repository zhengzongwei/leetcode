class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            result[obtainIndex(i,k,nums.length)] = nums[i];
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }

    private static int obtainIndex(int current,int offset,int length) {
        int v = current + offset;
        return v < length ? v : xx(v,length);
    }

    private static int xx(int offset,int length) {
        int v2 = offset - length;
        return v2 < length ? v2 : xx(v2,length);
    }

    // 1. 取模

    public void rotate_2(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            result[(k + i) % nums.length] = nums[i];
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }

    public static void main(String[] args) {
        System.out.println((1 + 2) % 8);
    }

    // 2. 空间复杂度O(1)
}