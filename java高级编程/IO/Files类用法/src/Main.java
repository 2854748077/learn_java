import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args)throws IOException {

        //文件内容读入byte[]
        byte[] bytes= Files.readAllBytes(Path.of("D:\\java\\test.txt"));
        System.out.println(Arrays.toString(bytes));


        //文本文件
        String str=Files.readString(Path.of("D:\\java\\text.txt"));
        System.out.println(str);
        //String content2 = Files.readString(Path.of("/path", "to", "file.txt"), StandardCharsets.ISO_8859_1);  //可指定编码内容
        List<String> lines = Files.readAllLines(Path.of("D:\\java\\text.txt"));        //按行读取
        for (String s :lines){
            System.out.println(s);
            System.out.println("*");
        }
//*******************************************************************************************************************************
        //写入文件
        //2进制文件
        byte[] data=new byte[10];
        Files.write(Path.of("D:\\java\\practice.txt"),data);
        //写入文本，并指定编码
        Files.writeString(Path.of("D:\\java\\practice11.txt"), "成功写入", StandardCharsets.UTF_8);
        //按行写入
        // 按行写入文本:
        List<String> lines1 =lines;
        Files.write(Path.of("D:\\java\\text11.txt"), lines1);
    }
}