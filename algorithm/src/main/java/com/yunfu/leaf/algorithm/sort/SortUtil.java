package com.yunfu.leaf.algorithm.sort;

import com.yunfu.leaf.algorithm.queue.model.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 排序工具类
 * @date: 2018-09-03
 * @time: 22:49
 */
public class SortUtil {

    /**
     * 冒泡排序:平均算法速度O（n^2），最坏情况下的算法速度O（n^2）
     * 原数组 6 个元素： 5 7 2 9 4 11
     * 第一趟：5 2 7 4 9 11 每一趟相邻两个数比较，直到把最大的数放到 n-i 处，第一趟放到 n 处
     * 第二趟：2 5 4 7 9 11 第二趟就是把 9 冒泡到 n-1 处
     * 第三趟：2 4 5 7 9 11 第三趟就是把 7 冒泡到 n-2 处
     * 第四趟：2 4 5 7 9 11 第四趟就是把 5 冒泡到 n-3 处
     * 第五趟：2 4 5 7 9 11 第五趟就是把 4 冒泡到 n-4 处
     */
    public static void bubbleSort(int[] arr0) {
        int n = arr0.length;
        // 这表示 n 个数 n 个循环
        for (int i = 0; i < n - 1; i++) {
            // 第一次就把最大的数据给冒泡上去，所以每次从 0 开始（每一次都会把这个数放到最上面）
            for (int j = 0; j < n - i - 1; j++) {
                if (arr0[j] > arr0[j + 1]) {
//                    int temp = arr0[j];
//                    arr0[j] = arr0[j + 1];
//                    arr0[j + 1] = temp;
//                    arr0[j] = arr0[j] + arr0[j + 1];
//                    arr0[j + 1] = arr0[j] - arr0[j + 1];
//                    arr0[j] = arr0[j] - arr0[j + 1];

                    arr0[j] = arr0[j] ^ arr0[j + 1];
                    arr0[j + 1] = arr0[j] ^ arr0[j + 1];
                    arr0[j] = arr0[j] ^ arr0[j + 1];

                }
            }
        }
    }


    /**
     * 冒泡排序：优化
     */
    public static void bubbleSort2(int[] arr0) {
        int n = arr0.length;
        // 这表示 n 个数 n 个循环
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            // 第一次就把最大的数据给冒泡上去，所以每次从 0 开始（每一次都会把这个数放到最上面）
            for (int j = 0; j < n - i - 1; j++) {
                if (arr0[j] > arr0[j + 1]) {
                    arr0[j] = arr0[j] ^ arr0[j + 1];
                    arr0[j + 1] = arr0[j] ^ arr0[j + 1];
                    arr0[j] = arr0[j] ^ arr0[j + 1];
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 插入排序:平均算法速度O（n^2），最坏情况下的算法速度O（n^2）
     * 从第二数开始，默认第一个数是排好序的，每次把第 i 个数前面都排好序，直到最后一个
     * 原数组 6 个元素： 5 7 2 9 4 11
     * 第一趟：5 7 2 9 4 11
     * 第二趟：2 5 7 9 4 11
     * 第三趟：2 5 7 9 4 11
     * 第四趟：2 4 5 7 9 11
     * 第五趟：2 4 5 7 9 11
     */
    public static void insertSort(int[] arr0) {
        // 从第二个元素开始
        for (int i = 1; i < arr0.length; i++) {
            // 取出第二个数
            int key = arr0[i];
            int j = i;
            while (j > 0 && key < arr0[j - 1]) {
                arr0[j] = arr0[j - 1];
                j--;
            }
            arr0[j] = key;
        }
    }


    /**
     * 选择排序:平均算法速度O（n^2），最坏情况下的算法速度O（n^2）
     * 原数组 6 个元素： 5 7 2 9 4 11
     * 第一趟：2 7 5 9 4 11
     * 第二趟：2 4 5 9 7 11
     * 第三趟：2 4 5 9 7 11
     * 第四趟：2 4 5 7 9 11
     * 第五趟：2 4 5 7 9 11
     */
    public static void selectSort(int[] arr0) {
        for (int i = 0; i < arr0.length; i++) {
            // 以每次循环为最小值
            int min = i;
            for (int j = i + 1; j < arr0.length; j++) {
                // 得到每一趟最小值
                if (arr0[min] > arr0[j]) {
                    min = j;
                }
            }
            // 如果最小值的索引变了
            if (i != min) {
                int temp = arr0[i];
                arr0[i] = arr0[min];
                arr0[min] = temp;
            }
        }
    }

    /**
     * 希尔排序:平均算法速度O（n^(3/2)），最坏情况下的算法速度O（n^2）
     * 优点：通过加大插入排序的间隔，来减少元素移动次数，每一趟间隔的出来的数组（x1,x2,x3...）,都会插入排序一遍，
     * 直到间隔为 1 ，就相当于整个数组一次插入排序。但是元素移动量会大大减少，因为最后一次的插入排序，小的
     * 元素都在数组左边大的元素都在数组右边，所以移动量会比较小。
     * 应用：几乎任何排序工作在开始时都可以用希尔排序，若在实际使用中证明它不够快，再改成快速排序这样更高级的排序算法.
     * 状态：不稳定，虽然一次插入排序是稳定的，但是多次插入排序，可能相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱
     * 对比插排：插入排序就是因为如果当后面突然有一个很小的元素要插入，那么元素移动量非常大，效率低
     *
     * @param arr [1, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 49]
     */
    public static void shellSort(int[] arr) {
        int interval = arr.length;
        while (true) {
            // 先算出每次的间隔大小
            interval = interval / 2;
            // 遍历所有的元素组（x0,x6,x12）,(x1,x7),(x2,x8),(x3,x9),,(x4,x10),(x5,x11)...............
            // 当 d = 6 ，所以要把 6 组元素内部进行插入排序，即 6 次循环,（x0,x6,x12）,(x1,x7),(x2,x8),(x3,x9),,(x4,x10),(x5,x11)
            // 当 d = 3 ，所以要把 3 组元素内部进行插入排序，即 3 次循环（x0,x3,x6,x9,x12）,(x1,x4,x7,x10),(x2,x5,x8,x11)
            // 当 d = 1 , 所以要把 1 组元素内部进行插入排序，这时候小的元素已经在数组前面,(x0,x1,x2,x3,x4....)
            for (int x = 0; x < interval; x++) {
                // 遍历中进行插入排序
                for (int i = x + interval; i < arr.length; i = i + interval) {
                    int temp = arr[i];
                    int j = i;
                    // 注意这里是 j > interval - 1 ,而不是 j > 0
                    while (j > interval - 1 && temp < arr[j - interval]) {
                        arr[j] = arr[j - interval];
                        j -= interval;
                    }
                    arr[j] = temp;
                }
            }
            if (interval == 1) {
                break;
            }
        }


    }

    /**
     * 快速排序:平均算法速度O（nlogn），最坏情况下的算法速度O（n^2）
     * 建立一个哨兵 key ，一般为数组第一个元素
     * 然后从数组右边开始找，找到比 key 小的数，然后从左边开始找，找到比 key 大的数，交换
     * 把 low = high 的位置和 key 交换，即 key 左边的数比 key 小，右边的数比 key 大
     *
     * @param arr  数组
     * @param low  最低位
     * @param high 最高位
     */
    public static void quickSort(long[] arr, int low, int high) {
        // 递归算法的出口点
        if (low > high) {
            return;
        }
        // 存储哨兵及 low 、high
        int lowPtr = low;
        int highPtr = high;
        long key = arr[low];
        while (lowPtr < highPtr) {
            // 从数组右边开始找，找到比 key 小的数
            while (lowPtr < highPtr && arr[highPtr] > key) {
                highPtr--;
            }
            // 从左边开始找，找到比 key 大的数，这里用 <= 是为了关键字和第一个字相等，所以的话需要 ++ ，从第二个数开始
            while (lowPtr < highPtr && arr[lowPtr] <= key) {
                lowPtr++;
            }
            // 找到了交换
            if (lowPtr < highPtr) {
                swap(arr, lowPtr, highPtr);
            }
        }
        // 确定 key 的位置，把 low = high 的位置和 key 交换，即 key 左边的数比 key 小，右边的数比 key 大
        swap(arr, low, lowPtr);
        // 对 key 左边的数组进行排序
        quickSort(arr, low, lowPtr - 1);
        // 对 key 右边的数组进行排序
        quickSort(arr, lowPtr + 1, high);

    }

    /**
     * 归并排序，先分，再合并
     * 平均算法速度O（nlogn），最坏情况下的算法速度O（nlogn）
     *
     * @param arr  数组
     * @param low  数组的起点
     * @param high 数组的终点
     */
    public static void mergeSort(int[] arr, int low, int high) {
        // 先分中点，分为两个数组
        int middle = (low + high) / 2;
        // 当分的只剩一个数了，递就结束
        if (low < high) {
            // 这是左边数组
            mergeSort(arr, low, middle);
            // 这是右边数组
            mergeSort(arr, middle + 1, high);
            // 归并左右两个数组
            merge(arr, low, middle, high);
        }
    }


    /**
     * 归并排序中合并两个数组
     *
     * @param arr    初始的数组（两个数组的和）
     * @param low    最低点
     * @param middle 中间点
     * @param high   最高点
     */
    private static void merge(int[] arr, int low, int middle, int high) {
        // 左边数组和右边数组比较，哪个数字小就放到大数组当中
        // 不能改变原来数组，因此声明一个大数组
        int[] temp = new int[high - low + 1];
        // 记录大数组的每一个 index ，用于给大数组赋值
        int index = 0;
        // 记录第一个数组的起点位置
        int i = low;
        // 记录第二个数组的起点位置
        int j = middle + 1;
        // 从两个数组拿第一个开始比较，比较完，放到大数组中，直到任意一个数组没有剩余
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 如果第一个数组有剩余
        while (j > high && i <= middle) {
            temp[index++] = arr[i++];
        }
        // 如果第二个数组有剩余
        while (j <= high && i > middle) {
            temp[index++] = arr[j++];
        }
        // 把新数组的数据放回原数组
        for (int k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
        }
    }

    /**
     * 基数排序
     * 第一步：找出最大的数，找出他的数位，比如 103 ，那它有个位十位百位，这个数的位数就是我们等下要比较的次数
     * 第二步：准备 10 个桶（类似的结构）
     * 第三步，找出每个数的个位，放进相应的桶，比如 103 的个位是 3 ，就放到第三个桶里面，全部数放完后，从第一个桶开始取数，一直取，取完为止
     * 第四部：比较每个数的十位....和第三步一样，直到比较百位
     *
     * @param arr 要排序的数组 [12,25,85,258,452,36,1,88,79,754,555,66]
     */
    public static void radixSort(int[] arr) {
        // 找出最大的数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 准备 10 个桶
        int[][] temp = new int[10][arr.length];
        // 记录每个桶数目的数组
        int[] count = new int[10];
        // 找出位数
        int maxLength = (max + "").length();
        // 比较这么多次
        for (int j = 0, m = 1; j < maxLength; j++, m *= 10) {
            // 遍历数组，第一次先求出每个数的个位数，第二次求十位,第三次求百位，所以我们可以，每一次先除以 10 ，之后再取余 10
            for (int k = 0; k < arr.length; k++) {
                int remainder = arr[k] / m % 10;
                // 放进桶中
                temp[remainder][count[remainder]] = arr[k];
                // 每放进一个数，计数 ++
                count[remainder]++;
            }
            // 每次把数取出来存到原来数组的位置
            int index = 0;
            // 遍历计数的数组
            for (int z = 0; z < count.length; z++) {
                // 表明数组 z 位置上的桶有数据，取出来，从上往下取（其实这里刚好是先进先出可以用队列来完成）
                if (count[z] != 0) {
                    for (int l = 0; l < count[z]; l++) {
                        arr[index] = temp[z][l];
                        index++;
                    }
                    count[z] = 0;
                }
            }

        }
    }

    /**
     * 基数排序队列实现
     * 第一步：找出最大的数，找出他的数位，比如 103 ，那它有个位十位百位，这个数的位数就是我们等下要比较的次数
     * 第二步：准备 10 个队列（类似的结构）
     * 第三步，找出每个数的个位，放进相应的队列，比如 103 的个位是 3 ，就放到第三个队列里面，全部数放完后，从第一个队列开始取数，一直取，取完为止
     * 第四步：比较每个数的十位....和第三步一样，直到比较百位
     *
     * 分配的时间复杂度为 O（n），收集的的时间复杂度为 O（radix），分配和收集共需要 distance 趟，所以基数排序的时间复杂度为O(d(n+r))
     *
     * @param arr 要排序的数组 [12,25,85,258,452,36,1,88,79,754,555,66]
     */
    public static void radixSortByQueue(long[] arr) {
        // 找出最大的数
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 准备 10 个队列
        Queue[] queues = new Queue[10];
        for (int q = 0; q < 10; q++) {
            queues[q] = new Queue(arr.length);
        }
        // 找出位数
        int maxLength = (max + "").length();
        // 比较这么多次
        for (int j = 0, m = 1; j < maxLength; j++, m *= 10) {
            // 遍历数组，第一次先求出每个数的个位数，第二次求十位,第三次求百位，所以我们可以，每一次先除以 10 ，之后再取余 10
            for (int k = 0; k < arr.length; k++) {
                int remainder = (int) arr[k] / m % 10;
                // 放进队列中
                queues[remainder].insert(arr[k]);
            }
            // 每次把数取出来存到原来数组的位置
            int index = 0;
            // 遍历队列的数组
            for (int z = 0; z < 10; z++) {
                // 表明数组 z 位置上的桶有数据，取出来，从上往下取（其实这里刚好是先进先出可以用队列来完成）
                if (!queues[z].isEmpty()) {
                    while (!queues[z].isEmpty()) {
                        arr[index] = queues[z].remove();
                        index++;
                    }
                }
            }

        }
    }


    /**
     * 堆排序：这里是大顶堆排序，平均算法速度O（nlogn），最坏情况下的算法速度O（nlogn）
     * 1. 先把一个数组（前面 n 个数）变成大顶堆数组（从最后一个节点的父节点开始调节）
     * 2. 变成大顶堆后，交换数组第一个数和最后一个数
     * 3. 再把数组前面 0-n-1 个数变成大顶堆（这时候从数组的第一个数开始调节）
     * 4. 交换数组第一个数和第 n-1 个数
     *
     * @param arr 排序的数组: 3 9 10 7 18 5 17 8 9
     */
    public static void heapSort(int[] arr) {
        // 首先，把这个数组变成大顶堆,先从最后一个节点的父子节点开始
        int start = (arr.length - 2) / 2;
        // 大顶堆：18, 9, 17, 8, 9, 5, 10, 3, 7
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        // 交换数组第一个数和最后一个数:交换 18 和 7. 数组：7, 9, 17, 8, 9, 5, 10, 3, 18
        // ...循环吧前面的数变大顶堆，和循环交换
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 交换之后，数组第一个数改变了，数组失去大顶堆效果，所以每次都要调节第一个数为大顶堆
            maxHeap(arr, i, 0);

        }
    }

    /**
     * 把一个数组变成大顶堆，每次从 index 元素开始，不能超 size （最大元素数量）
     * 数组：3 9 10 7 18 5 17 8 9
     *
     * @param arr   变成大顶堆的数组
     * @param size  数组元素的数量
     * @param index 从 index 元素开始转换大顶堆：每次都是从最后一个节点的父子节点开始，即 9 的父节点为 7
     */
    private static void maxHeap(int[] arr, int size, int index) {
        // 从 index 元素开始转换大顶堆：每次都是从最后一个节点的父子节点开始
        // 把 index 这个父子节点和左右孩子节点相比较，找出最大的元素，放在父节点，即大顶堆的模式
        // 声明 max 为最大值,例子中 arr[index] 为 7
        int max = index;
        // 比较左孩子，左孩子为 8
        int leftChild = 2 * index + 1;
        if (leftChild < size && arr[max] < arr[leftChild]) {
            max = leftChild;
        }
        // 比较右孩子，右孩子为 9
        int rightChild = 2 * index + 2;
        if (rightChild < size && arr[max] < arr[rightChild]) {
            max = rightChild;
        }
        // 找出最大的元素，交换，max=9,arr[index]=7 ，9 到了父节点，7 到了右孩子
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            // 这里有种情况，有可能交换完，发现 7 比它的子节点要小，所以递归调用 maxHeap （交换完这里的 7 元素是没有子节点，但是这一步是用于之后其他元素交换完会出现的情况）
            maxHeap(arr, size, max);
        }


    }

    /**
     * 桶排序
     * 1. 创建多少桶，确定桶区间（桶的数量是数组元素数量），总结构是一个数组链表
     * 2. 遍历原始数列，把元素对号入座放入各个桶中。
     * 3. 每个桶内部的元素分别排序。
     * 4. 遍历所有的桶，输出所有元素。
     *
     * @param arr {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09}
     */
    public static double[] bucketSort(double[] arr) {
        // 创建桶
        ArrayList<LinkedList<Double>> linkedLists = new ArrayList<LinkedList<Double>>(arr.length);
        // 初始化桶
        for (int i = 0; i < arr.length; i++) {
            linkedLists.add(new LinkedList<Double>());
        }
        // 求出最大值和最小值
        double max = 0;
        double min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 求出最大值和最小值之差
        double d = max - min;
        // 遍历原始数列，把元素对号入座放入各个桶中。
        for (int i = 0; i < arr.length; i++) {
            // 放进哪个桶
            int num = (int) ((arr[i] - min) * (arr.length - 1) / d);
            linkedLists.get(num).add(arr[i]);
        }
        // 每个桶内部的元素分别排序
        for (LinkedList<Double> linkedList : linkedLists) {
            // Collections.sort 内部也是用了 list.sort, 底层又是使用了 Arrays.sort ，
            // 这时候 JDK 底层采用了归并排序或归并的优化版本 TimSort(里面又用了 binarySort) ,一种时间复杂度 O（nlogn）的排序。
            Collections.sort(linkedList);
        }
        int index = 0;
        // 遍历所有的桶，输出所有元素
        for (LinkedList<Double> linkedList : linkedLists) {
            // 这里也等效于 linkedList 的 foreach 循环，也是从头结点遍历的 for (double element : linkedList) {arr[index++] = element;}
            while (!linkedList.isEmpty()) {
                // 从头结点不断取出元素，此方法等效于 removeFirst()。
                arr[index++] = linkedList.pop();
            }
        }
        return arr;
    }


    /**
     * 计数排序：时间复杂度：O(N),额外空间复杂度：O(N),是否可实现稳定性：否
     * 1. 选出数组中最大的数
     * 2. 新建一个新数组 count[] ，长度就为最大的数 + 1
     * 3. 遍历 arr 数组，找到元素 i 在新数组的下标 i ，然后 count[i]++ , 多个相同元素多个 ++
     * 4. 遍历 count[] 数组，当 count[i] 不为 0 ，即元素个数不为 0 ，就可以取出相应的元素 i 存到 arr 数组中
     *
     * @param arr 排序的数组  8 6 7 2 4 9 12 8
     */
    public static void countSort(int[] arr) {
        // 记录最大数，初始值 int 最小值 -2^31
        int max = Integer.MIN_VALUE;
        // 求出最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 新建一个新数组 count[] ，长度就为最大的数 + 1
        int[] count = new int[max + 1];
        // 找到 arr 数组中每一个元素 x 在新数组的下标 x，然后 count[i]++，记录此元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        // 遍历 count[] 数组，取出元素
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                count[i]--;
                arr[index++] = i;
            }
        }
    }


    /**
     * 快排分区(暂时不用)：关键字 key 一般找数组第一个元素
     * 从左边开始找，找到比 key 大的数，然后从右边开始找，找到比 key 小的数，然后交换，
     * 当 low = high 的时候，key 的左边都比 key 小，右边都比 key 大
     */
//    public static int partition(long[] arr, int low, int high) {
//        int lowPtr = low;
//        int highPtr = high;
//        // 取出关键字，即哨兵
//        long key = arr[low];
//        while (lowPtr < highPtr) {
//            // 从右边开始找，找到比 key 小的元素
//            while (lowPtr < highPtr && key < arr[highPtr]) {
//                highPtr--;
//            }
//            // 从左边开始找，找到比 key 大的元素
//            while (lowPtr < highPtr && key > arr[lowPtr]) {
//                lowPtr++;
//            }
//            // 如果左边索引等于右边索引，说明已经左右索引相遇了，断开循环
//            // 比 key 大的元素和比 key 小的元素交换元素
//            // swap(arr, low, high);
//            if (lowPtr < highPtr) {
//                long temp = arr[lowPtr];
//                arr[lowPtr] = arr[highPtr];
//                arr[highPtr] = temp;
//            }
//
//        }
//        // 交换 key 和
//        long temp = arr[lowPtr];
//        arr[lowPtr] = arr[low];
//        arr[low] = temp;
//        return lowPtr;
//    }
//

    /**
     * 快排分区(暂时不用)：关键字 key 一般找数组第一个元素
     * 从右边开始找，找到比 key 小的数,交换; 从左边开始找，找到比 key 大的数，交换，
     * 当 low = high 的时候，key 的左边都比 key 小，右边都比 key 大
     */
//    public static int partition(long[] arr, int low, int high) {
//        long key = arr[low];
//        while (low < high) {
//            // 从右边开始找，找到比 key 小的数,交换
//            while (low < high && arr[high] > key) {
//                high--;
//            }
//            // 从左边开始找，找到比 key 大的数，交换
//            while (low < high && arr[low] < arr[--highPtr]) {
//
//            }
//            // 如果左边索引等于右边索引，说明已经左右索引相遇了，断开循环
//
//        }
//        return lowPtr;
//    }
//    public static void quickSort(long[] arr, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//        // 取出 low 和 high 相等的位置，即 key 最终中心的位置
//        int partition = partition(arr, low, high);
//        // 对 key 左边的数组进行排序
//        quickSort(arr, low, partition - 1);
//        // 对 key 右边的数组进行排序
//        quickSort(arr, partition + 1, high);
//
//    }
//    public static void swap1(int[] array, int arr0, int arr1) {
//        int temp = array[arr0];
//        array[arr0] = array[arr1];
//        array[arr1] = temp;
//    }
//
//    public static void swap2(int[] array, int arr0, int arr1) {
//        array[arr0] = array[arr0] + array[arr1];
//        array[arr1] = array[arr0] - array[arr1];
//        array[arr0] = array[arr0] - array[arr1];
//    }
//
//    public static void swap3(int[] array, int arr0, int arr1) {
//        array[arr0] = array[arr0] ^ array[arr1];
//        array[arr1] = array[arr0] ^ array[arr1];
//        array[arr0] = array[arr0] ^ array[arr1];
//    }
//
//    /**
//     * 60      * 交换数组元素
//     * 61      * @param arr
//     * 62      * @param a
//     * 63      * @param b
//     * 64
//     */
//    public static void swap(int[] arr, int a, int b) {
//        arr[a] = arr[a] + arr[b];
//        arr[b] = arr[a] - arr[b];
//        arr[a] = arr[a] - arr[b];
//    }

    public static void display(int[] arr0) {
        for (int i = 0; i < arr0.length; i++) {
            System.out.print(arr0[i] + " ");
        }
        System.out.println("");
    }

    public static void swap(long[] arr, int high, int low) {
        long temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }


    public static void main(String[] args) {
//        double[] a = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        //long[] a = {12, 25, 85, 25, 45, 36, 1, 88, 79, 75, 555, 6};
        long[] a = {19,15,12,18,21,36,45,10};
        System.out.println("排序之前：" + Arrays.toString(a));
//        System.out.println(findKthLargest(a,5));
        quickSort(a,0,a.length-1);

      System.out.println("排序之后：" + Arrays.toString(a));
    }

}
