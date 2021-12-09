class Solution {
    // 暴力破解
    public String longestPalindrome(String s) {
        int len = s.length();
        String[] dp = new String[len];
        String[] origin = s.split("");

        dp[0] = origin[0];
        for (int i = 1; i < len; i++) {
            String t = "";
            for (int j = 0; j <= i; j++) {
                if (origin[j].equals(origin[i])) {
                    Boolean isLevel = isStrLevel(origin, j, i);
                    if (isLevel) {
                        t = s.substring(j, i + 1);
                        break;
                    }
                }
            }
            dp[i] = t.length() > dp[i - 1].length() ? t : dp[i - 1];
        }

        return dp[len - 1];
    }

    public static Boolean isStrLevel(String[] arr, int l, int r) {
        for (; l < r; l++, r--) {
            if (!arr[l].equals(arr[r])) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    // 动态规划
    public String longestPalindrome(String s) {
    }
}