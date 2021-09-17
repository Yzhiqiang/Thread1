package com.yu.Thread;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:46 2021/9/15
 * @Modified By:
 */
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run()
    {
        for(int i = 0; i <= 100; i++)
        {
            if(Thread.currentThread().getName() == "兔子" && i % 10 == 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            if(flag) break;
            System.out.println(Thread.currentThread().getName()+"-----》跑了"+i+"步");
        }
    }

    private boolean gameOver(int steps)
    {
        if(winner != null)
        {
            return true;
        }
        else
        {
            if(steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
