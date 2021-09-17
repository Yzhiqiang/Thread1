package com.yu.Thread.ThreadStop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:26 2021/9/16
 * @Modified By:
 */
public class TestSleep {

    public void tenDown() throws InterruptedException {
        int num = 10;
        while(true)
        {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num <= 0) break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //打印当前系统时间
        while(true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
        }
    }

}
