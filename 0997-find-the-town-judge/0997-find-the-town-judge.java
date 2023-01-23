class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n-1) {
           return -1;
        }
        int[] arr = new int[n + 1];
        for (int[] a : trust) {
            int q = a[0];
            int w = a[1];
            arr[q]--;
            arr[w]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}