def containsDuplicate(nums)->bool:
    ret = False
    # 解法一 直接利用集合去重的特性比对数组长度
    # ret = False
    # length = len(nums)
    # if length != len(set(nums)):
    #     ret = True

    # 解法二 排序比较相邻的两个元素是否相等
    nums.sort()
    for i in range(len(nums)-1):
        if nums[i]== nums[i+1]:
            ret = True
    return ret
