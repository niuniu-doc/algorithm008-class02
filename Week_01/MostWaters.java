package org.example.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostWaters {
    public static void main(String[] args) {
        Solution solution = new MostWaters().new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.mostWaters(height));
    }

    class Solution {
        public int mostWaters(int[] height) {
            /**
             * 双指针法:
             * 变量 i, j, 最初将 i 固定在最开始处 index=0, j 固定在最末尾处 index=height.length-1
             * 1. i >= j break;
             * 2. height[i] > height[j] j--
             *    height[i] < height[j] i++
             * 直到 i, j 相邻, 此时i, j 的值 即为得到 maxArea 的 i,j 值
             *
             * 看了题解、更优雅一些,
             * 直接没有初始赋值, 使用的是 初始化 res=0;
             * maxArea = height[i] < height[j] ? Math.max(res, height[i++]*(j-i))
             *                  : Math.max(res, height[j--]*(j-i));
             * 第一次循环, i=0, height[i++]*(j-i) 会先进行 height[i]*(j-i)的运算、再执行j-1
             * 需要先赋值、再迭代...
             */
            int i = 0, j = height.length - 1;
            //  int maxArea =  Math.min(height[0], height[j]) * (height.length-1);
            int res = 0;
            while (i < j) {
                /** ======= Myself begin =======
                 //                if (height[i] > height[j]) {
                 //                    maxArea = Math.max(maxArea, Math.min(height[i], height[--j]) * (j-i));
                 //                } else {
                 //                    maxArea = Math.max(maxArea, Math.min(height[++i], height[j]) * (j-i));
                 //                }
                 //                 return maxArea;
                 *  ======= Myself end =======
                 **/
                /**
                 * 题解答案 begin -========
                 * 此次 注释掉的部分是看完题解自己写的、j--, i++ 搞错了、记录下~~~
                 * height[i++] * (j-i) 执行如下:
                 * height[i]; i = i+1; height[i] * height(j-(i+1))
                 *
                 * (j-i) * height[i++] 执行如下
                 * (j-i) * height[i]; i=i+1;
                 */
                if ( height[i] < height[j])  {
                    res = Math.max(res, (j-i) * height[i++]);
//                    res = Math.max(res, height[i++] * (j-i));
                } else {
                    res = Math.max(res, (j-i) * height[j--]);
//                    res = Math.max(res, height[j--] * (j-i));
                }
                /**
                 * 题解答案 end -========
                 */

            }
            return res;
        }
    }
}
