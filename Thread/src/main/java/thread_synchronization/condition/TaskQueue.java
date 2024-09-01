package thread_synchronization.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private final Lock lock=new ReentrantLock();
    private final Condition condition=lock.newCondition();
    private Queue<String> TaskQueue=new LinkedList<>();

    public Queue<String> getTaskQueue(){

    }
}
