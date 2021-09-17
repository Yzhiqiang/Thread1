package com.yu.Thread;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:53 2021/9/15
 * @Modified By:
 */
//创建线程方式一：继承Thread类，重run（）方法，调用start开启线程
public class TestThread extends Thread{
    @Override
    public void run() {
        //run方法，线程体
        for(int i = 0; i < 20000; i++)
        {
            System.out.println("我在看代码。。。。。。。"+i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();   //开启线程
        //main线程， 主线程
        for(int i = 0; i < 20000; i++)
        {
            System.out.println("我在学习java多线程"+i);
        }
    }
}
