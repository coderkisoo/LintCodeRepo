package lintcode;

/**
 * Created by kangqizhou on 2017/9/3.
 */

import java.util.Stack;

/***
 * 打印一棵二叉树，从左到右，然后从右到左
 */
public class SPrint {
    static TreeNode treeNode = LevelTraversal.example();
    public static void main(String[] args){
        sprint(treeNode);
    }

    private static void sprint(TreeNode treeNode) {
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack0.push(treeNode);
        while (!(stack0.isEmpty()&&stack1.isEmpty())) {
            boolean tag0 = !stack0.isEmpty();
            Stack<TreeNode> stack = tag0 ? stack0:stack1;
            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                System.out.println(temp.value);
                pushIn(tag0,temp,stack0,stack1);

            }

        }
    }

    private static void pushIn(boolean tag0, TreeNode temp, Stack<TreeNode> stack0, Stack<TreeNode> stack1) {
        if (tag0){
            pushIn(stack1,temp.left);
            pushIn(stack1,temp.right);
        }else {
            pushIn(stack0,temp.right);
            pushIn(stack0,temp.left);
        }
    }

    private static <E> void pushIn(Stack<E> stack,E e){
        if (e!=null)
            stack.push(e);
    }
}
