package com.yunfu.leaf.algorithm.greedyAlg;

import java.util.Arrays;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 贪心算法: 1. 分配饼干
 * @date: 2019-01-02
 * @time: 12:55
 */
public class GreedyAlgorithm {

       /**
     * Input: 孩子数组 [1,2], 饼干数组[1,2,3], 输出两个孩子满足 Output: 2
     * @param children 孩子数组
     * @param cookies 饼干数组
     * @return 输出被满足孩子的数量
     */
    public static int findContentChildren(int[] children, int[] cookies) {
        // 设定两个指针，一个指向孩子数组，另一个指向饼干数组
        int i=0;
        int j=0;
        // 前提下孩子数组和饼干数组要有序
        Arrays.sort(children);
        Arrays.sort(cookies);
        while (i<children.length&&j<cookies.length){
            // 如果满足，孩子数组指针就 ++
            if(children[i]<=cookies[j]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] children={2,1};
        int[] cookies={3,1,2};
        System.out.println(findContentChildren(children,cookies));
    }


}
