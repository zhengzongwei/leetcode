def hIndex(citations) -> int:
    citations.sort(reverse=True)
    flag = 0
    for i in citations:
        if flag < i:
            flag += 1
    return flag


print(hIndex([1,3,1]))
