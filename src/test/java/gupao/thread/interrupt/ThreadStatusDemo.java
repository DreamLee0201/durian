package gupao.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: DreamLee
 * @date: Created on 22:28 2020/2/5
 * @description: [describe the function]
 * @modified:
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Waiting_Thread").start();

        new Thread(() -> {
            while(true) {
                try {
                    ThreadStatusDemo.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Waiting_Thread").start();

        new Thread(new BlockedDemo(),"Block01_Thread").start();
        new Thread(new BlockedDemo(),"Block02_Thread").start();
    }

    static class BlockedDemo extends Thread{
        public void run() {
            synchronized (BlockedDemo.class) {
                while(true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
