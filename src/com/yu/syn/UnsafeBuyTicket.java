package com.yu.syn;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 18:52 2021/9/16
 * @Modified By:
 */
//不安全的买票
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();

        new Thread(testThread,"小明").start();
        new Thread(testThread,"老师").start();
        new Thread(testThread,"黄牛").start();
    }
}

class TestThread implements Runnable
{
    private static int ticked = 10;
    boolean flag = true;   //外部停止方式

    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy () throws InterruptedException {
        if(ticked <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+ticked--);
    }

}
