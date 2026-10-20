class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];

        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans,
                       boolean[] leftRow, boolean[] lowerDiagonal,
                       boolean[] upperDiagonal, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, leftRow, lowerDiagonal, upperDiagonal, n)) {
                board[row][col] = 'Q';                          // choose
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;

                solve(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);

                board[row][col] = '.';                          // un-choose
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, boolean[] leftRow,
                           boolean[] lowerDiagonal, boolean[] upperDiagonal, int n) {
        return !leftRow[row]
            && !lowerDiagonal[row + col]
            && !upperDiagonal[n - 1 + col - row];
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] r : board) res.add(new String(r));
        return res;
    }
}