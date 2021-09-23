package main

import "sort"

func main() {
	coinChange([]int{1, 2, 5}, 10)
}
// 动态规划 背包问题
func coinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}

	dp := make([]int, amount+1)
	sort.Ints(coins)
	for i := 1; i < len(dp); i++ {
		min := 1 << 32

		for c := 0; c < len(coins) && coins[c] <= i; c++ {
			val := dp[i-coins[c]] + 1
			if val > 0 && val < min {
				min = val
			}
		}

		if min == 1 << 32 {
			dp[i] = -1
		} else {
			dp[i] = min
		}
	}
	return dp[amount]
}
