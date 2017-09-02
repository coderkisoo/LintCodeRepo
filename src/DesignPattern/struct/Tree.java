package DesignPattern.struct;

/**
 * Created by kangqizhou on 2017/9/2.
 */

/***
 * 将多个对象组合在一起进行操作，常用于表示树形结构中
 */
public class Tree {
    TreeNode root;

    public void setRoot(TreeNode root){
        this.root = root;
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
}

interface Main{
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.setRoot(new TreeNode());
    }
}