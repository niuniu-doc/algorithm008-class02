

倒数第二周了....


#### 回顾
之前回溯、dfs、bfs这块儿学的不好、今天回去复习了下, 找到点儿感觉了~~~
练习题目 `Queen.java`, `Permute.java`

#### 关键点
```
1. 动态规划和递归或者分治无根本区别, 关键在于有无最优子结构
2. 共性: 找到重复子问题
3. 差异性: 最优子结构、中途可以淘汰次优解
```

#### 不同路径ii的状态转移方程
```java
1. 把有障碍物的点视为不可达，不可达的意思就是没有路径（0条路径）可以到达当前点，这里用dp[i[[j]=0表示不可达。
2. 初始化第一行和第一列，障碍物后面都不可达
3. 填充dp数组，分三种情况：
  1) 上边的点和左边的点都不可达，那么当前点不可达:dp[i][j] = 0
  2) 当前点是障碍物，那么当前点不可达:dp[i][j] = 0
  3) 上边的点或者左边的点可达，那么当前点就可达，路径数等于到上边点的路径数加到左边点的路径数:dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
  上边的点和左边的点都不可达，合并case1、3
  那么当前点还是可以表示为dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
```

#### todo
```
1. KMP还没看明白、需要再多看几遍....
2. 回溯刚刚找到点儿感觉, 需要多练习
3. 树好像找到点儿套路的感觉了
最大的收获, 学会了不再畏惧, 知道这些题目是有规律可循的, 需要做的是、多多练习~~~

```




















