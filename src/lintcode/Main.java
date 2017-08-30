package lintcode;

import java.util.*;


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        List<Node> result = new ArrayList<>();
        int count = in.nextInt();
        for (int k = 0; k < count; k++) {
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            Node node = new Node(x0, y0);
            list.add(node);
        }
        for (int i = 0; i < list.size(); i++) {
            Node nowNode = list.get(i);
            boolean flag = true;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).y > nowNode.y && list.get(j).x > nowNode.x) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(nowNode);
            }
        }
        Collections.sort(result, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x>o2.x){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).x + " " + result.get(i).y);
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
