package com.yunfu.leaf.algorithm.tree.model.AVLTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 平衡二叉树
 * @date: 2018-12-25
 * @time: 18:40
 */
public class AVLTree {
    /**
     * 根结点
     */
    public AVLTreeNode root;

    /**
     * 插入结点
     *
     * @param data 要插入的结点
     */
    public void insert(int data) {
        this.root = insert(data, root);
    }

    /**
     * 递归插入:理解不了，可以从只有一个结点（根结点 4）开始执行代码 ，插入 3 结点之后，再插入 5 结点
     *
     * @param data 要插入的结点
     */
    public AVLTreeNode insert(int data, AVLTreeNode node) {
        // 如果节点为 null ，说明没有孩子，就可以创建新结点
        if (node == null) {
            node = new AVLTreeNode(data);
        }

        // 如果插入值比根节点小，就往左子树插入，如果理解不了，可以从只有一个结点（根结点 4）开始执行代码 ，插入 3 结点之后，再插入 5 结点
        if (data < node.data) {
            // 因为这是从左子树插入的，当创建完子节点之后，那么他一定是根结点的左孩子
            node.leftNode = insert(data, node.leftNode);
            // 如果左子树的高度 - 右子树的高度为 2 （因为这个是插入左边，所以左子树肯定高）
            if (height(node.leftNode) - height(node.rightNode) == 2) {
                // 判断插入的是左孩子还是右孩子，插入左孩子就是右旋，插入右孩子就是 LR
                if (data < node.leftNode.data) {
                    // 右旋,插入左孩子的左子树，返回新的根结点
                    node = rightRotate(node);
                } else {
                    // LR : 先左旋，后右旋
                    node = leftRightRotate(node);
                }
            }

        }
        // 如果插入值比根节点大，就往右子树插入
        if (data > node.data) {
            // 因为这是右子树插入的，当创建完子节点之后，那么他一定是根结点的右孩子
            node.rightNode = insert(data, node.rightNode);
            // 如果左子树的高度 - 右子树的高度为 2 （因为这个是插入左边，所以左子树肯定高）
            if (height(node.rightNode) - height(node.leftNode) == 2) {
                // 判断插入的是左孩子还是右孩子，插入左孩子就是 RL ，插入右孩子就是左旋
                if (data > node.rightNode.data) {
                    // 左旋,插入右孩子的右子树，返回新的根结点
                    node = leftRotate(node);
                } else {
                    // RL : 先右旋，后左旋
                    node = rightLeftRotate(node);
                }
            }

        }
        //重新计算各个结点的高度
        node.height = Math.max(height(node.leftNode), height(node.rightNode)) + 1;
        // 返回根节点
        return node;
    }

    /**
     * RL : 新增节点插入根节点的右节点的左子树，先右旋，后左旋
     * 右旋：先找到最近的不平衡结点，然后对其右子树右旋。
     * 左旋：对不平衡结点左旋
     *
     * @param node 结点
     * @return 根结点
     */
    private AVLTreeNode rightLeftRotate(AVLTreeNode node) {
        // 先右旋: 右旋后，不平衡结点的右子树要赋值
        node.rightNode = rightRotate(node.rightNode);
        // 再左旋
        return leftRotate(node);
    }

    /**
     * 左旋：新增节点插入根节点的右节点的右子树
     *
     * @param node 结点
     * @return 根结点
     */
    private AVLTreeNode leftRotate(AVLTreeNode node) {
        // 取到右孩子
        AVLTreeNode rightNode = node.rightNode;
        // 右孩子的左节点为根结点的右孩子
        node.rightNode = rightNode.leftNode;
        // 右孩子的左孩子为根结点
        rightNode.leftNode = node;
        // 重新计算 node/leftNode 的高度
        node.height = Math.max(height(node.leftNode), height(node.rightNode)) + 1;
        // node 就是 rightNode 的左孩子，下面代码和此：height(x.leftNode), height(x.rightNode) 代码一样
        rightNode.height = Math.max(node.height, height(rightNode.leftNode)) + 1;
        // 返回新根结点
        return rightNode;
    }

    /**
     * LR 型：先左旋后右旋
     * 左旋：先找到最近的不平衡结点，然后对其左子树左旋。
     * 右旋：对不平衡结点右旋
     *
     * @param node 结点
     */
    private AVLTreeNode leftRightRotate(AVLTreeNode node) {
        // 先左旋: 左旋后，不平衡结点的左子树要赋值
        node.leftNode = leftRotate(node.leftNode);
        // 再右
        return rightRotate(node);
    }

    /**
     * 右旋：新增节点插入根节点的左节点的左子树
     *
     * @param node 从此结点开始右旋
     */
    private AVLTreeNode rightRotate(AVLTreeNode node) {
        // 取到左孩子
        AVLTreeNode leftNode = node.leftNode;
        // 左孩子的右节点为根结点的左孩子
        node.leftNode = leftNode.rightNode;
        // 左孩子的右孩子为根结点
        leftNode.rightNode = node;
        // 重新计算 node/leftNode 的高度
        node.height = Math.max(height(node.leftNode), height(node.rightNode)) + 1;
        // node 就是 leftNode 的右孩子，下面代码和此：height(x.leftNode), height(x.rightNode) 代码一样
        leftNode.height = Math.max(height(leftNode.leftNode), node.height) + 1;
        // 返回新根结点
        return leftNode;

    }

    /**
     * 求一个结点的高度
     *
     * @param node 结点
     * @return 高度
     */
    public int height(AVLTreeNode node) {
        return node == null ? -1 : node.height;

    }


    /**
     * 先序遍历：根左右
     * 其实是先访问 node.data ，再访问左子树，也是 node.data ,再访问右子树
     *
     * @param node 二叉树根节点
     */
    public void preOrderTraverse(AVLTreeNode node) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问根节点
            System.out.println("数据：" + node.data);
            // 再访问左子树
            preOrderTraverse(node.leftNode);
            // 再访问右子树
            preOrderTraverse(node.rightNode);
        }

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
    public List<List<String>> printTree(AVLTreeNode root) {
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
    public void traverseFill(AVLTreeNode root, List<List<String>> list, int row, int height, int i, int j) {
        // 如果根节点为 null ，或者遍历到最后一层，结束
        if (root == null || row == height) {
            return;
        }
        // 赋值，把根节点的元素值赋值到 ( 左边加右边 / 2 )的位置
        list.get(row).set((i + j) / 2, String.valueOf(root.data));
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
    public int getHeight(AVLTreeNode root) {
        // 如果是空树，返回 0
        if (root == null) {
            return 0;
        }
        // 遍历其左子树,得到左子树的高度
        int left = getHeight(root.leftNode);
        // 遍历其右子树,得到右子树的高度
        int right = getHeight(root.rightNode);
        // + 1 是为了当节点（root.leftChild | root.rightChild）为 null ，返回父节点，那么层数就加一，其实就是左子树和右子树的最大高度加上根节点
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // 验证 LR
//        tree.insert(8);
//        tree.insert(5);
//        tree.insert(12);
//        tree.insert(3);
//        tree.insert(6);
//        tree.insert(7);

        // 验证 RL
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        tree.insert(5);
        List<List<String>> lists1 = tree.printTree(tree.root);
        for (List<String> list : lists1) {
            System.out.println(list);
        }
    }


}
