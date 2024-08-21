import java.io.*;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。

public class Main {
    public static void main(String[] args)throws IOException {
        try(OutputStream ops=new FileOutputStream("D:\\java\\text.txt");                //括号内可以写多个资源对象
            InputStream ips=new FileInputStream("D:\\java\\practice.txt")) {
            while (true){
                int a=ips.read();                                                            //练习：把文件a写到文件b
                if(a!=-1){
                    ops.write(a);
                    ops.flush();             //flush（）：把清空缓冲池（输出）
                }
                if (a==-1){
                    break;
                }

            }
            ops.write(72);      //H     //  write(byte)  //ascii码
            ops.write("成功写入".getBytes("UTF-8"));         //write(byte[]):写入问内容到文件
        }
    }
}
//package com.itranswarp.learnjava;
  //练习题：一个文件内容复制到另一个文件
/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 *//*
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage:\n  java CopyFile.java <source> <target>");
            System.exit(1);
        }
        copy(args[0], args[1]);
    }

    static void copy(String source, String target) throws IOException {
        // 友情提示：测试时请使用无关紧要的文件
        // TODO:
        try(OutputStream ops=new FileOutputStream(target);                //括号内可以写多个资源对象
            InputStream ips=new FileInputStream(source)) {
            while (true){
                int a=ips.read();                                                            //练习：把文件a写到文件b
                if(a!=-1){
                    ops.write(a);
                }
                if (a==-1){
                    break;
                }
            }
        }
    }
}

*/