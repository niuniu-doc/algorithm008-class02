package leetcode.editor.cn;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表


import java.util.Arrays;

public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // todo
        String s = "rat", t = "car";
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "ab", t2 = "a";
        System.out.println(solution.isAnagram(s, t));
        System.out.println(solution.isAnagram(s1, t1));
        System.out.println(solution.isAnagram(s2, t2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            /**
             * 方法一、排序, 时间复杂度取决于sort函数实现, 在JDK 1.8中
             * sort 元素个数>3200时、使用计数排序
             * 元素个数 <286 时, 使用普通的快排, 其余情况使用 双轴快排 Dual-Pivot Quicksort
             */

//            char[] str1 = s.toCharArray();
//            char[] str2 = t.toCharArray();
//            Arrays.sort(str1);
//            Arrays.sort(str2);
//
//            return Arrays.equals(str1, str2);

            /**
             * 方法二、hash表法
             * 遍历s中字符, 放入hash表, 遍历t中字符, 从hash表中移除
             * 最后遍历hash表, 若某一位上的字符未被抵消,
             * 则认为两者不是异位字符
             */
//            int[] table = new int[26]; // 初始化hash表
//            for (int i = 0; i<s.length(); i++) {
//                table[s.charAt(i) - 'a']++;
//                table[t.charAt(i) - 'a']--;
//            }
//
//            for (int cnt : table) {
//                if (cnt != 0) return false;
//            }
//
//            return true;

            /**
             * 方法三、先使用计数表计算s中字符, 再遍历t减少计数器中字符数量,
             * 若某个字符的计数器低于0, 则可以认为t中存在一个s中不存在的字符
             * 直接返回false, 否则返回true
             * 因为访问计数器表是固定的时间复杂度 O(n), 所以时间复杂度为 O(n)
             * 空间复杂度 大小不变, 都是int[26], 数据规模增加时, 可以认为是 O(1)的
             */
            int[] table = new int[26];
            int i, len = s.length();
            for (i = 0; i< len; i++) {
                table[s.charAt(i) - 'a'] ++;
            }

            int index;
            for (i = 0; i < len; i++) {
                index = t.charAt(i) - 'a';
                table[index] --; // 递减字符计数器
                if (table[index] < 0) {
                    return false;
                }
            }

            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}