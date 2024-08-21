public class ticketDemo implements java.lang.Runnable {
    private int ticket=5;
    public void run(){
        for (int i = 0; i <100; i++) {
            if (this.ticket >0) {
                System.out.println("卖票数" + this.ticket--);
            }
        }
        }
    }

