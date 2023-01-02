class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        boolean l = false;
        for (int i = word.length()-1; i >= 0; i--) {
            if (word.charAt(i) < 'a') {
                if (l && i != 0) return false;
                cnt++;
            } else {
                l = true;
                if (cnt > 0) {
                    return false;
                }
            }
        }
        
        return true;

    }
}