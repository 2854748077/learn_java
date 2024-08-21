import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args)throws IOException {

        File file =new File("D:\\java\\practice.txt");
        File file2 =new File("..");
        File file4=new File("D:\\java\\practice\\one\\two");

        System.out.println(file2.getPath());                      //getPath()：获取构造方法传入路径
        System.out.println("返回绝对路径"+file2.getAbsolutePath());                //getAbsolutePath():返回绝对路径
        try {
            System.out.println("返回规范路径"+file2.getCanonicalPath());           //返回规范路径
        }catch (IOException e){
            System.out.println(e);
        }

        System.out.println("当前平台路径分隔符："+File.separator);        //windows:\  ,Linux:/

        System.out.println("是否是一个目录"+new File("D:\\java").isDirectory());                  //isDirectory()：是否是目录
        System.out.println("是否是一个文件"+new File("D:\\java\\practice.txt").isFile());         //isFile():是否是文件
        System.out.println(file.canExecute()+""+file.canRead()+""+file.canWrite()+""+file.length());     //是否可执行 、可读、可读、长度

        File file1=new File("D:\\java\\text.txt");
        try {
            file1.createNewFile();     //createNewFile()：创建新文件
            file4.mkdirs();            //mkdirs:创建目录   (File表示目录)
        }catch (IOException e){
            System.out.println(e);
        }
        if(file1.delete()){            //delete（）: 删除文件
            System.out.println("文件删除成功");
        };

        File file3=File.createTempFile("test",".txt");     //createTempFile(): 创建临时文件:提供前缀和后缀
        System.out.println(" "+file3.mkdirs());
        System.out.println("临时文件："+file3.getAbsolutePath());
        file3.deleteOnExit();                                           //deleteOnExit():JVM退出的时候自动删除

        File D_disk=new File("D://" ) ;
        for(String s:D_disk.list()){                                   //list():列出所有文件和子目录，返回值：String[]
        }File[] files=D_disk.listFiles(                               //listFile():列出所有文件和子目录  返回值：File[]
            new FilenameFilter(){
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");                       //限制：仅列出.txt后缀的文件
                }
            }
        );
       // printFiles(files);

        Path p1= Paths.get("one","two","three");      //Path对象
        System.out.println(p1);
        System.out.println(p1.toAbsolutePath());           //   转换为绝对路径
        System.out.println(p1.normalize());             //转为规范路径
        System.out.println(p1.toFile());
        for(Path p : p1){                                       //遍历Path
            System.out.println(" "+p);
        }

        //练习
        Path p2=Paths.get("D:\\Tencent");
        int sum=0;
        traverseDirector(p2,sum);




    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f+"\n");
                if (f.list()!=null){
                    for (File f1 :f.listFiles()){
                        System.out.println(f1.getPath());
                    }
                }
            }
        }
        System.out.println("==========");
    }

    static void traverseDirector(Path p,int sum)throws NullPointerException{            //遍历文件名

        for (int i=0;i<sum;i++){                            //打印空格
            System.out.print("  ");
        }sum=sum+1;                                          //记录空格数
            System.out.print(p.getFileName()+"\n");
            if(p.toFile().isDirectory()){                  //判断是否为目录
                for (File e:p.toFile().listFiles()){

                    traverseDirector(e.toPath(),sum);       //再次调用traverseDirector（），遍历子目录
                }
            }





            /*System.out.println(p.getFileName());
         //   System.out.println("  **********");
            if(p.toFile().list()!=null){
                File[] Fl=p.toFile().listFiles();
                for(File e:Fl){
                    b++;
                    for (int i=0;i<b;i++){
                        System.out.print(" ");
                    }
                    traverseDirector(e.toPath(),b);*/




    }

}