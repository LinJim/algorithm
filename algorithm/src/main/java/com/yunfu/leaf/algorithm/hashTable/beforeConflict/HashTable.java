package com.yunfu.leaf.algorithm.hashTable.beforeConflict;

import java.math.BigInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 哈希表
 * @date: 2018-11-01
 * @time: 23:18
 */
public class HashTable {
    private Info[] infos;

    /**
     * 默认构造方法
     */
    public HashTable() {
        infos = new Info[100];
    }

    /**
     * 给定容量的构造方法
     *
     * @param capacity 给定容量
     */
    public HashTable(int capacity) {
        infos = new Info[capacity];
    }

    /**
     * 插入数据
     *
     * @param info 对象信息
     */
    public void insert(Info info) {
        infos[hashCode(info.getKey())] = info;
    }

    /**
     * 查找数据
     *
     * @param key 键
     */
    public Info find(String key) {
        return infos[hashCode(key)];
    }

    /**
     * 计算 hash 值：将字母换成 ASCII 码，然后相加作为索引
     * 其中 a 是 97
     * 冲突的原因：如果键的名字为 abc ,bca ,cba
     *
     * @param key 根据键号
     * @return hash 值
     */
    public int hashCode1(String key) {
        int hash = 0;
        char[] arr = key.toCharArray();
        for (char s : arr) {
            int letter = s - 96;
            hash += letter;
        }
        return hash;
    }

    /**
     * 计算 hash 值：将字母换成 ASCII 码，然后和幂的连城，然后相加作为索引
     * a,b,c ----------> 1*  27^0 + 2 * 27^1 + 3 * 27^2
     * 缺陷：虽然产生唯一的值，解决了冲突，但是名字太长，数组越界了,int 的范围为 20 亿
     *
     * @param key 根据键号
     * @return hash 值
     */
    public int hashCode2(String key) {
        int hash = 0;
        int power = 1;
        char[] arr = key.toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            int letter = arr[i] - 96;
            hash += letter * power; // 可以用 Math.pow()方法取代
            power *= 27;
        }
        return hash;
    }


    /**
     * 计算 hash 值：将字母换成 ASCII 码，然后和幂的连城，然后相加，再压缩作为索引
     * a,b,c ----------> 1*  27^0 + 2 * 27^1 + 3 * 27^2
     * 缺陷：压缩了值，但是产生了冲突
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
        for (int i = arr.length - 1; i > 0; i--) {
            int letter = arr[i] - 96;
            BigInteger bigLetter = new BigInteger(String.valueOf(letter));
            hash = hash.add(bigLetter.multiply(power)); // 可以用 Math.pow()方法取代
            power = power.multiply(new BigInteger("27"));
        }
        return hash.mod(new BigInteger(String.valueOf(infos.length))).intValue();
    }


}
