
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

























