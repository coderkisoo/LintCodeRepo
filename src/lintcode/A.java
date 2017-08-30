package lintcode;

/**
 * Created by kangqizhou on 2017/8/25.
 */

import java.util.Scanner;

public class A {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/



    static int maxMount(int price, int cap, int emptyBottle, int money, int currentCap, int currentEmptyBottle) {
        int current = 0;
        int sub = 0;
        boolean is = false;
        if (money>=price){
            current += money/price;
            money = money%price;
            is = true;
        }
        if (currentCap>=cap){
            current += currentCap/cap;
            currentCap %= cap;
            is = true;
        }else if (currentCap == cap-1){
            current++;
            currentCap = 0;
            sub -= 1;
            is = true;

        }
        if (currentEmptyBottle>=emptyBottle){
            current+=currentEmptyBottle/emptyBottle;
            currentEmptyBottle %= emptyBottle;
            is = true;
        }else if (currentEmptyBottle == emptyBottle-1){
            current++;
            currentEmptyBottle = 0;
            is = true;
            sub = sub-1;
        }
        return is?current+maxMount(price,cap,emptyBottle,money,currentCap+current+sub,currentEmptyBottle+current+sub):current;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _price;
        _price = Integer.parseInt(in.nextLine().trim());

        int _cap;
        _cap = Integer.parseInt(in.nextLine().trim());

        int _emptyBottle;
        _emptyBottle = Integer.parseInt(in.nextLine().trim());

        int _money;
        _money = Integer.parseInt(in.nextLine().trim());

        res = maxMount(_price, _cap, _emptyBottle, _money, 0, 0);
        System.out.println(String.valueOf(res));

    }
}