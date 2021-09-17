package com.yu.Thread.ThreadStop;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 17:15 2021/9/16
 * @Modified By:
 */
public class TestPriority{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"------->"+Thread.currentThread().getPriority());

        Mypriority mypriority = new Mypriority();

        Thread t1 = new Thread(mypriority,"Thread1");
        Thread t2 = new Thread(mypriority,"Thread2");
        Thread t3 = new Thread(mypriority,"Thread3");
        Thread t4 = new Thread(mypriority,"Thread4");
        Thread t5 = new Thread(mypriority,"Thread5");
        Thread t6 = new Thread(mypriority);

        //先设置优先级，在启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
    }
}

class Mypriority implements Runnable{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"------->"+Thread.currentThread().getPriority());
    }
}
