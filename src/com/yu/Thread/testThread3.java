package com.yu.Thread;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:25 2021/9/15
 * @Modified By:
 */
//创建线程fangshier，创建runnable接口
public class testThread3 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 2000; i++) System.out.println("111111111"+i);
    }

    public static void main(String[] args) {

        testThread3 thread3 = new testThread3();
        new Thread(thread3).start();
        for (int i = 0; i < 2000; i++) System.out.println("2222222222"+i);
    }
}
