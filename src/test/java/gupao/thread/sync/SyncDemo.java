package gupao.thread.sync;

/**
 * @author: DreamLee
 * @date: Created on 20:04 2020/2/15
 * @description: [describe the function]
 * @modified:
 */
public class SyncDemo {

    public synchronized void demo() {}

    public void demo2(){
        synchronized (this) {}
    }

    public synchronized static void demo3() {}

    public void demo4() {
        synchronized (SyncDemo.class){}
    }

    public static void main(String[] args) {
        SyncDemo sd1 = new SyncDemo();
        SyncDemo sd2 = new SyncDemo();
        new Thread(() -> sd1.demo()).start();
        new Thread(() -> sd2.demo()).start();
    }

}
