//https://blog.csdn.net/Amentos/article/details/127182926?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522172196295016800186585071%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=172196295016800186585071&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-127182926-null-null.142^v100^pc_search_result_base8&utm_term=%E4%B8%AD%E7%BC%80%E8%BD%AC%E5%90%8E%E7%BC%80&spm=1018.2226.3001.4187
//请把带变量的中缀表达式编译为后缀表达式，执行后缀表达式时，传入变量的值并获得计算结果

import java.util.*;



public class Main {
    public static void main(String[] args) {
        String exp = "x + 2 * ( y - 5 )";            // x2y5-*+        //从左往右依次移除括号，左括号低优先级   只要
        SuffixExpression se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {          //编译
        // TODO:
        //  计算后缀表达式：设置一个String(结果集)一个stack,遍历exp，数字直接放入String，遇到+-*/压栈，遇到(压栈，遇到右括号直接出栈直到（出栈。遍历完exp后，全部符号出栈
        //设定（低优先级，
        Deque<String> deq=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        String[] str1=exp.split(" ");
        for(int i=0;i<str1.length;i++){
            if(Character.isDigit(str1[i].charAt(0))||str1[i].equals("x")||str1[i].equals("y")){
                sb.append(str1[i]);
                continue;
            }
            if(str1[i].equals("+")){
                deq.push(str1[i]);
            }if(str1[i].equals("-")){
                deq.push(str1[i]);
            }if(str1[i].equals("*")){
                deq.push(str1[i]);
            }if(str1[i].equals("/")){
                deq.push(str1[i]);
            }if(str1[i].equals("(")){
                deq.push(str1[i]);
            }if(str1[i].equals(")")){
                while (!deq.peek().equals("(")){
                        sb.append(deq.pop());
                        System.out.println(sb);
                }
                        deq.pop();
            }if(i==str1.length-1){
                while (!deq.isEmpty()){
                    sb.append(deq.pop());
                }
            }
        }System.out.println(sb);                    //后缀表达式

        return new SuffixExpression(sb.toString().trim());
    }
}

class SuffixExpression {
    private String str1;
    public SuffixExpression(String string){
        this.str1=string;
    }
    int execute(Map<String, Integer> env) {   //计算结果
        // TODO:
        //  计算后缀表达式：设置一个String一个stack，遇到数字字节压栈，遇到+-*/，直接出栈算出结果，结果在重新入栈

        int a=env.get("x");     //1
        int b=env.get("y");     //9
        this.str1=str1.replace("x",String.valueOf(a));
        this.str1=str1.replace("y",String.valueOf(b));
        System.out.println(str1);
        String[] str=str1.split("");
        //System.out.println(str);

        int sum=0;
        Deque<String> arr =new LinkedList<>();
        for (int i=0;i<str.length;i++)
            if(Character.isDigit(str[i].charAt(0))) {
                arr.push(str[i]);
            }else {
              //  System.out.println(sum);
                if(str[i].equals("+")){
                    sum=Integer.parseInt(arr.pop())+Integer.parseInt(arr.pop());
                }if(str[i].equals("-")){
                    int c=Integer.parseInt(arr.pop());
                    sum=Integer.parseInt(arr.pop())-c;
                }if(str[i].equals("*")){
                    sum=Integer.parseInt(arr.pop())*Integer.parseInt(arr.pop());
                }if(str[i].equals("/")){
                    int c=Integer.parseInt(arr.pop());
                    sum=c/Integer.parseInt(arr.pop());

                }
                arr.push(String.valueOf(sum));
            }
        System.out.println(sum);
        return sum;
    }
}/*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String exp = "x + 2 * ( y - 5 )";            //从左往右依次移除括号，左括号低优先级
        SuffixExpression se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(result);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        // 编译
        Deque<String> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0)) || Character.isLetter(token.charAt(0))) {
                sb.append(token).append(" ");
            } else if (token.equals("(")) {
                deq.push(token);
            } else if (token.equals(")")) {
                while (!deq.isEmpty() && !deq.peek().equals("(")) {
                    sb.append(deq.pop()).append(" ");
                }
                deq.pop(); // 移除左括号
            } else {
                while (!deq.isEmpty() && precedence(deq.peek()) >= precedence(token)) {
                    sb.append(deq.pop()).append(" ");
                }
                deq.push(token);
            }
        }

        while (!deq.isEmpty()) {
            sb.append(deq.pop()).append(" ");
        }

        return new SuffixExpression(sb.toString().trim());
    }

    static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}

class SuffixExpression {
    private String expression;

    public SuffixExpression(String expression) {
        this.expression = expression;
    }

    int execute(Map<String, Integer> env) {
        Deque<Integer> stack = new LinkedList<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else if (Character.isLetter(token.charAt(0))) {
                stack.push(env.get(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }
}

*//*
1、字符为 运算数 ：

直接送入后缀表达式（注：需要先分析出完整的运算数）。

2、字符为 左括号 ：

直接入栈（注：左括号入栈后优先级降至最低）。

3、字符为 右括号 ：

直接出栈，并将出栈字符依次送入后缀表达式，直到栈顶字符为左括号（左括号也要出栈，但不送入后缀表达式）。

总结：只要满足 栈顶为左括号 即可进行最后一次出栈。

4、字符为 操作符 ：

若栈空，直接入栈。

若栈非空，判断栈顶操作符，若栈顶操作符优先级低于该操作符，该操作符入栈；否则一直出栈，并将出栈字符依次送入后缀表达式，直到栈空或栈顶操作符优先级低于该操作符，该操作符再入栈。
————————————————

*/