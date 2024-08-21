/*
*
PrintStream是一种能接收各种数据类型的输出，打印数据时比较方便：
System.out是标准输出；
System.err是标准错误输出。
PrintWriter是基于Writer的输出。
* */
import java.io.*;
import java.nio.charset.StandardCharsets;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) throws IOException {

        StringWriter strw=new StringWriter();
        try(PrintWriter pw=new PrintWriter(strw)){
            pw.print(" 写入：1 ");
            pw.print(56);
        }
        System.out.println(strw.toString());


    }
}