class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int interval = timeSeries[i + 1] - timeSeries[i];
            if (interval >= duration) {
                count += duration;
            } else {
                count += interval;
            }
        }
        return count + duration;
    }
}