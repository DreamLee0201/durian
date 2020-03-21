package gupao.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: DreamLee
 * @date: Created on 20:31 2020/2/17
 * @description: [describe the function]
 * @modified:
 */
public class RWLock {
    static ReentrantReadWriteLock wrl = new ReentrantReadWriteLock();

    static Map<String, Object> cacheMap = new HashMap<>();
    static Lock read = wrl.readLock();
    static Lock write = wrl.writeLock();

    public static final Object get(String key, Object val) {
        System.out.println("begin read data:" + key);
        read.lock();
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object val) {
        write.lock();
        try {
            return cacheMap.put(key,val);
        } finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {
        wrl.readLock();
        wrl.writeLock();
    }
}
