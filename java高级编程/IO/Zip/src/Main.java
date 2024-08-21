
//不会啊
//啊
//啊
//啊
import java.io.*;
import java.nio.file.Files;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args)throws IOException {

        try(ZipInputStream zos=new ZipInputStream(new FileInputStream("D:\\java\\test1.zip"))){
            StringBuilder sb =new StringBuilder();
            byte[] bufffer=new byte[5];
            ZipEntry ze=null;
            while((ze=zos.getNextEntry())!=null){
                System.out.println("输出entry名字："+ze.getName());
                if(!ze.isDirectory()){     //不是目录（就是压缩文件）
                    while (zos.read(bufffer)!=-1){                              //read（）:读取文件字节数据到缓冲区
                        for (int i=0;i<bufffer.length;i++){
                            System.out.print((char) bufffer[i]);                 //输出zip包文件内容
                        }

                    }
                }
            }System.out.println(sb.toString().toCharArray());
//*************************************************************************************************************************************
        }try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("D:\\java\\test1.zip"))) {
            File f=new File("D:\\java\\practice.txt");
            zip.putNextEntry(new ZipEntry(f.getName()));            //putNextEntry（）：为zip文件添加一个新的条目
            zip.write(Files.readAllBytes(f.toPath()));             //write（）：写入  //Files.readAllBytes(path) :获取文件内容
            zip.closeEntry();                                      //closeEntry（）：完成一个zip条目写入，必须关闭，以便进入下一个条目
        }

        //*****************************************************************************************************************************8

        try(InputStream input=Main.class.getResourceAsStream("/default.properties");           //Main.class.getResourceAsStream() :读取classpath中的文件资源
            OutputStream output=new FileOutputStream("default.properties")){                   //输出流
            if(input!=null){
                Properties properties=new Properties();
                properties.load(input);
                System.out.println(properties.getProperty("course"));
                System.out.println(properties.getProperty("url"));
                properties.setProperty("星期几","星期一");
                properties.store(output,"annotation");                                     //写入配置文件
            }else{
                System.out.println("空空如也");
            }
        };


    }
}