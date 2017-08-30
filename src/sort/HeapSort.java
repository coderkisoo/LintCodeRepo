package sort;

import java.util.Arrays;

/**
 * Created by kangqizhou on 2017/8/30.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 7, 4, 17};
        buildHeap(a);
        System.out.print(Arrays.toString(a));
    }

    private static void buildHeap(int[] a) {
        for (int i = a.length / 2; i > 0; i--) {
            maxHeap(a, i);
        }
    }

    private static void maxHeap(int[] array, int index) {
        int left = index * 2 - 1;
        int right = index * 2;
        int bigIndex = index;
        if (left <= array.length && array[bigIndex - 1] < array[left - 1]) {
            bigIndex = left;
        }
        if (right <= array.length && array[bigIndex - 1] < array[right - 1]) {
            bigIndex = right;
        }
        if (bigIndex != index) {
            swap(array, index - 1, bigIndex - 1);
            maxHeap(array, bigIndex);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 != index2) {
            array[index1] = array[index1] + array[index2];
            array[index2] = array[index1] - array[index2];
            array[index1] = array[index1] - array[index2];
        }
    }
}
