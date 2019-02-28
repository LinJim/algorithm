package com.yunfu.leaf.algorithm.recursion.model;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 递归，分为递和归
 * @date: 2018-10-19
 * @time: 11:51
 */
public class Recursion {

    /**
     * 测试方法
     */
    public void test() {
        System.out.println("哈哈哈哈");
        test();
    }

    /**
     * 打印 1 - n
     */
    public void printf(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }
        printf(--n);
    }

    /**
     * 通过循环打印三角数列第 n 项的值：f(n) = f(n-1) + n ，f(1) = 1;
     * 比较次数 n+1 次,效率 n 次
     */
    public int getTriangleNumberByCycle(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            n--;
        }
        return total;
    }

    /**
     * 通过递归打印三角数列第 n 项的值：f(n) = f(n-1) + n ，f(1) = 1;
     * 效率：M(n)=M(n-1)+1 （M(n) 需要完成 M(n-1) 次减法，最后再加上一次加法），所以效率为 n
     */
    public int getTriangleNumberByRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getTriangleNumberByCycle(--n);
    }


    /**
     * 通过递归打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * 指数级效率，因为相同的函数值被一遍遍的重复计算
     */
    public int getFibonacciByRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacciByRecursion(n - 1) + getFibonacciByRecursion(n - 2);
    }

    /**
     * 通过循环计算打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * 迭代计算，构建一个数组，存储前面的值
     */
    public int getFibonacciByRecursion2(int n) {
        // 构建一个数组,存储前面计算的值，这个比递归效率高很多，因为递归一直在计算重复的值
        int[] fibonacci = new int[n + 1];
        if(n>=0){
            fibonacci[0] = 0;
        }
        if(n>=1){
            fibonacci[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }

    /**
     * 通过递归打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * n-1 次效率，迭代计算，利用 1 的空间来存储前面的值
     */
    public int getFibonacciByRecursion3(int n) {
        // 构建一个数组,存储前面计算的值，这个比递归效率高很多，因为递归一直在计算重复的值
        int fibonacci = 0;
        int fibonacci0 = 0;
        int fibonacci1 = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci = fibonacci0 + fibonacci1;
            fibonacci0 = fibonacci1;
            fibonacci1 = fibonacci;
        }
        return fibonacci;
    }

    /**
     * 移动盘子
     * 效率公式：M(n)=M(n-1)+1+M(n-1)=2^n-1
     *
     * @param n     移动盘子数
     * @param from  起始塔座
     * @param inner 中间塔座
     * @param to    目标塔座
     */
    public static void doHanoiTower(int n, char from, char inner, char to) {
        if (n == 1) {
            System.out.println("盘子 1 从" + from + "起始塔座移到" + to + "目标塔座");
        } else {
            // 先把 n-1 个盘子借助 to 塔放到 inner 塔
            doHanoiTower(n - 1, from, to, inner);
            System.out.println("盘子 " + n + " 从" + from + "起始塔座移到" + to + "目标塔座");
            // 再把剩下 1 个盘子放到 to 塔，上面判断已做
            // 最后再把 n-1 盘子借助 from 塔从 inner 塔移到 to 塔
            doHanoiTower(n - 1, inner, from, to);
        }

    }


}
