class Solution {
    public int findKthPositive(int[] arr, int k) {
    int n = 1;
    int th = k;

    for (int i = 0; i < arr.length; ++n) {
      if (arr[i] == n) {
        i++;
      } else {
        if (--th == 0)
          return n;
      }
    }

    return n + (th - 1);
  }
}