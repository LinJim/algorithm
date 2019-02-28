package com.yunfu.leaf.algorithm.hashTable.linkedListAdress;


import com.yunfu.leaf.algorithm.hashTable.linkedListAdress.HashTable;
import com.yunfu.leaf.algorithm.hashTable.linkedListAdress.Info;

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
        ht.insert(new Info("a", "张三"));
        ht.insert(new Info("ct", "李四"));

        System.out.println(ht.find("a").getName());
        System.out.println(ht.find("ct").getName());

        System.out.println(ht.hashCode("a"));
        System.out.println(ht.hashCode("ct"));
    }

}
