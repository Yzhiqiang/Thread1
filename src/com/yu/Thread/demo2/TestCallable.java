package com.yu.Thread.demo2;

import com.yu.Thread.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:07 2021/9/15
 * @Modified By:
 *
 * callable的好处
 * 1.可以定义返回值
 * 2.可以抛出异常
 */
//创建线程方式三，实现callable方法
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name)
    {
        this.name = name;
        this.url = url;
    }

    @Override
    public Boolean call()
    {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread2 t1 = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","1.jpg");
        TestThread2 t2 = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","2.jpg");
        TestThread2 t3 = new TestThread2("https://www.wahaotu.com/uploads/allimg/201904/1555074510295049.jpg","3.jpg");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = (Future<Boolean>) ser.submit(t1);
        Future<Boolean> r2 = (Future<Boolean>) ser.submit(t2);
        Future<Boolean> r3 = (Future<Boolean>) ser.submit(t3);

        //获取结果
        Boolean a1 = r1.get();
        Boolean a2 = r2.get();
        Boolean a3 = r3.get();

        ser.shutdownNow();

    }
}


//下载器
class WebDownloader
{
    public void downloader(String url, String name)
    {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
