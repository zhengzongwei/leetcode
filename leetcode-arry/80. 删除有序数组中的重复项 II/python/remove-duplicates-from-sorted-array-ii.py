class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        count = 0
        for right in range(len(nums)):
            if count < 2 or nums[count - 2] != nums[right]:
                nums[count] = nums[right]
                count += 1
        return count