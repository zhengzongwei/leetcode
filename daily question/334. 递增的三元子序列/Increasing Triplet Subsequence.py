
# TODO 解决测试用例超时问题
def increasingTriplet(nums: list[int]) -> bool:
    flag = False
    if len(nums) < 3:
        return flag

    for i in range(len(nums)-2):
        for j in range(i,len(nums)-1):
            for k in range(j,len(nums)):
                if i<j<k and nums[i]<nums[j]<nums[k]:
                    flag = True
                    break

    return flag
