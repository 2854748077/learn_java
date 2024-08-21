/*
Stack只有入栈和出栈的操作：

把元素压栈：push(E)；
把栈顶的元素“弹出”：pop()；
取栈顶元素但不弹出：peek()。
* */



// 转十六进制

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        String string="";
        Deque<Integer> deq=new LinkedList<>();
        while (n!=0){
            deq.push(n%16);
            n=n/16;
        }while (!deq.isEmpty()){
            if(deq.peek()>9){                            //大于9，则变为字母
                char c=(char)(65+deq.pop()-10);
                System.out.println(c);
                string = string + c;
                continue;
            }
                string = string+deq.pop();            //拼接字符串
        }
        return string;
    }
}