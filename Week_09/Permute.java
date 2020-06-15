package org.example.labuladong;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
          List<Integer> track = new LinkedList<>();
          backtrack(nums, track);
          return res;
        }

        private void backtrack(int[] nums, List<Integer> track) {
            // terminate
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int e : nums) {
                track.add(e);
                backtrack(nums, track);
                track.remove(e); // 撤销选择
            }
        }
    }
}
