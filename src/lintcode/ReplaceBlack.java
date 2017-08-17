package lintcode;

import java.util.Arrays;

/**
 * Created by kangqizhou on 2017/8/17.
 */

/**
 * 替换空格
 * 遍历两次，遍历第一次统计空格数量，遍历第二次将空格替换为'%''2''0'；
 */
public class ReplaceBlack {
    public static void main(String[] args) {
        char[] strs = new char[]{'a','b','c',' ','e','f','g'};
        System.out.println(Arrays.toString(replaceBlank(strs)));
    }

    public static char[] replaceBlank(char[] strs) {
        int length = 0;
        for (char c : strs) {
            if (c == ' ') {
                length += 3;
            } else {
                length++;
            }
        }
        int index1 = strs.length - 1;
        char[] strs2 = new char[length];
        int index2 = strs2.length - 1;
        while (index1>=0){
            if (strs[index1]==' '){
                strs2[index2--] = '0';
                strs2[index2--] = '2';
                strs2[index2--] = '%';
            }else {
                strs2[index2--] = strs[index1];
            }
            index1--;
        }
        return strs2;
    }
}
