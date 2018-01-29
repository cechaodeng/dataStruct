package sort;

import util.SortTestHelper;

import java.util.Arrays;

public class InsertionSort {
    private static long startTime;
    private static long endTime;

    /**
     * 初始版本插入排序,一边插入一边寻找合适位置
     * 交换次数过多,且很多无意义的交换
     * @param oldArr
     * @return
     */
    public static Comparable[] sort(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    //swap
                    SortTestHelper.swap(arr, j - 1, j);
                    /*int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;*/
                } else if (arr[j].compareTo(arr[i]) > 0) {
                    break;
                }
            }
        }
        System.out.println("InsertionSort.sort:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
        return arr;
    }


    /**
     * 原始插入排序的重载函数
     * 排序指定数组的指定区间[left,right]
     * 修改的是原数组,而不是复制的数组
     * @param left
     * @param right
     * @return
     */
    public static void sort(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Comparable temp = arr[i];
            for (int j = i - 1; j >= left; j--) {
                if (arr[j].compareTo(temp) > 0) {
                    //move right
                    arr[j + 1] = arr[j];
                    if (j == left) {
                        //已经把最左边的移动过去了,只能插在最左边了
                        arr[left] = temp;
                    }
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
        }
        SortTestHelper.checkArr(arr, left, right);
    }
    /**
     * 插入排序改进版,找到位置才插入,之前只是移动元素
     * 相比初始版本减少了交换次数
     * @param oldArr
     * @return
     */
    public static Comparable[] sort2(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        startTime = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(temp) > 0) {
                    //大于需要比较的数,说明需要往右移动
                    arr[j + 1] = arr[j];
                    //如果到边界了已经没法继续比较了,就必须要插入了
                    if (j == 0) {
                        arr[j] = temp;
                    }
                } else {
                    //小于需要移动的数字,说明要插在这里
                    //arr[j + 1] = arr[j];
                    arr[j + 1] = temp;
                    break;
                }
            }
        }
        System.out.println("InsertionSort.sort2:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
        return arr;
    }
}
