class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        StringBuilder s = new StringBuilder();
        boolean[][] vis = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, vis, word, r, c, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] vis, String word, int row, int col, int i) {
        if(board[row][col] != word.charAt(i)) return false;

        if (i == word.length() -1) return true;

        vis[row][col] = true;

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol]) {
                if (dfs(board, vis, word, newRow, newCol, i + 1)) {
                    return true;
                }
            }
        }

        vis[row][col] = false;
        return false;
    }
}