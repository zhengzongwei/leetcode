class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            // 计算合适的出发节点
            if (gas[i] >= cost[i] && go(gas, cost, gas[i] - cost[i], i + 1, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean go(int[] gas, int[] cost, int fuel, int start, int target) {
        if (start >= gas.length) {
            start = 0;
        }
        int g = gas[start];
        int c = cost[start];
        fuel = fuel + g - c;

        if (fuel < 0) {
            return false;
        } else if (start == target) {
            return true;
        } else {
            return go(gas, cost, fuel, start + 1, target);
        }
    }
}