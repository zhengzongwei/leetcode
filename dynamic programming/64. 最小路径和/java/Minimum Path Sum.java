class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];

        // 先求去边界最小路径
        dp[0][0] = grid[0][0];
        for (int r = 1; r < row; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }
        for (int c = 1; c < column; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        // 再求每一种路径最小的那个
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][column - 1];
    }
}