package nowcoder;

import lintcode.LevelTraversal;
import lintcode.TreeNode;

import java.util.Stack;

/**
 * Created by kangqizhou on 2017/9/1.
 */
public class MiddleTree {
    public static void main(String[] args){
        midleIterator(LevelTraversal.example());
    }

    protected static void midleIterator(TreeNode node) {
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
