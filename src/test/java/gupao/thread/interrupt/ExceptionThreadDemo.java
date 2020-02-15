package gupao.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: DreamLee
 * @date: Created on 23:54 2020/2/5
 * @description: [describe the function]
 * @modified:
 */
public class ExceptionThreadDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);//阻塞中。。。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i:" + i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//中断阻塞状态的线程 会跑异常
        System.out.println(thread.isInterrupted());
    }
}
