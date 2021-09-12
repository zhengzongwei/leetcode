class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastRows = triangle.get(0);
        int count = lastRows.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> rows = triangle.get(i);
            List<Integer> currentRows = new ArrayList<>();
            count = rows.get(0) + lastRows.get(0);
            currentRows.add(count);
            for (int j = 1; j < rows.size(); j++) {
                int var = 0;
                if (j == rows.size() - 1) {
                    var = rows.get(j) + lastRows.get(j - 1);
                } else {
                    var = rows.get(j) + Math.min(lastRows.get(j), lastRows.get(j - 1));
                }
                count = Math.min(var, count);
                currentRows.add(var);
            }

            lastRows = currentRows;
        }
        return count;
    }
}

class Solution2 {
    // 动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            List<Integer> rows = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + rows.get(0);
            for (int j = 1; j < rows.size(); j++) {
                if (j == rows.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + rows.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rows.get(j), dp[i - 1][j] + rows.get(j));
                }
            }
        }

        int count = dp[len - 1][0];
        for (int z = 1; z < len; z++) {
            count = Math.min(count, dp[len - 1][z]);
        }

        return count;
    }
}