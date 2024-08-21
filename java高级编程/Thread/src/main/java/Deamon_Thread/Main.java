//setDaemon(true)：设置守护线程
package Deamon_Thread;


public class Main {

    public static void main(String[] args) {
        Thread t = new Thread1();
        // 如果注释下一行，观察Thread1的执行情况:
        t.setDaemon(true);                          //其他非DaemonThread全部结束后，DaemonThread也会结束
                                                    //所有非守护线程都执行完毕后，虚拟机退出，守护线程随之结束；
        t.start();
        System.out.println("main: wait 3 sec...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("main: end.");
    }

}

class Thread1 extends Thread {

    public void run() {
        for (;;) {
            System.out.println("Thread-1: running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
