
def getHint(secret: str, guess: str) -> str:
    	

    a = 0 # 公牛
    b = 0 # 母牛
    for i in range(len(secret)):
        if secret[i]  == guess[i]:
            a +=1

    for j in set(secret):
        b += min(secret.count(j),guess.count(j))
    return str(a) + "A" + str(b-a) + "B"
