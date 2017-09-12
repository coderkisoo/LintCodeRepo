package lintcode;

/**
 * Created by kangqizhou on 2017/9/12.
 */

/**
 * 计算尾部的零。
 * 思路：
 * 一个n的阶乘中0的个数，与5的倍数的个数有关。
 * 5的非5数呗就是一个0
 * 5的5倍数就是两个0
 * 以此类推
 * 再进行简化后可知，一个n/5 就是当前阶乘中0的个数
 */
public class TrailingZeros {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long temp = n / 5;
        long count = 0;
        while (temp != 0) {
            count += temp;
            temp /= 5;
        }
        return count;

    }
};

