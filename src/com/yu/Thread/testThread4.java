package com.yu.Thread;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:38 2021/9/15
 * @Modified By:
 */
public class testThread4 implements Runnable{
    //票数
    private int ticketNums = 10;

    @Override
    public void run()
    {
        while(true)
        {
            if(ticketNums <= 0) break;
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        testThread4 ticket = new testThread4();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
