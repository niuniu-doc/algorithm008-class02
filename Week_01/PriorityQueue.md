
#### priorityQueue 源代码分析

> 基于JDK1.8

    可以看到 `priorityQueue` 是 `AbstractQueue`的实现、同时也是 `Queue`的实现, 
支持`Queue`的所有基本操作. 同时、它还继承了 `AbstractCollection`, 就同时支持了 
Collection的相关操作. 最主要的功能是实现了`按照优先级来操作元素`.

#### 代码分析
```
    /**
     * Priority queue represented as a balanced binary heap: the two
     * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
     * priority queue is ordered by comparator, or by the elements'
     * natural ordering, if comparator is null: For each node n in the
     * heap and each descendant d of n, n <= d.  The element with the
     * lowest value is in queue[0], assuming the queue is nonempty.
     */
可以看到它其实是一个二叉堆(a balanced binary heap), 它包含了两个子队列:
queue[2*n+1] 和 queue[2*(n+1)], 通过比较器的定义来实现 有序性(优先性), 
默认情况下、按照数据大小排序.

```

##### 构造器
```
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

可以看到、this.queue = new Object[initialCapacity];
即: 它的底层实现还是一个动态数组.
```

##### 数据插入
```
public boolean offer(E e)

有一点、当元素个数大于queue的长度时、会调用 grow() 函数、动态扩容.
grow函数比较有意思: 
int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
当 原queue长度<64时、扩容至原大小的2倍 oldCapacity+(oldCapacity + 2)
>64 时、会认为一次扩容太多会浪费空间, 一次只扩容50% oldCapacity+(oldCapacity >> 2)
然后将数据copy到新的空间里.

下边有一个判断: 当newCapacity 比 MAX_ARRAY_SIZE 还大时、
不扩容、若>MAX_ARRAY_SIZE, 就返回 Integer.MAX_VALUE, 否则 MAX_ARRAY_SIZE
(因为已经无法支持扩容50%了、会造成内存溢出) 
```

##### 扩展功能
```
1. indexOf 返回元素在队列中的索引位置
2. remove 其实最主要的是 shiftDown 和 shiftUp操作, 这个是动态调整优先级的过程
   默认的删除调整中，首先获取顶部下标和最尾部的元素内容，从顶部的位置开始，将尾部元素的内容逐层向下与当前点的左右子节点中较小的那个交换，直到判断元素内容小于或等于左右子节点中的任何一个为止
3. add / offer 主要也是动态调整的过程. 
   从尾部下标的位置开始，将加入的元素逐层与当前点的父节点的内容进行比较并交换，直到满足父节点内容都小于子节点的内容为止。
```





