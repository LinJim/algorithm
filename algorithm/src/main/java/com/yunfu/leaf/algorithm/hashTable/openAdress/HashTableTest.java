package com.yunfu.leaf.algorithm.hashTable.openAdress;


import com.yunfu.leaf.algorithm.hashTable.openAdress.HashTable;
import com.yunfu.leaf.algorithm.hashTable.openAdress.Info;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2018-11-02
 * @time: 16:03
 */
public class HashTableTest {

    public static void main(String[] args) {
        HashTable ht = new HashTable();
//        ht.insert(new Info("zhangsan", "张三"));
//        ht.insert(new Info("lisi", "李四"));
        ht.insert(new Info("abcfffffwefwef", "张三"));
        ht.insert(new Info("bca", "李四"));
        ht.delete("bca");
        System.out.println(ht.find("abcfffffwefwef").getName());
        System.out.println(ht.find("bca").getName());
    }

}
