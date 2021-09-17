package com.yu.StaticProxy;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:14 2021/9/16
 * @Modified By:
 */


/*
静态代理模式总结，真实对象和代理对象实现同一个接口

好处：只是对象专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        WweddingCompany wweddingCompany = new WweddingCompany(new You());
        wweddingCompany.happyMarry();
    }
}

interface Marry
{
    void happyMarry();
}

//真实角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("结婚啦。。");
    }
}

//代理角色
class WweddingCompany implements Marry{
    private Marry target;

    public WweddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void before()
    {
        System.out.println("结婚之前布置现场");
    }
    private void after()
    {
        System.out.println("结婚之后收拾现场");
    }
}
