package com.yunfu.leaf.algorithm.tree.model.binaryOrderTree;

import com.yunfu.leaf.algorithm.tree.model.AVLTree.AVLTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二叉树，其实这里面实现的是二叉查找树，不是普通二叉树
 * @date: 2018-10-26
 * @time: 1:34
 */
public class BinaryTree {
    // 根节点
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 插入节点
     *
     * @param value 节点值
     */
    public void insert(long value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        BinaryTreeNode current = root;
        BinaryTreeNode parent;
        // 如果当前没有根节点，新插入节点为根节点
        if (root == null) {
            // 此处不能写成 current = node，current 只是引用，他会被垃圾回收器回收，下一个 insert ，current 被回收，
            // root == null 了
            root = node;
            return;
        }
        while (true) {
            // 父节点为现在节点
            parent = current;
            // 如果当前节点的值比插入值小，放在二叉查找树右子树，往右边遍历
            if (current.data < value) {
                // 当前节点为右孩子节点
                current = current.rightChild;
                // 右孩子节点为 null , 那就可以赋值给右孩子
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            } else {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = node;
                    return;
                }
            }
        }
    }

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
    public BinaryTreeNode insert(int data, BinaryTreeNode node) {
        // 如果节点为 null ，说明没有孩子，就可以创建新结点
        if (node == null) {
            node = new BinaryTreeNode(data);
        }

        // 如果插入值比根节点小，就往左子树插入，如果理解不了，可以从只有一个结点（根结点 4）开始执行代码 ，插入 3 结点之后，再插入 5 结点
        if (data < node.data) {
            // 因为这是从左子树插入的，当创建完子节点之后，那么他一定是根结点的左孩子
            node.leftChild = insert(data, node.leftChild);

        }
        // 如果插入值比根节点大，就往右子树插入
        if (data > node.data) {
            // 因为这是右子树插入的，当创建完子节点之后，那么他一定是根结点的左孩子
            node.rightChild = insert(data, node.rightChild);
        }
        // 返回根节点
        return node;
    }



    /**
     * 查找节点
     *
     * @param value 需要查找值
     * @return
     */
    public BinaryTreeNode find(long value) {
        // 记录当前节点,从根节点开始
        BinaryTreeNode current = root;
        // 如果节点为 null ，return null
        if (root == null) {
            return null;
        }
        // 如果一直不等于，一直循环找元素，直到找到值
        while (current.data != value) {
            // 如果当前节点的数据比查找值大，就往左孩子遍历
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    /**
     * 先序遍历查找节点：根左右
     * 其实是先访问 node.data ，再访问左子树，也是 node.data ,再访问右子树
     *
     * @param node 二叉树根节点
     */
    public void preOrderTraverseSearch(BinaryTreeNode node, long searchData) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问根节点
            if (searchData == node.data) {
                System.out.println("数据：" + node.data);
            }
            // 再访问左子树
            preOrderTraverseSearch(node.leftChild, searchData);
            // 再访问右子树
            preOrderTraverseSearch(node.rightChild, searchData);
        }
    }

    /**
     * 先序遍历：根左右
     * 其实是先访问 node.data ，再访问左子树，也是 node.data ,再访问右子树
     *
     * @param node 二叉树根节点
     */
    public void preOrderTraverse(BinaryTreeNode node) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问根节点
            System.out.println("数据：" + node.data);
            // 再访问左子树
            preOrderTraverse(node.leftChild);
            // 再访问右子树
            preOrderTraverse(node.rightChild);
        }

    }


    /**
     * 中序遍历：左根右,其实因为是二叉查找数，左小右大，所以中序遍历相当于有序数组遍历：2,10,20,21,30.....
     * 其实是访问 node 叶子节点 node.leftChild==null，就可以访问 node.data，node.rightChild==null，就可以访问 node 的父类节点
     *
     * @param node 二叉树根节点
     */
    public void inOrderTraverse(BinaryTreeNode node) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问左子树
            inOrderTraverse(node.leftChild);
            // 再访问根节点
            System.out.print("数据：" + node.data + " ");
            // 再访问右子树
            inOrderTraverse(node.rightChild);
        }
    }

    /**
     * 后序遍历：左右根
     * 其实是访问 node 叶子节点 node.leftChild==null，node.rightChild==null，就可以访问 node.data
     *
     * @param node 二叉树根节点
     */
    public void afterOrderTraverse(BinaryTreeNode node) {
        // 如果二叉树根节点不为 null
        if (node != null) {
            // 先访问左子树
            afterOrderTraverse(node.leftChild);
            // 再访问右子树
            afterOrderTraverse(node.rightChild);
            // 再访问根节点
            System.out.println("数据：" + node.data);
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
    public List<List<String>> printTree(BinaryTreeNode root) {
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
    public void traverseFill(BinaryTreeNode root, List<List<String>> list, int row, int height, int i, int j) {
        // 如果根节点为 null ，或者遍历到最后一层，结束
        if (root == null || row == height) {
            return;
        }
        // 赋值，把根节点的元素值赋值到 ( 左边加右边 / 2 )的位置
        list.get(row).set((i + j) / 2, String.valueOf(root.data));
        // 填充左子树
        traverseFill(root.leftChild, list, row + 1, height, i, (i + j) / 2 - 1);
        // 填充右子树
        traverseFill(root.rightChild, list, row + 1, height, (i + j) / 2 + 1, j);
    }

    /**
     * 得到树的高度
     *
     * @param root 二叉树根节点
     * @return 数的高度
     */
    public int getHeight(BinaryTreeNode root) {
        // 如果是空树，返回 0
        if (root == null) {
            return 0;
        }
        // 遍历其左子树,得到左子树的高度
        int left = getHeight(root.leftChild);
        // 遍历其右子树,得到右子树的高度
        int right = getHeight(root.rightChild);
        // + 1 是为了当节点（root.leftChild | root.rightChild）为 null ，返回父节点，那么层数就加一，其实就是左子树和右子树的最大高度加上根节点
        return Math.max(left, right) + 1;
    }


    /**
     * 删除二叉树结点
     * 1. 先找出要删除的节点
     * 2. 删除的节点如果是叶子节点，直接让父节点的左孩子或者右孩子为 null 就可以
     * 3. 删除的节点如果是仅有一个孩子的，直接让他的父节点链接他的孩子
     * 4. 删除的节点如果是有左右孩子的，使用它的中序后继来替代该节点。
     *
     * @param value 要删除节点
     * @return 删除成功或者失败
     */
    public boolean delete(long value) {
        // 先找出要删除节点
        BinaryTreeNode current = root;
        // 为了下一步的删除，定义父节点
        BinaryTreeNode parent = root;
        boolean isLeftChild = true;
        // 循环条件为找不到，断开循环就是找到了
        while (current.data != value) {
            parent = current;
            // 查询的值比父节点小，就往左子树遍历
            if (current.data > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            // 没有找到
            if (current == null) {
                return false;
            }
        }
        // 如果删除的节点是叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            // 就要另父节点的左孩子或者右孩子为 null，需要父节点的引用还有 current 节点是否为左右节点的依据
            if (current == root) { // 如果是根节点，直接置 null
                root = null;
            } else if (isLeftChild) { // 如果是左孩子，父节点的左孩子置 null
                parent.leftChild = null;
            } else {// 如果是右孩子，父节点的右孩子置 null
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {// 如果删除的节点有一个左孩子或者有一个右孩子
            // 左孩子为 null ，一定有右孩子
            if (current == root) {// 如果是根节点，根节点为右孩子
                root = current.rightChild;
            } else if (isLeftChild) {// 如果被删除节点是左孩子，那么父节点的左孩子就为当前节点的右孩子
                parent.leftChild = current.rightChild;
            } else {// 如果被删除节点是右孩子，那么父节点的右孩子就为当前节点的右孩子
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            // 右孩子为 null ，一定有左孩子
            if (current == root) {// 如果是根节点，根节点为z左孩子
                root = current.leftChild;
            } else if (isLeftChild) {// 如果被删除节点是左孩子，那么父节点的左孩子就为当前节点的左孩子
                parent.leftChild = current.leftChild;
            } else {// 如果被删除节点是右孩子，那么父节点的右孩子就为当前节点的左孩子
                parent.rightChild = current.leftChild;
            }
        } else {
            // 找出后继节点
            BinaryTreeNode successor = getSuccessor(current);
            if (current == root) {// 如果是根节点,根节点就为 successor
                root = successor;
            } else if (isLeftChild) {// 如果被删除节点是左孩子,父节点的左孩子就为后继节点
                parent.leftChild = successor;
            } else {// 如果被删除节点是右孩子,父节点的右孩子就为后继节点
                parent.rightChild = successor;
            }
            // 上面 successor 和 被删除节点替换掉之后，successor 的左子树和右子树为被删除节点的的左子树和右子树
            successor.leftChild = current.leftChild;
            // successor.rightChild=current.rightChild;
            // 这里注释掉，因为当你直接指定后继节点的右孩子为被删除节点的右孩子时，逻辑上没错，但是你忽略一个点，如果后继节点还有右孩子呢，因此在寻找后继节点的时候，直接处理后继节点还有没有右孩子的情况
        }
        return true;
    }

    /**
     * 找出当前节点的后继节点
     *
     * @param delNode 当前节点
     * @return
     */
    public BinaryTreeNode getSuccessor(BinaryTreeNode delNode) {
        // 建立当前节点引用，为删除节点的右孩子节点
        BinaryTreeNode current = delNode.rightChild;
        // 建立后继节点引用
        BinaryTreeNode successor = current;
        // 建立后继节点父节点引用
        BinaryTreeNode parentSuccessor = delNode;
        // 遍历其左子树，就能找到比删除节点大的值中最小的值
        while (current != null) {
            parentSuccessor = successor;
            successor = current;
            current = current.leftChild;
        }
        // 处理后继节点还有没有右孩子的情况,即当后继节点不是要删除节点的右孩子时
        if (successor != delNode.rightChild) {
            // 后集结点父节点的左孩子为后继节点的右孩子
            parentSuccessor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }


//    /**
//     * 二叉树打印：给定二叉树，返回按期规定形式返回，即每层位置均保留上下层结构
//     * [, , , , , , , 40, , , , , , , ]
//     * [, , , 10, , , , , , , , 55, , , ]
//     * [, 2, , , , 21, , , , 44, , , , 65, ]
//     * [, , , , 20, , 30, , , , , , , , ]
//     *
//     * @param root 二叉树根节点
//     */
//    public List<List<String>> printTree(BinaryTreeNode root) {
//        // 思路：先求出树的高度，算出元素最大个数为 2^h-1，然后根据每层所属的层数，将节点位置放置
//        // 关键点：每个节点的坐标折中取值结果，左孩子的j=(i+j)/2-1;右孩子i=(i+j)/2+1
//        List<List<String>> list = new ArrayList<>();
//        // 如果根节点为 null ，返回 list
//        if (root == null) return list;
//        // 得到数的高度
//        int height = getHeight(root);
//        // pow 2 的 height 次方 - 1，最大元素数目
//        int col = (int) (Math.pow(2, height) - 1);
//        List<String> subList = new ArrayList<>();
//        for (int i = 0; i < col; i++) {
//            //填充一行 "",即 [, , , , , , , , , , , , , , ]
//            subList.add("");
//        }
//        for (int j = 0; j < height; j++) {
//            //填充整个数据，即变成
//            // [, , , , , , , , , , , , , , ]
//            // [, , , , , , , , , , , , , , ]
//            // [, , , , , , , , , , , , , , ]
//            // [, , , , , , , , , , , , , , ]
//            list.add(new ArrayList<>(subList));
//        }
//        // 递归实现填充节点
//        backtrace(root, list, 0, height, 0, col - 1);
//        //System.out.println(col + " height: " + height);
//        return list;
//    }
//
//
//    /**
//     * 求树高度
//     */
//    public int getHeight(BinaryTreeNode root) {
//        if (root == null) return 0;
//        int left = getHeight(root.leftChild);
//        int right = getHeight(root.rightChild);
//        return Math.max(left, right) + 1;
//    }
//
//
//    /**
//     * 递归将数据放入数组中,当判断到叶子节点是即停止
//     *
//     * @param root      根节点
//     * @param list      样式数组
//     * @param row       最底层，初始值为 0
//     * @param totalRows 最高层，初始值为 4
//     * @param i         数组最左端
//     * @param j         数组最右端
//     */
//    public void backtrace(BinaryTreeNode root, List<List<String>> list, int row, int totalRows, int i, int j) {
//        if (root == null || row == totalRows) return;
//        // 在某个位置更改值用 set，因为 add 会增加空间
//        list.get(row).set((i + j) / 2, String.valueOf(root.data));
//        backtrace(root.leftChild, list, row + 1, totalRows, i, (i + j) / 2 - 1);
//        backtrace(root.rightChild, list, row + 1, totalRows, (i + j) / 2 + 1, j);
//    }


}
