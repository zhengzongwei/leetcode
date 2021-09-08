class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        new_nums = nums
        nums= []
        for i in range(len(new_nums)-k,len(new_nums)):
            nums.append(new_nums[i])
        for i in range(0,len(new_nums)-k):
            nums.append(new_nums[i])