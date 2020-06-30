package org.example.leetcode.string;

public class P541ReverseStr {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(new Solution().reverseStr(s, k));
    }

    static class Solution {
        public String reverseStr(String s, int k) {
            /**
             * 给定字符串s, 翻转每2k个字符的前k个字符
             * 若剩余字符<k个、全部翻转, 若 ＞k, <2k,则翻转前k个, 剩余不变
             */
            char[] a = s.toCharArray();
            for (int start=0; start<s.length(); start+=2*k) {
                int i=start, j=Math.min(start+k-1, a.length-1); // 计算翻转的起止位置
                while (i<j) {
                    // 交换 a[i] 和 a[j]
                    char tmp=a[i];
                    a[i++]=a[j];
                    a[j--]=tmp;
                }
            }
            return String.valueOf(a);
        }
    }
}
