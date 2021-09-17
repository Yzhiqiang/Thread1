package com.yu.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:07 2021/9/15
 * @Modified By:
 */
//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name)
    {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run()
    {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 testThread = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","1.jpg");
        TestThread2 testThread2 = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","2.jpg");
        TestThread2 testThread3 = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","3.jpg");
        testThread.start();
        testThread2.start();
        testThread3.start();

    }
}


//下载器
class WebDownloader
{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出现异常");
        }
    }
}