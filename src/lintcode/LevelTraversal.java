package lintcode;

/**
 * Created by kangqizhou on 2017/8/7.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * 最新加入的节点一定是下一行打印的最右节点。
 * last当前行的最右节点
 * nLast下一行的最右节点
 */
public class LevelTraversal {
    public static void main(String[] args){
        TreeNode treeNode = example();
        levelPrint(treeNode);
    }

    private static void levelPrint(TreeNode treeNode) {
        TreeNode last = treeNode;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode nLast = null;
        if (addIn(queue,treeNode)){
            nLast = treeNode;
        }
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            print(temp);
            if (addIn(queue,temp.left)){
                nLast = temp.left;
            }
            if (addIn(queue,temp.right)){
                nLast = temp.right;
            }
            if (temp == last){
                System.out.println();
                last = nLast;
            }
        }
    }

    private static void print(TreeNode node){
        System.out.print(node.value+" ");
    }

    private static boolean addIn(Queue<TreeNode> queue,TreeNode node){
        boolean success;
        if (success = node!=null)
            queue.add(node);
        return success;
    }

    /***
     *            1
     *          /  \
     *        2     3
     *      /  \   / \
     *    4     9 5   6
     *          / \
     *        7   8
     * @return
     */
    public static TreeNode example() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(9);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);
        node.right.left.left = new TreeNode(7);
        node.right.left.right = new TreeNode(8);
        return node;
    }
}
