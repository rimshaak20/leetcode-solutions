class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, row, col, d)) {
                            board[row][col] = d;               // choose
                            if (solve(board)) return true;     // explore
                            board[row][col] = '.';             // un-choose
                        }
                    }
                    return false;   // no digit fits this cell, so backtrack
                }
            }
        }
        return true;                // no empty cell left, so the board is solved
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d) return false;   // same row
            if (board[i][col] == d) return false;   // same column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == d) return false;  // same 3x3 box
        }
        return true;
    }
}