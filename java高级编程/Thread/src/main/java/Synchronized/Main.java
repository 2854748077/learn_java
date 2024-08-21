/*
* wait():等待
* notifyAll():解除等待
*
* */

package Synchronized;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main{

        public static void main(String[] args) throws InterruptedException {
            Counter c1=new Counter();
            Counter c2=new Counter();
            new Thread(()->c1.add(1)).start();
            new Thread(()->c1.dec(2)).start();
            new Thread(()->c2.add(2)).start();
            new Thread(()->c2.dec(1)).start();
            System.out.println(c1.get());
            System.out.println(c2.get());
 //*****************************************************************************************************
            TaskQueue tq=new TaskQueue();
           // ArrayList<Thread> at=new ArrayList<>();
            for (int i=0;i<5;i++){
                Thread thread=new Thread(()->{
                    String s="任务——"+Math.random();      //任务
                    tq.setTask(s);
                });
                thread.start();
           //     at.add(thread);
            }for (int i=0;i<5;i++){
                System.out.println(tq.getTask());
            }

        }

}
class Counter {

    private int count = 0;
    private int count1=0;


    public void add(int n)  {
        synchronized(this) {
            while (n++==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count1 +=count;
            count += n;

        }
    }

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}
class TaskQueue{
    Queue<String> queue=new LinkedList<>();
    private final Lock lock=new ReentrantLock();
    private final Lock lock2=new ReentrantLock();

/*    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()){
            this.wait();
        }return queue.remove();
    };
    public synchronized void setTask(String str) throws InterruptedException {
        this.notifyAll();
        this.queue.add(str);
    };*/

    public String getTask() throws InterruptedException {
        String s="";
        while (!queue.isEmpty()){
            lock.lock();
            try{
                s=queue.remove();
            }finally {

                lock.unlock();
            }}

            return s;
    };
    public void setTask(String str){
        lock.lock();
        try {
            this.queue.add(str);

        }finally{

            lock.unlock();
        }
    };

}