package nowcoder;

import lintcode.LevelTraversal;
import lintcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreePrinter {

    public static void main(String[] args){
        int[][] a= printTree(LevelTraversal.example());
        for (int[] i:a){
            for (int b:i){
                System.out.println(b);
            }
        }
    }

    public static int[][] printTree(TreeNode root) {
        // write code here
        TreeNode last = null;
        TreeNode nLast = null;
        int current = 0;
        int index = 0;
        int[][] shuzu = new int[10][10];
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(addIn(queue,root)){
            last = root;
            nLast = root;
        }
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(addIn(queue,temp.left)){
                nLast = temp.left;
            }
            if(addIn(queue,temp.right)){
                nLast = temp.right;
            }
            shuzu[current][index] = temp.value;
            System.out.println(temp.value);
            index++;
            if(temp == last){
                last = nLast;
                current++;
                index = 0;
            }
        }

        return shuzu;
    }

    public static boolean addIn(Queue<TreeNode> queue,TreeNode node){
        boolean success;
        if(success = node!=null){
            queue.add(node);
        }
        return success;
    }


}

//class TreeNode{
//    int value;
//    TreeNode left;
//    TreeNode right;
//}