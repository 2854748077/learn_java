/**
 *
 * Deque实现了一个双端队列（Double Ended Queue），它可以：
 *
 * 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
 * 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
 * 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
 * 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
 * 避免把null添加到队列。
 *
 * */



import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A                   //offerLast（）：添加到队尾
        deque.offerLast("B"); // A <- B   ···········
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B     //pollFirst():从队首获取并删除
        System.out.println(deque.pollLast()); // B, 剩下A            //pollLast（）：从队尾获取并删除
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}
