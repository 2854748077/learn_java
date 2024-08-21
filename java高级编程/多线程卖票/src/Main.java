
//同步：synchronized(){内容} 同一时间只能有一个线程访问

public class Main {
    public static void main(String[] args) {
        myRunnable MR=new myRunnable();
        Thread th1=new Thread(MR,"one");
        Thread th2=new Thread(MR,"two");
        Thread th3=new Thread(MR,"three");
        th1.start();
        th2.start();
        th3.start();

    }
}
class myRunnable implements Runnable{

    private int ticket=5;
    public void run() {
        synchronized (this) {                                  //同步：synchronized(){内容} 同一时间只能有一个线程访问
            for (int i = 0; i < 100; i++) {
                if (this.ticket > 0) {
                    System.out.println("剩余票数：" + ticket-- + "***" + Thread.currentThread().getName());
                } else {
                    System.out.println("票已卖完" + "***" + Thread.currentThread().getName());
                    break;
                }
            }
        }
    }
}