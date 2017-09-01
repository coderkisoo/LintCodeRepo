package nowcoder;

import lintcode.LevelTraversal;
import lintcode.TreeNode;

import java.util.Stack;

/**
 * Created by kangqizhou on 2017/9/1.
 */

/**
 * middleIterator：中序遍历，先遍历左子树。再根节点，再右子树，不断的将左节点压栈，直到左节点为null，再出栈。压入右节点。
 */
public class MiddleTree {
    public static void main(String[] args){
        midleIterator(LevelTraversal.example());
    }

    private static void midleIterator(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        //先不断的把左子树压入，然后出栈，打印，直到空栈，再将
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                print(node);
                node = node.right;
            }
        }
    }

    private static void print(TreeNode node){
        System.out.println(node.value);
    }
}
