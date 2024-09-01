package thread_synchronization.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private final Lock lock=new ReentrantLock();                         //可重入锁
    private final Condition condition=lock.newCondition();               //获取实例
    private Queue<String> TaskQueue=new LinkedList<>();

    private final Semaphore semaphore=new Semaphore(2);           // 任意时刻仅允许最多3个线程获取许可:




    public String getTaskQueue() throws InterruptedException {
        semaphore.acquire();                //获取许可
        lock.lock();

        try{
        while(this.TaskQueue.isEmpty()) {
                condition.await();//等待
            }
        }finally{
            lock.unlock();
            Thread.currentThread().sleep(500);
            semaphore.release();           //释放许可
        }
        return TaskQueue.remove();
    }
    public void addTask(String task){
        lock.lock();
        try {
            TaskQueue.add(task);
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
}


