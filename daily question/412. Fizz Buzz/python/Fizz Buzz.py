# @lc code=start
class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        result = []
        for i in range(1,n):

            if i % 3 == 0 and i % 5 ==0:
                result.append('FizzBuzz')
            elif i % 3 == 0:
                result.append('Fizz')
            elif i % 5 == 0:
                result.append('Buzz')
            else:
                result.append(i)
        return result

