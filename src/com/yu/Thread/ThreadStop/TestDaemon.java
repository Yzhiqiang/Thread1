package com.yu.Thread.ThreadStop;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 18:16 2021/9/16
 * @Modified By:
 */
//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();
    }
}

class God implements Runnable{

    @Override
    public void run()
    {
        while(true)
        {
            System.out.println("上帝保佑着你===========");
        }
    }

}

class You implements Runnable{

    @Override
    public void run()
    {
        for(int i = 0; i < 36500; i++)
        {
            System.out.println("永远开心啊@@@@@@@@@@@@@@@@@@@@");
        }
        System.out.println("===========goodbye! =======");
    }
}