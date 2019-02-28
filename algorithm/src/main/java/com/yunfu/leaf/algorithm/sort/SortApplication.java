package com.yunfu.leaf.algorithm.sort;

import java.util.Arrays;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 排序的应用: 一些排序算法的应用场景
 * @date: 2019-01-02
 * @time: 14:37
 */
public class SortApplication {

    /**
     * 1. 找到第 k 大的数：先给数组排序，直接取出第 k 大的数
     * 时间复杂度 O(nlogn)，空间复杂度 O(1)
     *
     * @param arr 数组{12, 25, 85, 25, 45, 36, 1, 88, 79, 75, 555, 6}
     * @param k   第 k 大的数
     * @return 第 k 大的数
     */
    public static int findKthLargest1(int[] arr, int k) {
        // 先给数组排序,Java Arrays 中提供了对所有类型的排序。其中主要分为 Primitive (8 种基本类型)和 Object 两大类。
        // 基本类型：采用调优的快速排序(元素个数较少时，源码中的阀值为 7 ，采用的是插入排序) ,对象类型：采用改进的归并排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // 取出第 k 大的数
        return arr[arr.length - k];
    }

    /**
     * 1. 找到第 k 大的数：对于一个数组，第 k 大的数位于 arr[arr.length - k]即 index 位置，利用快排的分区方法，当分区到 index = k ，左边比 index 小，右边比 index 大，所以 index 位置就是第 k 大
     * 时间复杂度 O(N)，空间复杂度 O(1)
     *
     * @param arr 数组{12, 25, 85, 25, 45, 36, 1, 88, 79, 75, 555, 6}
     * @param k   第 k 大的数
     * @return 第 k 大的数
     */
    public static int findKthLargest2(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        // 记录第 k 大的数的索引
        k = arr.length - k;
        while (low < high) {
            // 分区
            int index = partition(arr, low, high);
            if (index == k) {
                break;
            } else if (index < k) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        return arr[k];
    }

    /**
     * 快排的分区
     *
     * @param arr  数组
     * @param low  低位
     * @param high 高位
     * @return 分区的 key 最终位置
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int h = high - 1;
        int key = arr[low];
        while (i < h) {
            // 先从右边开始找
            while (i < h && arr[h] > key) {
                h--;
            }
            while (i < h && arr[i] <= key) {
                i++;
            }
            if (i < h) {
                swap(arr, i, h);
            }
        }
        swap(arr, low, i);
        return i;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    /**
     * 2. 得到最小的 k 个数(分区方法以及堆方法)
     * 最大堆方法：每次建立最大堆，交换数组第一个和最后一个数字，当交换到 n-k 个时候，剩下的数组就是最小的 k 个数
     * 快排分区方法：一直分区，当分区到 k-1 的时候，即记录 index=k-1 ，发现 k-1 之前的 k-1 数比 index 小，所以 k 个数就是 0-k-1
     *
     * @param arr 原始数组
     * @param k   最小的 k 个数
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] output = new int[k];
        int low = 0;
        int high = arr.length;
        int index = 0;
        while (low < high) {
            index = partition(arr, low, high);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        System.out.println(index);
        // 把 arr 数组前面 k 个数放到 output 数组中
        for (int i = 0; i < k; i++) {
            output[i] = arr[i];
        }
        return output;
    }


    public static void main(String[] args) {
        int[] arr = {12, 25, 85, 25, 45, 36, 1, 88, 79, 75, 555, 6};
//        System.out.println(findKthLargest1(arr, 5));
//        System.out.println(findKthLargest2(arr, 5));
        System.out.println(Arrays.toString(getLeastNumbers(arr,12)));
    }

}
