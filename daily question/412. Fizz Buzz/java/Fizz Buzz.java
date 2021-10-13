// 日期：2021.10.13
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> data = new ArrayList();
        for(int i = 1; i <= n ;i++) {
            boolean flag_3 = i%3 == 0;
            boolean flag_5 = i%5 == 0;

            if(!flag_3 && !flag_5) {
                data.add(String.valueOf(i));
            }
            if(flag_3 && flag_5) {
                data.add("FizzBuzz");
            }
            if(flag_3 && !flag_5) {
                data.add("Fizz");
            }
            if(!flag_3 && flag_5) {
                data.add("Buzz");
            }
        }

        return data;
    }
}