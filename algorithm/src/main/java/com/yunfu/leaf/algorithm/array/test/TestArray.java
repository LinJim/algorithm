package com.yunfu.leaf.algorithm.array.test;

import com.yunfu.leaf.algorithm.sort.SortUtil;

import java.util.ArrayList;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 初始化和创建数组测试
 * @date: 2018-09-03
 * @time: 19:57
 */
public class TestArray {
    private int length;
    private Integer length1;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Integer getLength1() {
        return length1;
    }

    public void setLength1(Integer length1) {
        this.length1 = length1;
    }

    public static void main(String arg[]) {
        // 测试初始化数组的三种方式，不初始化的数组元素值为 0
        int[] arr = new int[10];
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        int[] arr1 = new int[]{1, 2, 3, 4};
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);

        int[] arr3 = {};
        int[] arr4 = {};
        int[] arr5 = null;
        int[] arr6 = {1, 2, 3};
        int[] arr7 = {1, 2, 3};
        //System.out.println(arr3[0]);
        //System.out.println(arr3[1]);

        // jdk 8 ArrayList 的创建，不指定具体容量的构造方法，构造的内部为空数组
        ArrayList arrayList = new ArrayList();
        // System.out.println("arrayList.get(0): "+arrayList.get(0));
        // System.out.println("arrayList.get(1): "+arrayList.get(1));
        System.out.println("arrayList.size: " + arrayList.size());

        // 整形相除，四舍五入
        int i = 5 / 2;
        System.out.println(i);

//        System.out.println(arr3.equals(arr4));
//        System.out.println(arr3.equals(arr5));
//        System.out.println(arr6.equals(arr7));


        // 测试交换:不能测试 地址没变
        //int a = 3, b = 4;
        int[] a = {3, 4};
        //SortUtil.swap1(a,0, 1);
       // System.out.println("a[0]: " + a[0] + "," + "a[1]: " + a[1]);

//        SortUtil.swap2(a, b);
//        System.out.println("a: " + a + "," + "b: " + b);
//
//        SortUtil.swap3(a, b);
//        System.out.println("a: " + a + "," + "b: " + b);


        int[] a2 = {8, 3, 4, 15, 88, 2, 48, 55, 77, 25, 99};
        SortUtil.display(a2);
        //SortUtil.bubbleSort(a2);
        SortUtil.insertSort(a2);
        //SortUtil.selectSort(a2);
        //SortUtil.bubbleSort2(a2);
        SortUtil.display(a2);
//        Arrays.sort(a2);
//        SortUtil.display(a2);
    }

}
