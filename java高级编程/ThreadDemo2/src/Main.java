// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 7; i++) {
                    System.out.println(Thread.currentThread().getName()+"执行");
                }
            }
        };

        System.out.println(Thread.currentThread().getPriority());          //获取线程优先级 getPriority()

        Thread th1=new Thread(run,"线程1");
        Thread th2=new Thread(run,"线程2");
        Thread th3=new Thread(run,"线程3");
        th1.setPriority(Thread.MIN_PRIORITY);                //设置线程优先级 1-10
        th2.setPriority(5);                                 //优先级不一定先执行，但先执行概率更高
        th3.setPriority(Thread.MAX_PRIORITY);               //设置线程优先级：setPriority();

        th1.start();
        th2.start();
        th3.start();

    }
}