
from typing import Counter, List


def majorityElement(nums: List[int]) -> int:

    count_num = len(nums) / 2
    total_count = 0

    for i in range(len(nums)):
        index = nums[i]
        count = 0
        for j in range(i, len(nums)):
            if index == nums[j]:
                count += 1
        if count > count_num:
            if total_count != 0:
                if count > total_count:

                    total_count = count
                    data = index

            total_count = count
            data = index

    return data


print(majorityElement([3, 3, 4]))
