package gupao.thread.sync;

/**
 * @author: DreamLee
 * @date: Created on 22:38 2020/2/15
 * @description: [describe the function]
 * @modified:
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            System.out.println("start ThreadA");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadA");
        }
    }
}
