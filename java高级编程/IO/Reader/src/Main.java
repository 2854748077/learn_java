/*
* int read():读取字节
* int read(byte[] b): 读取字节数组
* */


import java.io.*;
import java.nio.charset.StandardCharsets;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) throws IOException {

        try (Reader read1 = new FileReader("D:\\java\\practice.txt", StandardCharsets.UTF_8)) {
            char[] buffer = new char[10];
            int n;
            while ((n = read1.read(buffer)) != -1) {
                System.out.println(n);
                for (char b : buffer){         //查看缓冲数组的内容
                    System.out.print(b);
                }
            }
        }
        //*********************************************************************//在内存中模拟
        try(Reader reader2=new StringReader("哈哈哈")){}                   //StringReader（）// 把String做数据源
        try(Reader reader3=new CharArrayReader("哈哈哈".toCharArray())){}     //CharArrayReader（）//把charArray做数据源


        //************************************************************************//InputStream和转换成Reader
        InputStream input=new FileInputStream("D:\\java\\practice.txt");
        Reader reader=new InputStreamReader(input,"UTF-8");           //InputStream -> Reader
        input.close();
        reader.close();

    }
}