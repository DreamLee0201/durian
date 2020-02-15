package gupao.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: DreamLee
 * @date: Created on 23:04 2020/2/5
 * @description: [describe the function]
 * @modified:
 */
public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           while(!Thread.currentThread().isInterrupted()) {
               i++;
           }
            System.out.println("i:" + i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
