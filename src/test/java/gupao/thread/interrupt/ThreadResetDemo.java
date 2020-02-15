package gupao.thread.interrupt;

/**
 * @author: DreamLee
 * @date: Created on 23:20 2020/2/5
 * @description: [describe the function]
 * @modified:
 */
public class ThreadResetDemo {
    //1.Thread.interrupted()
    //2.InterruptedException
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before:" + Thread.currentThread().isInterrupted());
                    Thread.interrupted();//复位，恢复到初识状态
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        //TimeUnit.SECONDS.sleep(1);
        //thread.interrupt();
    }
}
