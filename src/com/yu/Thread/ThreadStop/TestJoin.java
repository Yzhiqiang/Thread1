package com.yu.Thread.ThreadStop;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:46 2021/9/16
 * @Modified By:
 */
//测试join方法
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++)
        {
            System.out.println("vip线程来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++)
        {
            if(i == 200) thread.join();
            System.out.println("main " + i);
        }
    }
}
