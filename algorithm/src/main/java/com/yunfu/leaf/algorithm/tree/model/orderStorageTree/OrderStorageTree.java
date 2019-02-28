package com.yunfu.leaf.algorithm.tree.model.orderStorageTree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 顺序存储的二叉树：其实任何一颗二叉树都可以变成数组的形式，即顺序存储结构，
 * @description: 但是呢，一些二叉树并不是完全二叉树，变成数组的时候，例如：{1,5,7，null,8,9},数组的顺序存储被中间的 null 元素破坏了
 * @description: 所以顺序存储的二叉树一般是讨论完全二叉树的形式
 * @date: 2018-12-14
 * @time: 19:41
 */
public class OrderStorageTree {
    // 节点都是用数组来存储
    public int[] arr;

    public OrderStorageTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 先序遍历：根左右，利用了完全二叉树第 n 个元素的左节点 2*n+1 ，父子节点为 (n-1)/2
     * 补充：其实完全二叉树的数组形式就是完全二叉树的层次遍历：2 5 8 9 7                  2
     *                                                                                 5     8
     *                                                                               9   7
     *
     * @param index 就是从哪个节点开始遍历
     */
    public void preOrderTraverse(int index) {
        // 如果当前索引（一般从根节点开始遍历，即 index = 0）不越界
        if (index < arr.length && index >= 0) {
            // 先访问根节点
            System.out.println("数据：" + arr[index]);
            // 再访问左子树
            preOrderTraverse(2 * index + 1);
            // 再访问右子树
            preOrderTraverse(2 * index + 2);
        }
    }
}
