package com.yunfu.leaf.algorithm.hashTable.openAdress;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 学生信息类
 * @date: 2018-11-02
 * @time: 15:36
 */
public class Info {
    private String key;
    private String name;

    public Info(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
