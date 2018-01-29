package search;

public class BinarySerach {

    /**
     * 从arr中的[left,right]中找到value的下标返回
     * 这里采用递归方式，也可以使用循环方式
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(Comparable[] arr, int left, int right, Comparable target) {
        int mid = left / 2 + right / 2;//left+(right-left)/2
        int compareResult = arr[mid].compareTo(target);
        if (left < right) {
            if (compareResult == 0) {
                //System.out.println("floor:" + (mid - 1) + ",value:" + arr[mid - 1]);
                //System.out.println("ceil:" + (mid + 1) + ",value:" + arr[mid + 1]);
                return mid;
            } else if (compareResult < 0) {
                //中间值小于目标值
                return binarySearch(arr, mid + 1, right, target);
            } else {
                //中间值大于目标值
                return binarySearch(arr, left, mid - 1, target);
            }
        }
        /*if (left == right) {
            if (arr[left] == target) {
                //System.out.println("floor:" + left + ",value:" + arr[left-1]);
                //System.out.println("ceil:" + (mid + 1) + ",value:" + arr[mid + 1]);
                //Comparable a = left - 1 >= 0 ? arr[left - 1] : arr[left];
                System.out.println("???");
                return left;
            }
        }*/
        //System.out.println("floor:" + (mid - 1) + ",value:" + arr[mid - 1]);
        //System.out.println("ceil:" + (mid + 1) + ",value:" + arr[mid + 1]);
        return -1;
    }
}
