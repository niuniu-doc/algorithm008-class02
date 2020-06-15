package org.example.labuladong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Queen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().solveNQueens(n));
    }

    static class Solution{
        List<List<String>> res = new LinkedList<>();
        public List<List<String>> solveNQueens(int n) {
            if (n == 0) return null;
            // init
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtrack(board, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            // terminate
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }

            int cols = board.length;
            for (int col = 0; col < cols;  col++) {
                if (!isVaild(board, row, col)) continue; // 跳过非法值

                board[row][col] = 'Q';
                backtrack(board, row+1);
                board[row][col] = '.';
            }
        }

        private boolean isVaild(char[][] board, int row, int col) {
            int cols = board.length;
            for (char[] chars : board)
                if (chars[col] == 'Q') return false; // check col
            for (int i=row-1, j=col-1; i>=0&&j>=0; i--,j--)
                if (board[i][j] == 'Q') return false; // check upleft
            for (int i=row-1, j=col+1;i>=0&&j<cols; i--,j++)
                if (board[i][j] == 'Q') return false; // check upright
            return true;
        }

        private List<String> charToString(char[][] board) {
            List<String> res = new LinkedList<>();
            for (char[] chars : board) {
                res.add(String.valueOf(chars));
            }
            return res;
        }
    }
}
