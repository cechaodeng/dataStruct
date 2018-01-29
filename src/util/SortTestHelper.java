package util;

public class SortTestHelper {
    /**
     * 生成n个元素的随机数组,范围为[rangeL,rangeR]
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Comparable[] generateRandomArray(int n, int rangeL, int rangeR) {
        Comparable[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            //[5,10]
            /*[0, 1)
            [0,6)
            [5,11)*/
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + 5;
        }
        return arr;
    }

    /**
     * 生成确定数组
     * @return
     */
    public static Comparable[] generateArray() {
        Comparable[] arr = new Integer[]{80, 20, 75, 105, 89};
        return arr;
    }


    /**
     * 生成一个大小为n,随机打乱次数为swapTimes次的近乎有序数组
     *
     * @param n
     * @param swapTimes
     * @return
     */
    public static Comparable[] generateNearlyOrderArray(int n, int swapTimes) {
        Comparable[] arr = new Integer[n];
        //生成一个有序数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        //随机选swapTimes次数据进行交换
        for (int i = 0; i < swapTimes; i++) {
            int x = (int) (Math.random() * n);
            int y = (int) (Math.random() * n);
            Comparable t = arr[x];
            arr[x] = arr[y];
            arr[y] = t;
        }
        return arr;
    }


    /**
     * 生成一个有序数组
     * @param n
     * @return
     */
    public static Comparable[] generateOrderArray(int n,int start ,int jumps) {
        Comparable[] arr = new Integer[n];
        //生成一个有序数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start + (jumps * i);
        }
        return arr;
    }

    /**
     * 打印整个数组
     * @param arr
     */
    public static void printArr(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    /**
     * 打印指定区间
     * @param arr
     * @param left
     * @param right
     */
    private static void printArr(Comparable[] arr, int left, int right) {
        for (int i = left; i < right; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    /**
     * 校验数组是否已经有序
     * @param arr
     */
    public static void checkArr(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                System.out.println("排序错误");
                if (arr.length <= 10) {
                    printArr(arr);
                } else {
                    printArr(arr, 0, 10);

                }
                break;
            }
        }
    }



    /**
     * 校验指定区间是否已经排序
     * @param arr
     * @param left
     * @param right
     */
    public static void checkArr(Comparable[] arr, int left, int right) {
        for (int i = left; i < right; i++) {

            if (arr[i].compareTo(arr[i + 1]) > 0) {
                System.out.println("排序错误");
                break;
            }
        }
    }

    public static void swap(Comparable[] arr, int leftIndex, int rightIndex) {
        Comparable temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }

    public static int min(int x, int y) {
        return x < y ? x : y;
    }

}
