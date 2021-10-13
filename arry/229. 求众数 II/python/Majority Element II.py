class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # 指定大小
        result = []
        num = len(nums)/3
        ret = {}
        for i in nums:
            # 计算元素在数组中的个数
            if i in ret:
                ret[i] += 1
            else:
                ret[i] = 1
        
        for i in ret:
            if ret[i] > num:
                result.append(i)

        return result