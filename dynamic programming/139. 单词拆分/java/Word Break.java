class Solution {
    /**
     * 背包问题 动态规划
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        dp[0] = wordDict.contains(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String v = s.substring(j, i + 1);
                if (j == 0) {
                    dp[i] = wordDict.contains(v);
                } else {
                    if (dp[j - 1] && wordDict.contains(v)) {
                        dp[i] = true;
                        break;
                    }
                    dp[i] = false;
                }
            }
        }

        return dp[s.length() - 1];
    }
}

class Solution2 {
    /**
     * 超时容易陷入死循环
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 枚举
        for (int i = 0; i < wordDict.size(); i++) {
            String start = wordDict.get(i);
            if (s.startsWith(start)) {
                if (findStr(s.replaceFirst(start, ""), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean findStr(String s, List<String> wordDict) {
        if ("".equals(s)) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String var = wordDict.get(i);
            if (s.startsWith(var)) {
                if (findStr(s.replaceFirst(var, ""), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}