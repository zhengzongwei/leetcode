class Solution {
    // 时间复杂度 O(n)
    public int hIndex(int[] citations) {
        // h 指数
        int result = 0;
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            // n篇论文中，总共有h篇论文被引用了至少h次 （就是数组下标）。且其余的 n - h篇论文每篇不超过h次
            // 0 3 ｜ 3 5 6
            // n -h    h
            int h = length - i;
            // h <= citations[i] 当前论文引用次数至少h次
            // length - h > 0 && h <= citations[i - 1] 且其余 n - h 篇论文不超过h次
            // example [0]、[1]、[3,0,6,1,5]
            if (h <= citations[i] &&
                    ((length - h > 0 && h >= citations[i - 1]) || length - h == 0)) {
                result = h;
            }
        }
        return result;
    }
}

class Solution2 {
    // 时间复杂度 O(logN)
    // 对数时间复杂度,二分查找
    public int hIndex(int[] citations) {

    }
}