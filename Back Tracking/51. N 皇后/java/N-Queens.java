class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n == 1) {
            List<String> v1 = new ArrayList<>();
            v1.add("Q");
            List<List<String>> v2 = new ArrayList<>();
            v2.add(v1);
            return v2;
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 当前行皇后放置情况
            String statusQueen = obtainRowQueen(n, i);
            // 记录放置位置
            int[] location = new int[n];
            location[0] = i;
            // 进行遍历
            LinkedList<LinkedList<String>> data = nexRowQueen(location, 1, n);
            if (data.size() > 0) {
                data.forEach(d -> {
                    d.addFirst(statusQueen);
                });
                result.addAll(data);
            }
        }
        return result;
    }

    private LinkedList<LinkedList<String>> nexRowQueen(int[] location, int current, int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 判断是否可以安放皇后
            if (isPushQueen(current, i, location)) {
                // 记录位置
                location[current] = i;
                // 当前皇后情况
                String statusQueen = obtainRowQueen(n, i);
                // 如果还有下一行继续遍历
                LinkedList<LinkedList<String>> data = new LinkedList<>();
                if (current < n) {
                    data = nexRowQueen(location, current + 1, n);
                }

                if (current == n - 1) {
                    // 如果是最后一行
                    LinkedList<String> v2 = new LinkedList<>();
                    v2.add(statusQueen);
                    data.add(v2);
                    result.addAll(data);
                } else {
                    if (data.size() > 0) {
                        data.forEach(d -> d.addFirst(statusQueen));
                        result.addAll(data);
                    }
                }
            }
        }
        return result;
    }

    public String obtainRowQueen(int length, int index) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == index) {
                tmp.append("Q");
            } else {
                tmp.append(".");
            }
        }
        return tmp.toString();
    }

    private boolean isPushQueen(int row, int column, int[] location) {
        for (int i = 0; i < row; i++) {
            int queen = location[i];
            // 判断是否在同一列
            if (queen == column) {
                return false;
            }
            // 判断是否在同一个斜列
            if (queen + (row - i) == column || queen - (row - i) == column) {
                return false;
            }
        }
        return true;
    }
}