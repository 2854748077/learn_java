import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main{
    public static void main(String[]args)throws Exception{
        InputStream input=new FileInputStream("D:/java/practice.txt");

        System.out.println(readAsString(input));


        byte[] data={11,22,33,44,55,66,77};
        try(InputStream input3=new ByteArrayInputStream(data)){   //ByteArrayInputStream（byte[] b）:内存中模拟一个输入流
            int n;                                                  //测试用
            StringBuilder sb=new StringBuilder();
            while ((n = input.read()) != -1) {
                //System.out.println((char)n);
                sb.append((char) n);                               //组成字符串
        }
            System.out.println(sb);
        }
        for(;;){
            int a=input.read();          //read():读取输入流下一个字节。
            System.out.print(a);
            if (a==-1){break;}
        }
        System.out.println();
        input.close();                    //close（）关闭输入流
        try(InputStream input1=new FileInputStream("D:/java/practice.txt")){             //try(){}  : 结束编译器自动关闭资源
            byte[] buffer=new byte[10];
            for(;;){                                                                           //编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，如果实现了，就自动加上finally语句并调用close()方法。
                int sum= input1.read(buffer);  //read(byte[] b):返回读取了多少个字符
                                                // 必须等待read()方法返回才能执行下一行代码
                int a=input1.read();          //read():读取输入流下一个字符。
                for (byte b : buffer){         //输出缓冲数组的内容
                    System.out.print(b);
                }
                System.out.println("\n"+sum);
                if (input1.read(buffer)==-1){break;}
            }

        }


    }
    public static String readAsString(InputStream inputStream) throws IOException {
            byte[] by=new byte[10];
            StringBuilder sb=new StringBuilder();
            for (;;) {
                if (inputStream.read()!=-1) {
                    inputStream.read(by);              //读取一组数据
                    for (byte b:by){                    //  放入StringBuilder
                        sb.append(b);
                    }
                    continue;
                }break;
            }
        return sb.toString();
    }
}