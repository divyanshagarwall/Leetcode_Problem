class Solution {
    public int minDeletionSize(String[] strs) {
        char[][] arr = new char[strs.length][strs[0].length()];
        int count = strs.length;
        for(int i = 0; i<strs[0].length();i++){
            for(int j = 1; j<strs.length;j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count--;
                    break;
                }
            }
        }
        return strs.length-count;
    }
}