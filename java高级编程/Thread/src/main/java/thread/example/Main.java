/*
* 对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。如果目标线程处于等待状态，该线程会捕获到InterruptedException；

目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；

通过标志位判断需要正确使用volatile关键字；*/
package thread.example;


import static java.lang.Thread.sleep;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) throws InterruptedException {

    Thread thread1=new Thread(()->{
        while(!Thread.currentThread().isInterrupted()){
        System.out.println("启动分线程");
        /*try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("结束分线程");

    }});
    thread1.start();
   // thread1.stop();
    sleep(2);
    thread1.interrupt();
    thread1.join();                     //等待thread结束再执行主线程； 可以重载join（long）：指定一个最长时

    System.out.println("分线程"+thread1.getState()+"   主线程"+Thread.currentThread().getState());   //getState()：获取进程状态
    System.out.println("主线程结束");

    }
}
class MyRunnable implements Runnable {         //Runnable只有一个run（）方法

    private volatile String title;         //volatile:多线程使用，是内存中的是保持最新状态
    public MyRunnable(String title){
        this.title=title;
    }
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println(this.title+"x="+i+"  **********  "+Thread.currentThread().getName());     //获取线程名字：Thread.currentThread().getName()
        }
    }
}