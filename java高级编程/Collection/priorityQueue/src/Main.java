import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

        //优先级队列
        Queue<User> q =new PriorityQueue<>(new myComparator());  //允许提供comparator对象来判断两个元素顺序

        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class myComparator implements Comparator<User>{
    public int  compare(User user,User user2){

        return user.name.compareTo(user2.name);
    }
}

class User implements Comparable<User>{
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
   /* public int compareTo(User u){                      //提供comparator对象  或者 覆写compareTo()方法
        return this.name.compareTo(u.name);
    }*/

}