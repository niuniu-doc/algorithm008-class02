package org.example.leetcode.string;

public class P387FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));
        System.out.println(new Solution().firstUniqChar2(s));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            int[] letter = new int[26]; // 存放字符数组
            for (char c : s.toCharArray()) {
                letter[c - 'a'] ++; // 第一次遍历, 将字符放入数组
            }
            for (int i=0; i<s.length(); i++) {
                if (letter[s.charAt(i)-'a'] == 1) return i; // 第i个单词个数为1
            }
            return -1; // 无解
        }

        /**
         * 方法二, 开始位置等于结束位置, 说明只有一个
         */
        public int firstUniqChar2(String s) {
            int index = -1;
            for (char ch = 'a'; ch < 'z'; ch++) {
                int beginIndex = s.indexOf(ch);
                if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                    index = (index == -1 || index > beginIndex) ? beginIndex : index;
;                }
            }
            return index;
        }
    }
}
