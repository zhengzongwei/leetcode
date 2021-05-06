
# 采用双指针

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        sum = 0
        for i in nums:
            if i != val:
                nums[sum] = i
                sum +=1
        return sum