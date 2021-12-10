
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
        print(word)
        tmp_words_dict = copy.deepcopy(words_dict)
        tmp = []
        for s in word:
            print(tmp,'tmp')

            if s in tmp and  s in tmp_words_dict:
                if tmp_words_dict[s] > 0:
                    tmp_words_dict[s] -= 1
                else:
                    tmp_words_dict[s] = 0
                continue
            print(tmp_words_dict,'tmp_words_dicttmp_words_dicttmp_words_dict')
            if s in tmp_words_dict:
                if tmp_words_dict[s]>0:
                    tmp_words_dict[s] -= 1
                else:
                    tmp_words_dict[s] = 0
            if s not in tmp:
                tmp.append(s)

        print(tmp_words_dict,'tmp_words_dict')
        flag = True
        for value in tmp_words_dict.values():
            print(value,'valuevalue')
            if value != 0:
                flag = False

        if flag:
            if words_list:
                if len(words_list[0])>len(word):
                    words_list[0] = word
            words_list.append(word)
    # print(words_list,'words_list')
    if not words_list:
        return words_list
    return words_list[0]



licensePlate = "GrC8950"
words = ["measure","other","every","base","according","level","meeting","none","marriage","rest"]

# words = ["herself","matter","know","six","degree","scientist","fall","beyond","husband","character"]

# licensePlate = "1s3 PSt"
# words = ["step", "steps", "stripe", "stepple"]

print(shortestCompletingWord(licensePlate,words))
