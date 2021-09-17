package com.yu.Thread.ThreadStop;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:11 2021/9/16
 * @Modified By:
 */
//建议线程正常停止
//2、建议使用标志位，设置一个标志位
//3.不要使用stop或destory等过时或者JDK不建议使用的方法
public class TestStop implements Runnable{

    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag)
        {
            System.out.println("run........Thread"+i++);
        }
    }

    public void stop()
    {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        TestStop stop = new TestStop();

        new Thread(stop).start();
        for(int i = 0; i < 1000; i++)
        {
            Thread.sleep(1);
            if(i == 900)
            {
                stop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
