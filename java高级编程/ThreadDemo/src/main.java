import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


//Runnable描述资源
//thread 描述线程

public class main {
    public static void main(String[] args)throws Exception{



        //  new MyThread("线程A").start();              //线程要通过  ”start“ 方法执行
        //  new MyThread("线程B").start();               //若调用run执行会顺序执行。
        //  new MyThread("线程C").start();
        //````````````````````````````````````````````````````
        Thread th2=new Thread(new MyRunnable("线程Q"),"线程Q");      //Runnable接口的类的对象作为参数传入Thread类的构造方法
        Thread th3=new Thread(new MyRunnable("线程W"),"线程W");      //（参数，线程名）
        Thread th4=new Thread(new MyRunnable("线程E"),"线程E");
        th2.start();                                            //调用Thread的start（）方法启动线程
        th3.start();
        th4.start();
        //Lambda编程
        /*for (int i = 0; i < 3; i++) {
            String title = "线程对象-"+i;                         //lambda实现多线程
            java.lang.Runnable run =()->{                       //使用Runnable接口
                for (int j = 0; j < 5; j++) {
                    System.out.println(title+"运行次数："+j);
                }

            };
            new Thread(run).start();
        }*/
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(()->{
                for (int j = 0; j < 5; j++) {

                    try{
                        Thread.sleep(1000);                    //线程睡眠：Thread.sleep(),  必须捕获异常
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                        System.out.println("运行次数：" + j + "******" + Thread.currentThread().getName());        //Runnable描述资源

                }                                           //thread 描述线程
            },"线程"+i);
            thread.start();
            try{
                thread.join();                               //thread.join();强制执行当前线程
            }catch (Exception e){};

            //thread.start();
             /*Thread.sleep(1000);
            if(!thread.isInterrupted()){                      //判断线程是否中断 !thread.isInterrupted() :未中断返回true
                System.out.println("中断执行");
                thread.interrupt();                    //中断
            }*/
        }



        //```````````````````````````````````````````````````````````````````````````````````````````````````````````
        ticketDemo mt=new ticketDemo();
        for (int i = 0; i <100; i++) {
            new Thread(mt).start();
        }
        //```````````````````````````````````````````````````````````````````````````````````````````````````````````````
        FutureTask<String> ft1=new FutureTask<>(new MyThread3());   //callable和FutureTask实现多线程，有返回值
        for (int i = 0; i < 6; i++) {
            new Thread(ft1).start();
        }System.out.println("返回数据："+ft1.get());              //get获得返回值


    }

}

class MyThread extends Thread{

    private String title;
    public MyThread(String title){
        this.title=title;
    }

    public void run(){                                     //多线程要处理的操作都在run里面定义
        for(int i=0;i<10;i++){
            System.out.println(this.title+"x="+i+"****");
            try {
                Thread.sleep(10000);
            }catch (Exception e){}
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyRunnable implements java.lang.Runnable {         //Runnable只有一个run（）方法

    private String title;
    public MyRunnable(String title){
        this.title=title;
    }
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println(this.title+"x="+i+"  **********  "+Thread.currentThread().getName());     //获取线程名字：Thread.currentThread().getName()
        }
    }
}
//另一种实现多线程方法callable
class MyThread3 implements Callable<String> {             //Callable
    public String call() throws Exception{
        for (int i=0;i<10;i++){
            System.out.println("执行线程：x="+i);
        }
        return "线程执行完毕";
    }
}

