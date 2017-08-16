package lintcode;

/**
 * Created by kangqizhou on 2017/8/17.
 */

/***
 * 找出矩阵中是否存在目标数
 *
 * 思路：
 * 从右上角遍历，如果目标数大于当前坐标，则行数++，如果目标数小于当前坐标，则列数--
 */
public class FindNum {
    static int nums[][] = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15},{8, 9, 12, 45}};

    public static void main(String... args) {
        System.out.println(find(nums, nums.length, nums[0].length, 45));
    }

    private static boolean find(int[][] nums, int columns, int rows, int num) {
        boolean found = false;
        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (nums[column][row] == num) {
                    found = true;
                    break;
                } else if (nums[column][row] > num) {
                    column--;
                } else {
                    row++;
                }

            }
        }
        return found;
    }
}
