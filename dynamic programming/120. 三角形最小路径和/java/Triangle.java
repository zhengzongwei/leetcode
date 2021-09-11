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