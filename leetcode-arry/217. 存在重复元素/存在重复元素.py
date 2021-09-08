def containsDuplicate(nums)->bool:
    ret = False
    length = len(nums)
    if length != len(set(nums)):
        ret = True
    return ret
