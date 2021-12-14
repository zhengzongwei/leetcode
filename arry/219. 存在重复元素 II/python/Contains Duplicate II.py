
from typing import List


def containsNearbyDuplicate(nums: List, k: int) -> bool:
    ret = False

    arr = []

    for i in range(len(nums)):
        if nums[i] in arr:
            return True
        arr.append(nums[i])

        if len(arr) > k:
            arr.remove(arr[0])

    return ret



nums = [1,2,3,1,2,3]
k =  2
data = containsNearbyDuplicate(nums,k)
print(data)