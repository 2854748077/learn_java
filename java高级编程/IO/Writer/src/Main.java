//write（int c）
//write(char[] c)
//write(String s)
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args)throws IOException {

         //*************************************************************************************************************88
        //FileWriter()
        try(Writer writer=new FileWriter("D:\\java\\test.txt", StandardCharsets.UTF_8)){         //写入文件
            writer.write("写入失败");
            writer.write("写入成功".toCharArray());
            writer.write(132);
            writer.flush();
        }

        try(Reader reader=new FileReader("D:\\java\\test.txt", StandardCharsets.UTF_8)){             //读取文件内容
            int n=0;
            char[] buffer=new char[10];
            while ((n=reader.read(buffer))!=-1){
                System.out.println(Arrays.toString(buffer));
            }
        }

        //***************************************************************************************************************************************
        // CharArrayWriter()    //类似StringWriter()
        try(CharArrayWriter chr=new CharArrayWriter()){           //类似CharArrayOutStream（）     //内存中模拟Writer
            chr.write(56);
            chr.write(57);
            chr.write(59);
            chr.write("内存中临时创建一个writer，实际作用构建一个缓冲区");
            char[] chars=chr.toCharArray();
            System.out.println(chars);
        }
        //*******************************************************************************************************************************************888
        //OutputStream -->Writer
        try(Writer writer=new OutputStreamWriter(new FileOutputStream("D:\\java\\test.txt"))){

        }



    }
}