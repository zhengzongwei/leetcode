
def shortestCompletingWord(licensePlate: str, words: list) -> str:
    num_list = ['1','2','3','4','5','6','7','8','9','0',' ']
    licensePlate = licensePlate.lower()
    words_dict = {}
    words_list = []
    index = 0
    # 清洗字符
    for i in licensePlate:
        if i in num_list:
            continue

        if i in words_dict:
            words_dict[i] += 1
        else:
            words_dict[i] = 1
        index +=1
    import copy

    for word in words:
        tmp_words_dict = copy.deepcopy(words_dict)
        print(tmp_words_dict,'tmp_words_dict')
        for s in word:
            if s in tmp_words_dict:
                tmp_words_dict[s] -= 1
        flag = True
        for value in tmp_words_dict.values():
            if value == 0:
                flag = False

        if flag:
            # if words_list:
            #     if len(words_list[0])>len(word):
            #         words_list[0] = word
            words_list.append(word)
    if not words_list:
        return words_list
    return words_list[0]
            

licensePlate = "GrC8950"
words = ["measure","other","every","base","according","level","meeting","none","marriage","rest"]

# licensePlate = "1s3 PSt"
# words = ["step", "steps", "stripe", "stepple"]

print(shortestCompletingWord(licensePlate,words))
