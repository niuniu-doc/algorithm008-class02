
#### Java HashSet 源代码分析

> HashSet 是 Set接口其中一种实现, 比较经典的实现还包括 TreeSet.
从类描述、我们可以知道, hashSet 是依赖hashMap来实现的(backed by HashMap), 它并不保证迭代的顺序, 通常也不保证每次迭代都是统一顺序. HashSet 允许null元素的存在. 对于add / remove / contains / size等基本操作, 可以保证常量级时间复杂度, 具体时间复杂度与Set包含的元素个数及总的容量大小有关, 保持较低的负载因子可以保证set的效率.
HashSet 是非线程安全的. 如果set在创建后被修改、会抛出异常而不是保留调用时的不确定性.

##### 构造函数
```
HashSet保留了5个构造函数
1) public HashSet() {
        map = new HashMap<>();
    }
    使用默认参数构造一个空的set(容量:16, 负载因子 0.75)
    
2) public HashSet(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }
    使用集合初始化HashSet, 容量取max(16, size/0.75) 若初始元素个数按照0.75的负载来算 > 16, 则默认容量按照这个值计算, 否则默认容量为 16

3)  public HashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }
   指定初始化容量大小和负载因子

4) public HashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }
   只指定初始容量、不指定负载因子

5) HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
    boolean dummy 其实没有任何意义, 只是为了区分底层实现是使用hashMap, 还是LinkedHashMap, dummy 无实际意义的
    

#### 方法解读:
public Iterator<E> iterator; 返回一个HashSet的迭代器, 不保证元素读取是有序的.
public int size(); 返回元素个数
public boolean isEmpty(); 返回集合是否为空
public boolean contains(Object o); 判断集合中是否包含某个特定的元素, 包括 null
public boolean add(E e); 往集合中添加一个元素, 它其实是往HashMap中添加一个kv对, key是元素e, Value 指向一个特殊值 PRESENT(空的object、无实际意义)
public boolean remove(Object o); 从集合中移出元素, 返回 true/false
public void clear(); 清空整个set, 直接调用的是 HashMap.clear() 方法
private Object clone(); clone 整个hashset, 注意这里是浅copy
readObject()和writeObject() 则是在反射时调用的, 调用链比较长、有兴趣的同学可以参考下:
https://blog.csdn.net/u014653197/article/details/78114041 
```

#### 实现原理
```
HashSet 内部是使用HashMap实现的, 内部有一个HashMap实例变量，相当于一个只有键的HashMap, 键不允许重复
```