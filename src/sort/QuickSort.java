package sort;

import java.util.Arrays;

/**
 * Created by kangqizhou on 2017/8/20.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] a = {3,5,2,7,4,17};
        quickSort(a,0,a.length-1);
        System.out.print(Arrays.toString(a));
    }

    private static void quickSort(int[] data, int start, int end) {

        int index = partition(data,start,end);
        if (index>start)
            quickSort(data,start,index-1);
        if (index<end)
            quickSort(data,index+1,end);
    }

    private static int partition(int[] data, int start, int end){
//        int random = randomInRange(start,end);
//        swap(data,random,end);
        int value = data[end];
        while (start < end){
            while (start<end&&data[start]<value)
                start++;
            data[end] = data[start];
            while (end>start&&data[end]>value)
                end--;
            data[start] = data[end];
        }
        data[end] = value;
        return end;
    }

    private static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private static int randomInRange(int start, int end) {
        return (int) (Math.random()*(end-start)+start);
    }
}
