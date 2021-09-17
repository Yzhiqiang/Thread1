package com.yu.Thread.ThreadStop;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:39 2021/9/16
 * @Modified By:
 */
public class TestYield {
    public static void main(String[] args) {
        Myyield myyield = new Myyield();
        new Thread(myyield,"进程A").start();
        new Thread(myyield,"进程B").start();
    }
}
class Myyield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}