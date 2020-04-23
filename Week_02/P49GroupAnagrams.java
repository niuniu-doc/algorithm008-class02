package leetcode.editor.cn;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


import java.util.*;

public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // todo
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // check param
            if (strs.length == 0) return new ArrayList<>();

            /**
             * 方法一: 排序数组分组
             * 当且仅当排序字符串相等时、两个字符串为字母异位词
             */
//            Map<String, List<String>> map = new HashMap<>();
//
//            for (String s : strs) {
//                char[] chars = s.toCharArray(); // 转化为字符数组
//                Arrays.sort(chars); // 将字符数组排序
//                String key = String.valueOf(chars); // 计算map中的key
//                if (!map.containsKey(key)) map.put(key, new ArrayList<>()); // 将key放入map, 暂时放一个空的list
//                map.get(key).add(s); // 将字符串放入map
//            }
//
//            return new ArrayList<>(map.values());

            /**
             * 方法二、统计字符出现次数
             *
             */
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int[] arr = new int[26];
                for (int i = 0;  i < s.length(); i++) {
                    arr[s.charAt(i) - 'a']++;
                }

                String key = Arrays.toString(arr);
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }

            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}