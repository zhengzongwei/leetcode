class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        return "";
    }
}

class Solution2 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase().trim();
        int patternMax = Integer.MIN_VALUE;
        int lenMin = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String var = words[i];
            int len = var.length();
            HashSet<String> hash = new HashSet<>();
            boolean permissible = false;

            for (int j = 0; j < licensePlate.length(); j++) {
                String t = String.valueOf(licensePlate.charAt(j));
                boolean b1 = hash.contains(t);
                boolean b2 = var.contains(t);
                if (b1 && !b2) {
                    permissible = false;
                    break;
                }

                if (b2) {
                    len--;
                    var = var.replaceFirst(t, "");
                    hash.add(t);
                    permissible = true;
                }
            }
            if (permissible) {
                if (hash.size() > patternMax) {
                    patternMax = hash.size();
                    lenMin = len;
                    result = words[i];
                } else if (hash.size() == patternMax && len < lenMin) {
                    lenMin = len;
                    result = words[i];
                }
            }
        }

        return result;
    }
}