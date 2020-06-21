
##### 递归
```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level_1, newParam);

    // restore current status
}
```

##### dp顺推模板
```python
function DP():
    dp = [][] #二维情况
    for i=0..M {
        for j=0..N{
            dp[i][j]=_function(dp[i'][j'])
        }
    }

return dp[M][N]
```


##### 回溯
```
result = []
def trackback(路径, 选择列表)
    if 满足结束条件:
       result.add(路径)
       return
    for 选择 in 选择路径
       做选择(将该选择从选择列表移除, 加入路径)
       trackback(路径, 选择列表)
       撤销选择(将该选择从路径移除(路径.remove), 加入选择列表)

路径: 记录已作出的选择
选择列表: 可选范围
结束条件: 终止条件
```


#### DFS代码模板
##### 递归写法
```
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 


	visited.add(node) 


	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

##### 非递归写法-Java
```
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
        # 生成相关的节点
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

#### BFS
```
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
	...
```


#### 树的遍历
##### 二叉树遍历
```java 
void traverse(TreeNode root) {
    if (root == null) return;
    traverse(root.left);
    traverse(root.right);
}
```
##### N叉树遍历
```java
void traverse(TreeNode root) {
    if (root == null) return;
    for (TreeNode child : root.children) {
        traverse(child);
    }
}
```


























