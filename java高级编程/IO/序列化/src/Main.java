import java.io.*;
import java.util.Arrays;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args)throws IOException {


        ByteArrayOutputStream baos=new ByteArrayOutputStream();                 //序列化
        try(ObjectOutputStream oos=new ObjectOutputStream(baos)){       //把oos转换为byte存放在数组baos中（转换为byteArray）
            oos.writeInt(12345);
            oos.writeUTF("成功写入");
            oos.writeObject(12.5);
            oos.flush();
        };
        System.out.println(Arrays.toString(baos.toByteArray()));                                //输出转换后二进制代码
        //System.out.println(baos);
        ;                                //输出转换后二进制代码
        ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());       //反序列化
        try(ObjectInputStream Ois=new ObjectInputStream(bais)){
            int a=Ois.readInt();
            String str=Ois.readUTF();
            try {
                Double d = (Double) Ois.readObject();
            }catch (ClassNotFoundException e){

            }
            System.out.println(a+" "+str+" ");
        }
    }
}