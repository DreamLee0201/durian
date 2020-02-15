package gupao.thread.sync;

/**
 * @author: DreamLee
 * @date: Created on 22:36 2020/2/15
 * @description: [describe the function]
 * @modified:
 */
public class ThreadB extends Thread {

    private Object lock = new Object();

    public ThreadB(Object lock){
        this.lock = lock;
    }
    public void run() {
        synchronized (lock) {
            System.out.println("start ThreadB");
            lock.notify();
            System.out.println("end ThreadB");
        }
    }
}
