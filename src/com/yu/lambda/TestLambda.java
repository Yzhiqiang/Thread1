package com.yu.lambda;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:35 2021/9/16
 * @Modified By:
 */
public class TestLambda {

//    3、静态内部类
    static class Like2 implements ILike
    {
        @Override
        public void lambda() {
            System.out.println(" i like lambda2");
        }
    }
    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();

        iLike = new Like2();
        iLike.lambda();

//        4.局部内部类
        class Like3 implements ILike
        {
            @Override
            public void lambda() {
                System.out.println(" i like lambda3");
            }
        }

        iLike = new Like3();
        iLike.lambda();

//        5.匿名内部类
        iLike = new ILike(){
            @Override
            public void lambda() {     //并没有类的名称，必须借助接口或者父类
                System.out.println(" i like lambda4");
            }
        };
        iLike.lambda();

//        6.lambda表达式简化
        iLike = ()->{     //并没有类的名称，必须借助接口或者父类
                System.out.println(" i like lambda5");
        };
    }
}


//1.定义一个函数式接口
interface ILike
{
    void lambda();
}

interface Test
{
    void test();
}
//实现类
class Like implements ILike
{
    @Override
    public void lambda() {
        System.out.println(" i like lambda");
    }
}