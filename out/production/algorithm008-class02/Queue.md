
#### Queue源代码分析

> 基于JDK 1.8

  首先, 它是一个`interface`, 这就意味着, 它可以被实现, 作为工业级`队列`, 它可以支持所有队列该有的操作:
`add`, `offer`, `remove`, `pool`, `Element`, 比较经典的实现类包括:
`LinkedBlockingQueue`, `PriorityBlockingQueue`, `ConcurrentQueue`, `ArrayBlockingQueue`等;

##### queue实现
底层数据实现有`数组`和`链表`两种方式, 在Queue的名字中有比较好的体现, 
eg.  `ArrayBlockingQueue` 我们可以知道它是基于数组实现的, 对应有基于链表实现的 `LonkedBlockedQueue`

也有实现比较复杂的 `ProrityQueue`, 为了实现高效的插入和查找, 底层可以有多种数据实现.

##### 方法简析

**boolean add(E e);**
```
    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e);
可以看到: 它是向队列中插入元素, 并返回是否插入成功, 
若入参类型有误 或者 视图插入一个不支持null元素的队列中 插入null元素、或者 不满足队列限制 
都会在插入时抛出对应的异常信息
```

**boolean offer(E e)**
```
    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     */ 
可以看到、offer与add的作用一致、但 preferable to add, 也就是: 在有长度限制的队列里, 
使用 offer 在长度超限时会返回 false, 而使用 add、则会抛出异常, flase 更方便程序处理一些
```

**E remove();**
**E poll();**
```
    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
从队列的头部返回元素, 与poll的差别在于 队列为空时的处理:
remove 会抛出异常, poll只返回空指针.
```

**E element();**
**E peek();**
```
    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
这两个方法都是只获取元素, 并不弹出.
element 在queue为空时、会抛出异常、peek则只返回空指针.
```

