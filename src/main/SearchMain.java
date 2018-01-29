package main;

import search.BinarySerach;
import util.SortTestHelper;

public class SearchMain {
    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateOrderArray(2, 0, 2);
        System.out.println(BinarySerach.binarySearch(arr, 0, arr.length - 1, 0));
    }
}
