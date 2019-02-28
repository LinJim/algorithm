package com.yunfu.leaf.algorithm.hashTable.linkedListAdress;

import com.yunfu.leaf.algorithm.hashTable.linkedListAdress.Info;

import java.math.BigInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 哈希表
 * @date: 2018-11-01
 * @time: 23:18
 */
public class HashTable {
    private LinkedList[] lists;

    /**
     * 默认构造方法
     */
    public HashTable() {
        lists = new LinkedList[100];
    }

    /**
     * 给定容量的构造方法
     *
     * @param capacity 给定容量
     */
    public HashTable(int capacity) {
        lists = new LinkedList[capacity];
    }

    /**
     * 插入数据
     *
     * @param info 对象信息
     */
    public void insert(Info info) {
        int hashVal = hashCode(info.getKey());
        // 每一个元素是链表，在插入数据之前，先判断链表是否已经创建
        if (lists[hashVal] == null) {
            lists[hashVal] = new LinkedList();
        }
        // 找到位置的链表插入结点
        lists[hashVal].insertFirst(info);
    }

    /**
     * 查找数据
     *
     * @param key 键
     */
    public Info find(String key) {
        int hashVal = hashCode(key);
        // 如果 infos[hashVal] 的链表刚好是空的，就返回 null ，否则就使用链表查询
        return lists[hashVal] == null ? null : lists[hashVal].find(key).data;
    }


    /**
     * 删除数据
     *
     * @param key 键
     */
    public Info delete(String key) {
        // 找到关键字自定义的 hash 值
        int hashVal = hashCode(key);
        // 如果链表没初始化，那么返回 null
        return lists[hashVal] == null ? null : lists[hashVal].delete(key).data;
    }


    /**
     * 计算 hash 值：将字母换成 ASCII 码，然后和幂的连城，然后相加，再压缩作为索引
     * a,b,c ----------> 1*  27^0 + 2 * 27^1 + 3 * 27^2
     * 缺陷：压缩了值，但是产生了冲突，第二,如果 key 过大，hash 会溢出
     * 1. 使用 java 中 long 型为最大整数类型,对于超过 long 型的数据如何去表示呢.在 Java 的世界中,超过 long 型的整数已经不能被称为整数了,它们被封装成 BigInteger 对象
     * 2. double 和 float 类型在运算中很容易丢失精度,造成数据的不准确性,Java 提供我们 BigDecimal 类可以实现浮点数据的高精度运算
     *
     * @param key 根据键号
     * @return hash 值
     */
    public int hashCode(String key) {
        BigInteger hash = new BigInteger("0");
        BigInteger power = new BigInteger("1");
        char[] arr = key.toCharArray();
        for (int i = arr.length; i > 0; i--) {
            int letter = arr[i-1] - 96;
            BigInteger bigLetter = new BigInteger(String.valueOf(letter));
            hash = hash.add(bigLetter.multiply(power)); // 可以用 Math.pow()方法取代
            power = power.multiply(new BigInteger("27"));
        }
        return hash.mod(new BigInteger(String.valueOf(lists.length))).intValue();
    }


}
