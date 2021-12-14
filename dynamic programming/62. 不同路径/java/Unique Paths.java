class Solution {
    // 动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m - 1][n - 1];
    }
}

class Solution2 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 定义边界
        dp[0][0] = 1;
        for (int r = 1; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int c = 1; c < n; c++) {
            dp[0][c] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    }
}