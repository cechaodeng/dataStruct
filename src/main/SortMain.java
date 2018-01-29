package main;

import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.SelectionSort;
import util.SortTestHelper;

public class SortMain {
    public static void main(String[] args) {
        //生成完全随机的数组
        Comparable[] arr = SortTestHelper.generateRandomArray(1000000, 0, 10);

        //生成近乎有序的数组
        //Comparable[] arr = SortTestHelper.generateNearlyOrderArray(600000, 100);

        // 生成确定数组
        //Comparable[] arr = SortTestHelper.generateArray();

        //System.out.println("原始数据:");
        //SortTestHelper.printArr(arr);

        //选择排序
        //SelectionSort.sort(arr);

        //插入排序
        //InsertionSort.sort(arr);

        //指定区间的插入排序
        //InsertionSort.sort(arr, 0, arr.length - 1);

        //优化插入次数后的插入排序
        //InsertionSort.sort2(arr);

        //归并排序
        MergeSort.sort(arr);

        //自己优化快速排序
        QuickSort.sort(arr);
        //通用优化快速排序
        QuickSort.sort2(arr);
        //多路排序
        QuickSort.sort3Way(arr);

        //System.out.println("排序后");//该方法只对部分情况有效
        //SortTestHelper.printArr(arr);
    }
}
