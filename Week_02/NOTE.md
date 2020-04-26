

#### 学习总结
1. 发现redis是数据结构的一个很好的工业级的实现, 可以结合着看, 原来看不明白的一些设计会觉得比较清晰了
   eg. 设计SDS而不是使用 C原生 String, 是为了降低 字符串长度统计的时间复杂度 O(N) -> O(1)
   同时 len 属性的标记、使得 SDS是二进制安全的
   free属性的存在是为了内存预分配 和 惰性释放
 参考redis设计实现, 写了一些学习笔记:
   [SDS](https://www.jianshu.com/p/d7146cc351b3) 
   [链表](https://www.jianshu.com/p/7dd8ba32f3bf)
   [字典](https://www.jianshu.com/p/99378d167462)

2. 感觉比较赞同老师的五遍刷题法了、之前比较焦虑, 每次匆匆忙忙、总觉得写过了就会了、其实是:
   写过了就忘了..., 现在加班比较严重、每天下班刷一道题, 晚上睡觉的时候想想, 第二天早上起来再想想
   感觉是那么回事儿了, 开始不那么浮躁了, 可能这才是最大的收获吧、要说刷了多少算法题或者算法成长了
   多少, 好像还真没有^.^, 不过不着急吧、一点点的进步就好, 毕竟不是在读书、没有大把的时间了~~~
   
3. 希望随着训练营的学习、能学会刷题的技巧、然后把redis的实现也能看一遍、有些成长就是值得的了

     
#### Java源代码分析
```
HashMap 源代码分析: HashMap.md
HashSet 源代码分析: HashSet.md
```


#### 代码review
##### 001
```
学号: G20200343050344
github: https://github.com/chenchuxin/algorithm008-class02/tree/master/Week_02

作业写的很不错、题目的数量比较多、代码质量也很高、每个都给出了多种解法, 值得赞赏~~~
```

##### 002
```
学号: G20200343050186
github: https://github.com/mengbaodexiaocao/algorithm008-class02/tree/master/Week_02

每个题目都做的极认真、写出来多种题解, 并且给出了较清晰的注释, 特别认真、值得学习~~~
```

##### 003
```
学号: G20200343050074
github: https://github.com/dokcer-oo/algorithm008-class02/tree/master/Week_02/leetcode

跟我一样题目写的有点儿少呢~, 一起加油吧~~, 争取能有多些时间多写一些习题^.^
```


##### 004
```
学号: G20200343050074
github: https://github.com/WhatAKitty/algorithm008-class02/tree/master/Week_02

注释写出了自己的完整思路、是按照老师教的4步曲来的、这点值得学习、题解也写的很不错~~
```

##### 005
```
学号: G20200343050246
github: https://github.com/CongYiMing/algorithm008-class02/tree/master/Week_02

代码写的比较精炼, 如果能拆分成多个文件可能更方便阅读呢, 小小建议~~~
```