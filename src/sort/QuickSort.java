package sort;

import util.SortTestHelper;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.SocketHandler;

public class QuickSort {

    /**
     * 自己优化后
     * @param oldArr
     */
    public static void sort(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        long startTime = System.currentTimeMillis();
        //没有进行等于情况优化
        //partition(arr, 0, arr.length - 1);
        //自己的方法进行等于情况优化
        partition2(arr, 0, arr.length - 1);
        System.out.println("QuickSort.sort:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
    }

    /**
     * 优化后，两路
     * @param oldArr
     */
    public static void sort2(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        long startTime = System.currentTimeMillis();
        //没有进行等于情况优化
        //partition(arr, 0, arr.length - 1);
        //两路排序
        partition3(arr, 0, arr.length - 1);
        System.out.println("QuickSort.sort2:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
    }

    /**
     * 三路
     * @param oldArr
     */
    public static void sort3Way(Comparable[] oldArr) {
        Comparable[] arr = Arrays.copyOf(oldArr, oldArr.length);
        long startTime = System.currentTimeMillis();
        partition3Way(arr, 0, arr.length - 1);
        System.out.println("QuickSort.sort3Way:" + (System.currentTimeMillis() - startTime) + "ms");
        SortTestHelper.checkArr(arr);
    }

    /**
     * 将[left,right]区间快速排序
     * @param arr
     * @param left
     * @param right
     */
    private static void partition3(Comparable[] arr, int left, int right) {
        /*
        优化一:当元素个数非常小的时候,最有可能接近有序,这时候用插入排序最快
         */
        /*if (left >= right) {
            return;
        }*/
        if (right - left < 16) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        /**
         * 优化二:
         * 基本值的位置随机,然后将该随机位置的值与l位置交换一下就可以无缝连接
         */
        int baseIndex = (int) (Math.random() * (right - left + 1)) + left;
        SortTestHelper.swap(arr, baseIndex, left);

        int l = left;//用于比较的基本值的位置
        int i = l + 1;//i左边的数都小于比较值
        int j = right;//j右边的值都大于比较值

        Comparable baseValue = arr[l];
        while (true) {
            while (i <= right && arr[i].compareTo(baseValue) < 0) i++;
            while (j >= l + 1 && arr[j].compareTo(baseValue) > 0) j--;
            if (i > j) {
                break;
            }
            //走完循环，交换ij位置的元素
            SortTestHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, left, j);
        partition3(arr, left, j - 1);
        partition3(arr, j + 1, right);
    }


    /**
     * 将[left,right]区间快速排序
     * 基准值是固定的,这种情况还有优化空间
     * @param arr
     * @param left
     * @param right
     */
    private static void partition(Comparable[] arr, int left, int right) {
        /*
        优化一:当元素个数非常小的时候,最有可能接近有序,这时候用插入排序最快
         */
        /*if (left >= right) {
            return;
        }*/
        if (right - left < 16) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        /**
         * 优化二:
         * 基本值的位置随机,然后将该随机位置的值与l位置交换一下就可以无缝连接
         */
        int baseIndex = (int) (Math.random() * (right - left + 1)) + left;
        SortTestHelper.swap(arr, baseIndex, left);
        int l = left;//用于比较的基本值的位置
        int j = left;//小于基本值的最右边元素的位置,初始状态应该指向left-1,表示没有
        for (int i = l + 1; i <= right; i++) {//当前遍历到的位置
            if (arr[i].compareTo(arr[l]) < 0) {
                //小于
                //swap
                SortTestHelper.swap(arr, j + 1, i);
                j++;
            }
        }
        //走完一遍,将用于比较的基本值与j位置交换
        SortTestHelper.swap(arr, l, j);//交换后,j就是基本元素的位置,小于基本元素的最右边的位置变成了j-1
        partition(arr, left, j - 1);
        partition(arr, j + 1, right);
    }

    /**
     * 将[left,right]区间快速排序
     * 把等于的都放在小于这边,然后分治的时候,等于的就不用处理了
     * @param arr
     * @param left
     * @param right
     */
    private static void partition2(Comparable[] arr, int left, int right) {
        /*
        优化一:当元素个数非常小的时候,最有可能接近有序,这时候用插入排序最快
         */
        /*if (left >= right) {
            return;
        }*/
        if (right - left < 16) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        /**
         * 优化二:
         * 基本值的位置随机,然后将该随机位置的值与l位置交换一下就可以无缝连接
         */
        int baseIndex = (int) (Math.random() * (right - left + 1)) + left;
        SortTestHelper.swap(arr, baseIndex, left);
        int l = left;//用于比较的基本值的位置
        int j = left;//小于基本值的最右边元素的位置,初始状态应该指向left-1,表示没有
        for (int i = l + 1; i <= right; i++) {//当前遍历到的位置
            if (arr[i].compareTo(arr[l]) <= 0) {//加上等于,把等于该数的都放在一起来
                //小于
                //swap
                SortTestHelper.swap(arr, j + 1, i);
                j++;
            }
        }
        //走完一遍,将用于比较的基本值与j位置交换
        SortTestHelper.swap(arr, l, j);//交换后,j就是基本元素的位置,小于基本元素的最右边的位置变成了j-1
        //等于基本值的已经不需要处理了
        for (int k = j - 1; k >= left; k--) {
            if (arr[k].compareTo(arr[j]) != 0) {
                //不等于的时候,这里需要分治了
                partition2(arr, left, k);
                break;
            }
        }
        //partition2(arr, left, j - 1);
        partition2(arr, j + 1, right);
    }

    /**
     * 将[left,right]区间快速排序
     * 三路排序
     * @param arr
     * @param left
     * @param right
     */
    private static void partition3Way(Comparable[] arr, int left, int right) {
        /*
        优化一:当元素个数非常小的时候,最有可能接近有序,这时候用插入排序最快
         */
        /*if (left >= right) {
            return;
        }*/
        if (right - left < 16) {
            InsertionSort.sort(arr, left, right);
            return;
        }

        /**
         * 优化二:
         * 基本值的位置随机,然后将该随机位置的值与l位置交换一下就可以无缝连接
         */
        int baseIndex = (int) (Math.random() * (right - left + 1)) + left;
        SortTestHelper.swap(arr, baseIndex, left);

        //比较值
        //Comparable baseValue = arr[baseIndex];

        int l = left;//用于比较的基本值的位置
        int lt = left;//小于基本值的最右边元素的位置,初始状态应该指向left,表示没有,因为left位置是比较值
        int gt = right + 1;//表示大于基本值的最左边元素的位置
        for (int i = l + 1; i < gt; i++) {//当前遍历到的位置
            if (arr[i].compareTo(arr[l]) < 0) {
                //小于，当前值要与等于区域的第一个值交换位置
                SortTestHelper.swap(arr, lt + 1, i);
                lt++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                //当前值与大于区域的最左边元素交换位置
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
                i--;
            }
        }
        //走完一遍,将用于比较的基本值与小于比较值区域的最大值位置交换
        SortTestHelper.swap(arr, l, lt);//交换后,j就是基本元素的位置,小于基本元素的最右边的位置变成了j-1
        partition3Way(arr, left, lt - 1);
        partition3Way(arr, gt, right);
    }
}
