package gupao.thread.sync;

/**
 * @author: DreamLee
 * @date: Created on 22:41 2020/2/15
 * @description: [describe the function]
 * @modified:
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        Object lock = new Object();
        new ThreadA(lock).start();
        new ThreadB(lock).start();
    }
}
