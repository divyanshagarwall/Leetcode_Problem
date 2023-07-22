public class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = {
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };
        double[][] prevDp = new double[n][n];
        double[][] currDp = new double[n][n];
        prevDp[row][column] = 1;
        for (int moves = 1; moves <= k; moves++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    currDp[i][j] = 0;
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            currDp[i][j] += prevDp[prevI][prevJ] / 8;
                        }
                    }
                }
            }
            double[][] temp = prevDp;
            prevDp = currDp;
            currDp = temp;
        }
        double totalProbability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += prevDp[i][j];
            }
        }
        return totalProbability;
    }
}