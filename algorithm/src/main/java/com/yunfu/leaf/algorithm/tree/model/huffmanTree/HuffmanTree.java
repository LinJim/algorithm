package com.yunfu.leaf.algorithm.tree.model.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 哈夫曼树：例子数组：3 7 8 29 5 11 23 14
 * @date: 2018-12-18
 * @time: 10:32
 */
public class HuffmanTree {

    /**
     * 构建哈夫曼树
     *
     * @param arr {3, 7 ,9, 29, 5 ,11 ,23, 14} // 其实这个 nodes 的移除操作有点问题，比如数组里面有一个 3 5 8，,3+5=8 元素重复了，这个树打印会出问题，所以先不用重复数字
     * @return HuffmanTreeNode 返回根节点
     */
    public HuffmanTreeNode createHuffmanTree(int[] arr) {
        // 先初始化数组，初始化每一个数为只有一个节点的二叉树，放进 list 集合中
        List<HuffmanTreeNode> nodes = new ArrayList<HuffmanTreeNode>();
        for (int i : arr) {
            nodes.add(new HuffmanTreeNode(i));
        }
        while (nodes.size() > 1) {
            // 排序:从小到大（[3, 5, 7, 8, 11, 14, 23, 29]）
            Collections.sort(nodes);
            //System.out.println(nodes.stream().map(node->node.value).collect(toList()));

            // 选出最小的两个二叉树，值相加，创建一个新的二叉树（根节点为最小二叉树根节点的和）
            HuffmanTreeNode left = nodes.get(0);
            HuffmanTreeNode right = nodes.get(1);
            HuffmanTreeNode newNode = new HuffmanTreeNode(left.value + right.value);
            // 设置两个二叉树为新的节点的左右孩子
            newNode.leftNode = left;
            newNode.rightNode = right;

            // 集合移除最小的两个二叉树，注意：nodes.remove(0);nodes.remove(1); 这里不能这么写，因为底层是旧的数组从 index+1 位的数移到新数组的 index 位开始，所以第二句删除第二个元素就错误了，应该还是删除新数组的第一个元素
            nodes.remove(left);
            nodes.remove(right);
            // 集合添加新的二叉树
            nodes.add(newNode);
            // 循环
        }
        // 返回唯一元素，即树的根节点
        return nodes.get(0);
    }


    /**
     * 二叉树打印：给定二叉树，返回按期规定形式返回，即每层位置均保留上下层结构
     * [, , , , , , , 40, , , , , , , ]
     * [, , , 10, , , , , , , , 55, , , ]
     * [, 2, , , , 21, , , , 44, , , , 65, ]
     * [, , , , 20, , 30, , , , , , , , ]
     *
     * @param root 二叉树根节点
     */
    public List<List<String>> printTree(HuffmanTreeNode root) {
        // 通过格式确定数据结构，List<List<String>>, List<List<String>> 这个是树，List<String> 是树的每一层
        List<List<String>> list = new ArrayList<>();
        // 确定树有几层，即 List<List<String>> ，里面有多少 list
        int height = getHeight(root);
        // 确定每一个 list 有多长,长度都是 2 的 height 次方 -1，
        // 刚好是一棵树最多元素个数，因为最大层要算上空格，再加上满元素，刚好为一棵树最多元素个数
        int length = (int) Math.pow(2, height) - 1;
        // 先往 list 数组里面填充元素
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 填充一行 "",即 [, , , , , , , , , , , , , , ]
            subList.add("");
        }
        // 为 List<List<String>> 即树，添加层数
        for (int i = 0; i < height; i++) {
            // 填充整个数据，即变成
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            list.add(new ArrayList<>(subList));
        }
        // 递归，遍历填充元素到数组中，每次都是数组最左边加最右边 /2 ,当遍历到最后一层或者 root 根节点为 null ，结束
        traverseFill(root, list, 0, height, 0, length - 1);
        return list;
    }

    /**
     * 递归，遍历填充元素到数组中，每次都是数组最左边加最右边/2 ,当遍历到最后一层或者 root 根节点为 null ，结束
     *
     * @param root   根节点
     * @param list   存储数据的数组
     * @param row    开始层数
     * @param height 结束的层数
     */
    public void traverseFill(HuffmanTreeNode root, List<List<String>> list, int row, int height, int i, int j) {
        // 如果根节点为 null ，或者遍历到最后一层，结束
        if (root == null || row == height) {
            return;
        }
        // 赋值，把根节点的元素值赋值到 ( 左边加右边 / 2 )的位置
        list.get(row).set((i + j) / 2, String.valueOf(root.value));
        // 填充左子树
        traverseFill(root.leftNode, list, row + 1, height, i, (i + j) / 2 - 1);
        // 填充右子树
        traverseFill(root.rightNode, list, row + 1, height, (i + j) / 2 + 1, j);
    }

    /**
     * 得到树的高度
     *
     * @param root 二叉树根节点
     * @return 数的高度
     */
    public int getHeight(HuffmanTreeNode root) {
        // 如果是空树，返回 0
        if (root == null) {
            return 0;
        }
        // 遍历其左子树,得到左子树的高度
        int left = getHeight(root.leftNode);
        // 遍历其右子树,得到右子树的高度
        int right = getHeight(root.rightNode);
        // + 1 是为了当节点（root.leftChild | root.rightChild）为 null ，返回父节点，那么层数就加一
        return Math.max(left, right) + 1;
    }


}
