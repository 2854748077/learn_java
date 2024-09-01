package thread_synchronization.condition;

public class Main {
    public static void main(String[] args){
        TaskQueue taskQueue=new TaskQueue();
        new Thread(()->{taskQueue.addTask("任务一");}).start();
        new Thread(()->{taskQueue.addTask("任务2");}).start();
        new Thread(()->{taskQueue.addTask("任务3");}).start();
        new Thread(()->{taskQueue.addTask("任务4");}).start();
        new Thread(()->{System.out.println("1"+taskQueue.getTaskQueue());}).start();
        new Thread(()->{System.out.println(taskQueue.getTaskQueue());}).start();
        new Thread(()->{System.out.println("3"+taskQueue.getTaskQueue());}).start();
        new Thread(()->{System.out.println(taskQueue.getTaskQueue());}).start();






    }
}
