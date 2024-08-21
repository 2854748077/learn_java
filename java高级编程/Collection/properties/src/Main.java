
//properties
//setProperty():设置对应key和value
//getProperty():根据key获取对应值
//load():：加载文件中的键值对
//FileOutputStream(“路径”):用于将数据写入具体文件
//InputStream :从字节数组中读取数据
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));       //ByteArrayInputStream 获取String中的数据
        Properties props = new Properties();                                                   //创建Properties对象
        props.load(input);                                                                    //加载文件中的键值对

        System.out.println("course: " + props.getProperty("course"));                         //根据key获取
        // 对应得值
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));   //获取不存在的key，并设置一个默认值

        props.load(Main.class.getResourceAsStream("setting.properties"));  //绝对路径        //getResourceAsStream():从当前类路径开始访问资源文件
        props.setProperty("url", "wyu");
        props.setProperty("language","Java");
        props.setProperty("姓名","aaaaa");
        props.setProperty("university","Wyu");
        System.out.println("language" + props.getProperty("language"));

       props.store(new FileOutputStream("./setting.properties" ),"这是写入property的注释123456");  //props.store():把props的内容写进配置文件
                                                                          //new FileOutputStream("./setting.properties" ):将数据写入指定路径文件中
        props.store(new FileOutputStream("./setting.properties" ),"这是写入property的注释123456");

        props.load(new FileReader("settings.properties"));
    }
}