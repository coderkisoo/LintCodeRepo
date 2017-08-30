package lintcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kangqizhou on 2017/8/25.
 */
public class B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Position> arrayList = new ArrayList<>();
        for (int i =0;i<n;i++){
            String str = scanner.next();
            for (int j = 0;j<n;j++){
                char c = str.charAt(j);
                if (c == '*')
                    arrayList.add(new Position(i,j));
            }
        }
        if (arrayList.size()>1)
        arrayList.get(0).tag = 0;
        for (int i = 0;i<arrayList.size();i++) {
            handle(arrayList,i,i);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<arrayList.size();i++){
            hashSet.add(arrayList.get(i).tag);
        }
        System.out.println(hashSet.size());
    }

    private static void handle(List<Position> arrayList,int index,int tag) {
        Position position = arrayList.get(index);
        if (position.tag == -1)
            position.tag = tag;
        for (int i = index+1;i<arrayList.size();i++){
            Position temp = arrayList.get(i);
            if (temp.isSame(position))
            temp.tag = position.tag;
        }
    }
}

class Position{

    int x;
    int y;
    int tag = -1;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public boolean isSame(Position position){
        if (position.x == x&&Math.abs(position.y - y)==1){
            return true;
        }
        if (position.y == y&&Math.abs(position.x - x)==1){
            return true;
        }
        if (position.x == x+1&&position.y==y+1){
            return true;
        }
        if (position.x == x-1&&position.y==y-1){
            return true;
        }
        if (position.x == x+1&&position.y==y-1){
            return true;
        }
        if (position.x == x-1&&position.y==y+1){
            return true;
        }
        return false;
    }
}
