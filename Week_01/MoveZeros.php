<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        if (empty($nums)) {
            return;
        }
        //声明慢指针
        $j = 0;
        //移动快指针
        $len = count($nums);
        for ($i = 0; $i < $len; $i++) {
            //快指针指向非零元素时才需要进行交换
            if ($nums[$i] != 0) {
                //考虑边界值，当第一个参数是非零时，不用交换
                if ($i == 0 || $i == $j) {
                    $j++;
                    continue;
                }
                //交换快慢指针的值，并移动慢指针
                $tmp = $nums[$i];
                $nums[$i] = $nums[$j];
                $nums[$j++] = $tmp;
            }
        }
    }
}