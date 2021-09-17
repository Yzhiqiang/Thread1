package com.yu.lambda;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:54 2021/9/16
 * @Modified By:
 */
public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = null;
//        ILove love = (int a)->{
//            System.out.println("love you" + a);
//        };

        //简化1：去掉参数类型，多个参数也可以去掉参数类型，要去掉都去掉
//        love = (a)->{
//            System.out.println("love you " + a);
//        };

        // 简化2：简化（），多个参数不能去掉（）
        love = a->{
            System.out.println("love you " + a);
        };

        //简化3：简化{},1.方法内只有一行的情况下才能简化{}，2.必须是函数式接口才能写为lambda表达式
        love = a-> System.out.println("love you=====" + a);
        love.love(6);
    }
}
interface ILove{
    void love(int a);
}
