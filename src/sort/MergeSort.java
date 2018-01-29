package sort;

import util.SortTestHelper;

import java.util.Arrays;

public class MergeSort {


    /**
     * 归并排序
     * 复制一份空间,将数组递归拆分成两份,分别排序
     * 最后merge到原始空间
     *
     * @return
     */
    public static void sort(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        long startTime = System.currentTimeMillis();
        splitArr(arr, 0, arr.length-1);
        System.out.println("MergeSort.sort:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
    }

    /**
     * 拆分数组arr的区间[left,right]
     * @param arr
     * @param left
     * @param right
     */
    private static void splitArr(Comparable[] arr, int left, int right) {
        /*
        优化二:当数据量越小,有序的可能性越大,接近有序的情况下,插入排序的性能是最好的
         */
        /*if (left >= right) {
            return;
        }*/
        if (right - left + 1 <= 16) {
            //假设是数组长度小于16就认为他已经接近有序了, 然后使用插入排序
            InsertionSort.sort(arr, left, right);
            return;
        }

        int mid = (left / 2) + (right / 2);
        splitArr(arr, left, mid);
        splitArr(arr, mid + 1, right);
        /*
        优化一:并不是所有的左右两边都需要merge
        如果左边最后边的数小于右边最左边的数,就不需要merge了
         */
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            //merge
            merge(arr, left, mid, right);
        }
    }

    /**
     * merge数组arr[left,mid]和arr[mid+1,right]
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(Comparable[] arr, int left, int mid, int right) {
        //复制空间和数据
        Comparable[] copyArr = new Comparable[right - left + 1];
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = arr[left + i];
        }
        //下标赋值
        int i = 0;//左边头部
        int m = mid - left;
        int j = m + 1;//右边头部
        //开始归并
        for (int k = left; k <= right; k++) {
            if (i > m) {
                //左边数组已经合并完了
                arr[k] = copyArr[j++];
            } else if (j >= copyArr.length) {
                //右边数组已经合并完了
                arr[k] = copyArr[i++];
            } else if (copyArr[i].compareTo(copyArr[j]) < 0) {
                //左边小
                arr[k] = copyArr[i];
                i++;
            } else if (copyArr[i].compareTo(copyArr[j]) >= 0) {
                //左边大
                arr[k] = copyArr[j];
                j++;
            }
        }

    }

    /**
     * 自底向上的归并排序
     * @param arr
     */
    private static void mergeBU(Comparable[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                merge(arr, i, i + sz - 1, SortTestHelper.min(i + sz + sz - 1, arr.length - 1));
            }
        }

    }
}

