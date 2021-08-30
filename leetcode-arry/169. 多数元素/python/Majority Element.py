
from typing import Counter, List


def majorityElement(nums: List[int]) -> int:

    # 便利获取最多的重复元素，参数时间过长以后会导致超时
    # 优化 使用列表来存储相关重复的元素，第二次在去最多的重复元素
    # count_num = len(nums) / 2
    # total_count = 0

    # for i in range(len(nums)):
    #     index = nums[i]
    #     count = 0
    #     for j in range(i, len(nums)):
    #         if index == nums[j]:
    #             count += 1
    #     if count > count_num:
    #         if total_count != 0:
    #             if count > total_count:

    #                 total_count = count
    #                 data = index

    #         total_count = count
    #         data = index

    # return data

    count_num = len(nums) / 2
    count = {}  # k,v = i count
    for i in nums:
        if i in count:
            count[i] += 1
        else:
            count[i] = 1
    value = count_num
    data = 0
    for k, v in count.items():
        if v > value:
            value = v
            data = k

    return data


print(majorityElement([3, 3, 4]))
