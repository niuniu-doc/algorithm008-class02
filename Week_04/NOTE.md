
#### DFS代码模版
##### 递归写法
```
visited = set()

def dfs(node, visited) :
   if node in visited: #terminator
      return #already visited
   
   visited.add(node)
   
   # process current node here
   ...
   for next_node in node.children():
       if next_node not in visited:
          dfs(next_node, visited) 
    
```

##### 非递归写法
```python
def DFS(self, tree):
    if tree.root is none:
       return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)
    
        prcess(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    # other processing work
```

#### BFS 代码模板
```python
def BFS(graph, start, end):
    visited = set()
    queue = []
    queue.append([start])

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work
```

#### 贪心算法
> 一种在每一步选择中都采用在当前状态下最好或最优(即最有利)的选择, 从而希望导致结果是全局最优的算法
> 与动态规划的不同在于它对每个子问题的解决方案都作出选择, 不能回退;
> 动态规划则会保存以前的运算结果, 并根据以前的结果对当前结果进行选择, 可以回退.

`贪心`: 当前做局部最优化
`回溯`: 能够回退
`动态规划`: 最优判断+回溯

#### 二分查找
##### 二分查找前提
1. 目标函数单调性
2. 存在上下界(bounded)
3. 可通过索引访问

##### 代码模板
```
left, right = 0, len(array)-1
while left <= right:
    mid = (left+right)/2
    if array[mid] == target:
        break or return result # find the target
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1 
```
1. 感觉贪心最难的是思路转换, 貌似都比较巧妙, 看完题解怀疑自己智商的那种...
   可是自己总是想不到, 还是想的比较少吧, 要多思考, 多练习, 多学习优秀题解
2. BFS和DFS 思路基本上没问题了, 看题解的时候却总是觉得特别晕, 需要很久还想不明白,
   Mark下这个点, 回头专项练习, 一定要攻克这一块儿
   
这两个月的第一目标就是数据结构和算法, 一定要把基础的学完

有时候会觉得自己遇到坎儿了、想要放弃、或者告诉自己没时间, 但是最终还是说服了自己克服这种
懒惰的心理, 借用极客时间上的一句话、怕什么真理无穷, 进一寸有一寸的欢喜
哪个专栏的早已不记得、却多次阻止了自己想要退却的心, 给自己加油~~~