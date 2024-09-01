package thread_synchronization.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private final Lock lock=new ReentrantLock();                         //可重入锁
    private final Condition condition=lock.newCondition();               //获取实例
    private Queue<String> TaskQueue=new LinkedList<>();




    public String getTaskQueue()  {
        lock.lock();
        try{
        while (this.TaskQueue.isEmpty()) {
            try {
                condition.await();                                       //等待
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }}finally{
            lock.unlock();
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


