package com.yu.syn;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:51 2021/9/16
 * @Modified By:
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金");
        Drwing you = new Drwing(account,50,"你");
        Drwing yougitfriend = new Drwing(account, 100, "你女朋友");

        you.start();
        yougitfriend.start();
    }
}

class Account
{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款

class Drwing extends Thread{
    Account account;
    int drawingMoney;
    public Drwing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public  void run() {
        //所得对象是变化的量，
        synchronized (account)
        {
            if(account.money < drawingMoney) {
                System.out.println(Thread.currentThread().getName()+"钱不够取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            System.out.println(Thread.currentThread().getName()+"取钱成功!!!!");
            System.out.println(account.name+"余额为："+account.money);
        }
    }
}