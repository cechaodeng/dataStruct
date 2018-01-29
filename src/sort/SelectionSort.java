package sort;

import util.SortTestHelper;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 选择排序,每次通过一个个比较交换来选择最小的放在未排序的最左边
     * 需要进行大量的比较和交换,而且很多无意义的交换
     * @param oldArr
     * @return
     */
    public static Comparable[] sort(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    //swap
                    SortTestHelper.swap(arr, i, j);
                    /*int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;*/
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort耗时:" + (endTime - startTime) + "ms");
        SortTestHelper.checkArr(arr);
        return arr;
    }
}
