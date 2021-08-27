class Solution {
    /**
     * [1] rows:1
     * [1,1] rows:2
     * [1,2,1] rows:3
     * [1,3,3,1] rows:4
     * [1,4,6,4,1] rows:5
     * [1,5,10,10,5,1] rows:6
     * [1,6,15,20,15,6,1] rows 7
     * [1,7,21,35,35,21,7,1] rows 8
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(0, Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> before = result.get(i - 1);
            List<Integer> current = new ArrayList<>(i + 1);

            for (int j = 0; j < i + 1; j++) {
                int left = j - 1 < 0 ? 0 : before.get(j - 1);
                int right = j >= before.size() ? 0 : before.get(j);
                current.add(j, left + right);
            }

            result.add(i, current);
        }
        return result.get(rowIndex);
    }
}

class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(0, 1);
        for (int i = 1; i < rowIndex + 1; i++) {
            result.add(0);
            for (int j = i; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}