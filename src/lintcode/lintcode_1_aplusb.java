package lintcode;

/**
 * Created by kangqizhou on 2017/8/7.
 */

/***
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 * 注意事项
 * 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
 */
public class lintcode_1_aplusb {
    public int plus(int a,int b){
        while (b!=0){
            int a_ = a^b;
            int b_ = (a&b)<<1;
            a = a_;
            b = b_;
        }
        return a;
    }
}
