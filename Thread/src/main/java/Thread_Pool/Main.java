package Thread_Pool;

import java.util.concurrent.*;


public class Main {
    public static void main (String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(4);         //线程数固定线程池

        ExecutorService executorService= new ThreadPoolExecutor(                   //线程数根据任务动态调整的线程池；
                0,3,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(4);//放入ScheduledThreadPool的任务可以定期反复执行

        scheduledExecutorService.scheduleAtFixedRate(()->{System.out.println("重复执行1");},2,3,TimeUnit.SECONDS);   //两秒后开始，3秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new myRunnable(2),2,3,TimeUnit.SECONDS);

        for (int i=0;i<10;i++){
            executor.submit(new myRunnable(i));
            System.out.println("线程数量："+Thread.activeCount());
        }
        executor.shutdown();                                //关闭线程池
        executorService.shutdown();
        Thread.currentThread().sleep(60000);
        scheduledExecutorService.shutdown();
    }
}

class myRunnable implements Runnable{

    private int i;

    public myRunnable(int i){
        this.i=i;
    }
    public void run (){

        System.out.println(this.i+"\t"+Thread.currentThread().getName());
     //   System.out.println(Thread.currentThread().getName());


    }
}