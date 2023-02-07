class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int slow=0,max=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            slow = Math.max(slow,map.getOrDefault(c,-1)+1);
            map.put(c,i);
            max = Math.max(max,i-slow+1);
        }
        return max;
    }
}