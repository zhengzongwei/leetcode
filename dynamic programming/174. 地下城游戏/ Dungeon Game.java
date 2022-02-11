class Solution {
    /**
     * example 1:
     *      -2   -3     3
     *      -5   -10    1
     *      10   30    -5
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r + 1][c + 1];

        for (int i = 0; i <= r; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                    continue;
                }
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}