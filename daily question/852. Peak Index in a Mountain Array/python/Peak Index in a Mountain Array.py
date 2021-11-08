class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        index= arr.index(max(arr))
        return index