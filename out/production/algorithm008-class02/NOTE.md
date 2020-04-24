学习笔记

#### 学习总结
```
1. 数组和链表是基础数据结构，是一切数据结构的基础(一定要多写多练)
2. 成长: 打破了自我限定, 开始了算法学习第一步, 好多次的望而却步、终于开始了,
        而且似乎没有自己想象的难
3. 不足: 练习时间不够、
4. flag: 以后尽量保证每日一题、除非加班到特别晚.
         最初一个题目要写特别久、不严格要求每日一题, 
         可以两日一题(但要保证真的理解)
```

#### 补充作业
```
1. 使用 addFirst / addLast 改写queue代码
   ModifiedDeque.java
2. queue源码分析: queue.md
   priorityQueue源码分析: priorityQueue.md
```

#### 代码review, 题目: 283. 移动零
> 由于时间不足、本周的代码review就转看同一个题目了, 时间充足的话会多看一些~~
>
##### 001
```
学号为: G20200343050198 同学的代码
github地址: https://github.com/huanzhenzhang0923/algorithm008-class02/blob/master/Week_01/MoveZeros.java

代码使用的是 交互位置法, 核心代码如下 :
 for (int i=0;i<nums.length; i++) {
            if(nums[i]!=0){
                int temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                left++;
            }
        }
我认为有一个可以优化的地方 :

若 i == left , 只执行 left++, 不执行交换 是不是就可以了 ?

 if (i != curr) {
      nums[curr] = nums[i]; // 是不是直接将 nums[i] 赋值给 nums[curr]即可 ?
      nums[i] = 0;
 }
 curr ++;

验证结果: 
可以执行通过、但letcode显示执行时间 反而更长...
在 Java 代码中只击败了 14% 的用户、说明应该有更优解...
或者是样本数量的问题, 有可能是 测试用例的数据量太少、测不出差别~~~
```

##### 002
```
学号为 G20200343050044 同学的代码
github地址: https://github.com/Uado1104/algorithm008-class01/blob/master/Week_01/moveZeroes.java

这位同学用的是 两遍循环法, 但是给出了边界条件考虑
if (len < 2) return; 
很值得学习~~

另外, 如果边界判断使用 next 的定义放在边界判断后边是否会更好一些 ?
如果不需要处理的话, 就不用定义变量了. (虽然这点儿可能意义不大...) 
```

##### 003
```
学号为 G20200447010482 同学的代码
github地址: https://github.com/Edward1C/algorithm008-class02/blob/master/Week_01/283.moveZeroes.js

这位同学是js写的代码, 不过跟我的思路是一致的, 
先判断了 当前操作的 index 和 要放入的index是否一致, 一致的话就不再操作,
这样可以少一些交换操作, 逻辑上来说, 时间复杂度会降低.
(毕竟、一个交换操作, 至少要有好几个CPU周期~~~~)

稍有不足的地方也是没有边界判断, 如果数组只有一个元素、或者是空数组, 其实可以直接返回.

```

##### 004
```
学号为 G20200343050244 同学的代码
github地址: https://github.com/lkhavetwocat/algorithm008-class02/blob/master/Week_01/leetcode283_moveZeroes.php

这位同学是php写的代码
优点是: 注释清晰, 有空数组判断、及边界判断
稍有不足的地方:
1. i==j 时可以不用交换
2. 数组长度的判断(count($num))可以放到循环外, 毕竟count函数是可能有一定的消耗
(Java的ArrayList维护了size变量、不记得php是不是维护这个结构了...)
```

##### 005
```
学号为 G20200343050112 同学的代码
github地址: https://github.com/wyc192273/algorithm008-class02/tree/master/Week_01

优点: 代码 和 学习总结都写的特别认真、值得学习. 真是的每日刷题..., 且刷了n道题、佩服佩服~~
小建议: 题目名称可以写到文件名上、这样可能会更好 ?
```

**另外表扬一位同学: G20200343050362**
```
给出了所有题目的解析, 有些还给出了 Java 和 C 两个版本的, 向这位同学学习~~~
好多优秀的同学呀、边膜拜别学习~~

学号为 G20200343050112 同学的代码
几乎每天n题, 希望自己也能多有一点时间来练习~~~~

向优秀的同学学习^.^
```
