class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int len = n;
            for (int j = 0; j < n; j++) {
                if (nums[j] > queries[i]) {
                    len = j;
                    break;
                }
            }

            ans[i] = len;
        }

        return ans;

    }
}