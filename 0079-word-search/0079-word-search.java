class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int k) {
        if (k == word.length()) return true;                        // all letters matched
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(k)) return false;            // wrong letter (or already used)

        char saved = board[r][c];
        board[r][c] = '#';                                          // choose: mark visited

        boolean found = dfs(board, word, r + 1, c, k + 1)
                     || dfs(board, word, r - 1, c, k + 1)
                     || dfs(board, word, r, c + 1, k + 1)
                     || dfs(board, word, r, c - 1, k + 1);

        board[r][c] = saved;                                        // un-choose: restore
        return found;
    }
}