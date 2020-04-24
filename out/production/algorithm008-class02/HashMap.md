
#### HashMap源代码分析

> HashMap 实现了Map接口, 扩展了Collections但没定义新的方法
> JDK1.8 之前是数组+链表, 当HashMap中有大量元素放在同一个桶中时、会有大量冲突, 变量效率下降. JDK1.8 引入红黑树(查找时间复杂度 O(logn))

#### 实现原理
##### 内部组成
```
主要的实例变量
static final int DEFAULT_INITIAL_CAPACITY; 定义默认hashMap的容量
static final float DEFAULT_LOAD_FACTOR; 定义默认hash表的负载因子
static final int TREEIFY_THRESHOLD; 定义单个桶中list结构转化为tree结构的最小接点数阈值
static final int UNTREEIFY_THRESHOLD; 定义单个桶中tree结构转化为list结构的最大节点数阈值
static final int MIN_TREEIFY_CAPACITY; 定义桶内元素转化为tree结构的最小容量. 当capacity小于该值64时、会先进行扩容, 大于该值时、才会转化为树形结构.
```

#### 主要方法分析
```
final void treeifyBin(Node[] tab, int hash); JDK8新增、将链表节点替换为红黑树节点(树形化)

它做了两件事:
1) 判断元素个数, 确定是扩容还是树形化
2) 若树形化, 则生成树结构
   遍历元素, 创建相同个数的树形节点, 复制内容、建立联系
   让桶中第一个元素指向新建的树头节点, 替换链表为红黑树


public V put(K key, V value); 向HashMap中添加元素
/**
 * If the map previously contained a mapping for the key, the old
 * value is replaced
 */
 若key已经存在、value值会被覆盖. 
 底层调用 putTreeVal进行添加操作. 会进行下边的操作:
 1) 从根节点开始遍历当前红黑树的元素p, 对比n和p的hash值
 2) 若hash值相等、且键也相等、就判断为元素已存在
 3) 若hash值就通过其它信息, 比如引用地址来给个大概的比较结果, 只保证大概平衡即可
 4) 最后得到hash值比较结果后, 比如当前节点p还没有左孩子汇总右孩子时才插入, 否则进入循环
 5) 插入元素后进行红黑树平衡调整、保证大概平衡
 
 public V get(Object key); 查找元素
 调用的是 getNode方法, 使用 (n-1)&hash 得到key所在桶的头节点, 若头节点恰好是红黑树节点, 就调用红黑树节点的 getTreeNode、否则就遍历链表节点.
 查找时会对比节点的hash值和要查找的hash值相等、就会判断key是否相等、相等就直接返回, 不相等就继续查找.
 
```