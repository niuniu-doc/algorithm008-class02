

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