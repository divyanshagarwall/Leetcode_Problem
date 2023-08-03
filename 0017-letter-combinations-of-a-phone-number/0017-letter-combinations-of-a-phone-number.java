class Solution {
    public List<String> ans = new ArrayList<>();

    public char[] get(int n) {
        if (n == 2) {
            return new char[]{'a', 'b', 'c'};
        } else if (n == 3) {
            return new char[]{'d', 'e', 'f'};
        } else if (n == 4) {
            return new char[]{'g', 'h', 'i'};
        } else if (n == 5) {
            return new char[]{'j', 'k', 'l'};
        } else if (n == 6) {
            return new char[]{'m', 'n', 'o'};
        } else if (n == 7) {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (n == 8) {
            return new char[]{'t', 'u', 'v'};
        } else {
            return new char[]{'w', 'x', 'y', 'z'};
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        func(chars, 0, stringBuilder);
        return ans;
    }

    private void func(char[] chars, int i, StringBuilder stringBuilder) {
        if (i == chars.length) {
            ans.add(stringBuilder.toString());
            return;
        }
        Integer value = chars[i] -'0';
        System.out.println(value);
        char[] allowedValues = get(value);
        for (char ch : allowedValues) {
            StringBuilder newStringBuilder = new StringBuilder(stringBuilder);
            newStringBuilder.append(ch);
            func(chars, i + 1, newStringBuilder);
        }
    }
}