package thread_synchronization.condition;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue=new TaskQueue();

        new Thread(()->{ taskQueue.addTask("任务一");}).start();
        new Thread(()->{taskQueue.addTask("任务2");}).start();
        new Thread(()->{taskQueue.addTask("任务3");}).start();
        new Thread(()->{taskQueue.addTask("任务4");}).start();

        Thread.currentThread().sleep(500);

        new Thread(()->{
            try {
                System.out.println("1"+taskQueue.getTaskQueue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(taskQueue.getTaskQueue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("3"+taskQueue.getTaskQueue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(taskQueue.getTaskQueue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
//*******************************************************************************************************88
        Point point =new Point();






    }
}
