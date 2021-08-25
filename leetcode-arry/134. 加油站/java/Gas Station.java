class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 计算总和是否满足
        int gasSum = 0;
        int costSum = 0;
        List<Integer> location = new LinkedList<>();
        for (int i = 0; i < gas.length; i++) {
            // 计算合适的出发节点
            if (gas[i] >= cost[i]) {
                location.add(i);
            }
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum || location.size() == 0) return -1;

        for (Integer l : location) {
            if (go(gas, cost, gas[l] - cost[l], l + 1, l)) {
                return l;
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