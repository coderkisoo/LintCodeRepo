package nowcoder;

/**
 * Created by kangqizhou on 2017/8/31.
 */

import java.util.Stack;

/**
 *      8
 *    / | \
 *   1  2  3
 *  /\    / \
 * 4  6  5   7
 *
 * 先打印根节点，再从后到前压栈。
 */
public class DFSTree {

    public static void main(String[] args) {
        TreeNode[] childe4 = new TreeNode[]{new TreeNode(5, null), new TreeNode(7, null)};
        TreeNode[] childe3 = new TreeNode[]{new TreeNode(4, null), new TreeNode(6, null)};
        TreeNode[] child2 = new TreeNode[]{new TreeNode(1, childe3), new TreeNode(2, null), new TreeNode(3, childe4)};
        TreeNode treeNode = new TreeNode(8, child2);
        DFS_RECURSIVE(treeNode);
        System.out.println();
        DFS(treeNode);
    }

    //recursive
    public static void DFS_RECURSIVE(TreeNode node) {
        if (node == null)
            return;
        print(node.value);
        if (node.childs == null) {
            return;
        }
            for (TreeNode child : node.childs) {
                DFS_RECURSIVE(child);
            }

    }

    public static void DFS(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            print(temp.value);
            if (temp.childs == null) {
                continue;
            }
            for (int i = temp.childs.length; i > 0; i--) {
                TreeNode current = temp.childs[i - 1];
                if (current != null)
                    stack.push(current);
            }

        }
    }

    public static void print(int value) {
        System.out.println(value + " ");
    }

    static class TreeNode {
        TreeNode[] childs;
        int value;

        public TreeNode(int value, TreeNode[] child) {
            this.value = value;
            this.childs = child;
        }
    }

}
