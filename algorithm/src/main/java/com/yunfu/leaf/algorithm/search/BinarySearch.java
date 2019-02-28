package com.yunfu.leaf.algorithm.search;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二分查找法:效率 O(logN)
 * @date: 2019-01-02
 * @time: 10:52
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        // 可能会发生数据溢出
        //int middle = (low+high)/2;
        int middle = 0;
        while (low < high) {
            middle = low + (high - low) / 2;
            if (key == arr[middle]) {
                return middle;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 旋转数组的最小数字
     *
     * @param arr 数组{3, 4, 5, 1, 2}
     * @return 旋转数组的最小数字 1
     */
    public static int findMin(int[] arr) {
        // 分析：本来是一个有序的数组： 1 2 3 4 5 ，变成了 3 4 5 1 2，发现可以折半查找，找到最小数，因为数组都是有规律的
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            // 因为数组本来有序，然后被旋转了，肯定是从小到大，再从小到大
            // 先比较中间值和最后一个值大小，比如这里 5 > 2，可以看出旋转的数字在 5-2 的区域里面
            if(arr[middle]>arr[high]){
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr));
    }

}
