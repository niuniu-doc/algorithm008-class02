package org.example.leetcode;

public class P547朋友圈 {
    public class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            UF uf = new UF(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (M[i][j] == 1)
                        uf.union(i, j);
                }
            }

            return uf.count();
        }
    }
}
