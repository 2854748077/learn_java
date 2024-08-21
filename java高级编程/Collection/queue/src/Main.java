
//int size()
//add(E a)/offer(E a):添加元素到队尾
//E remove（）/poll()： 获取队首元素并从队列中删除；
//E element()/peek() : 获取队首元素，但不删除

/*
返回值不同
* 	     throw Exception	返回false或null
添加元素到队尾    	add(E e)	boolean offer(E e)
取队首元素并删除	E remove()	E poll()
取队首元素但不删除	E element()	E peek()
* */
//queue:是先进先出队列

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> qu=new LinkedList<>();
        qu.offer(10);                               //队尾添加元素
        //qu.add(100);                                  //队尾添加元素

        System.out.println(qu.element());             //取队首元素不删除
        System.out.println(qu.peek());

        System.out.println(qu.remove());             //remoe（）：取队首元素并删除
        //System.out.println(qu.remove());           //返回报错
        System.out.println(qu.poll());               //返回null
    }
}