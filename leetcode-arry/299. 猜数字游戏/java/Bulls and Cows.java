class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        // PLAN 1
//        char[] sArr = secret.toCharArray();
//        char[] gArr = guess.toCharArray();
//
//        for (int i = 0; i < gArr.length; i++) {
//            if (gArr[i] == sArr[i]) {
//                bulls++;
//                sArr[i] = 'F';
//            } else {
//                for (int j = 0; j < sArr.length; j++) {
//                    if( gArr[i] == sArr[j] && sArr[j] != gArr[j] ) {
//                        cows++;
//                        sArr[j] = 'F';
//                        break;
//                    }
//                }
//            }
//            gArr[i] = 'F';
//        }

        // PLAN 2
        int[] mnt = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else {
                if(++mnt[secret.charAt(i) - '0'] <= 0) {
                    cows++;
                }
                if(--mnt[guess.charAt(i) - '0'] >= 0) {
                    cows++;
                }
            }
        }

        StringBuilder build = new StringBuilder();
        return build.append(bulls).append("A").append(cows).append("B").toString();
    }
}