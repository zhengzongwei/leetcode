class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }

        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            minM = Math.min(minM, ops[i][0]);
            minN = Math.min(minN, ops[i][1]);
        }
        return minM * minN;
    }
}