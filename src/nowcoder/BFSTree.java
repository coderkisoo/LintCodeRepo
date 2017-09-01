package nowcoder;

/**
 * Created by kangqizhou on 2017/8/31.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * 广度优先遍历
 */

/**
 *      8
 *   / | \
 *  1  2  3
 *       / \
 *      4   6
 * 等同于层序遍历，设置last和nlast，nlast等于最后加入的节点。last等同于上一层最后一个节点
 *
 */
public class BFSTree {
    public static void main(String[] args) {
        TreeNode[] childe3 = new TreeNode[]{
            new TreeNode(4,null),new TreeNode(6,null)
        };
        TreeNode[] child2 = new TreeNode[]{new TreeNode(1,null),new TreeNode(2,null),new TreeNode(3,childe3)};
        TreeNode treeNode = new TreeNode(8,child2);
        BFS(treeNode);
    }

    public static void BFS(TreeNode node){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        TreeNode nLast = null;
        TreeNode last = node;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            print(temp.value);
            if (temp.childs!=null)
            for (TreeNode treeNode:temp.childs){
                if (addIn(queue,treeNode))
                    nLast = treeNode;
            }
            if (temp == last){
                System.out.println();
                last = nLast;
            }
        }
    }

    private static void print(int value) {
        System.out.print(value+" ");
    }

    private static boolean addIn(Queue<TreeNode> queue,TreeNode node){
        if (node==null)
            return false;
        queue.add(node);
        return true;
    }

}

class TreeNode{
    TreeNode[] childs;
    int value;
    public TreeNode(int value,TreeNode[] child){
        this.value = value;
        this.childs = child;
    }
}
