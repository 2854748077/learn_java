
//Base64.getEncoder().encodeToString(byte[] input):将字节数组编码为 Base64 字符串。
//Base64.getDecoder().decode(b64Encoded) :将 Base64 字符串解码为字节数组
//withoutPadding():编码的时候去掉等号
//getUrlEncoder():url能使用的bash64编码。（+变成-，/变成_：）
//.hashCode：获取hashcode编码
package thread.example;


import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HexFormat;

public class Main {
    public static void main(String[] args) {

        //******************************************************************************
        //URL编码
        String encode= URLEncoder.encode("中文！", StandardCharsets.UTF_8);
        System.out.println("Url编码："+encode);
        String decode= URLDecoder.decode(encode,StandardCharsets.UTF_8);
        System.out.println(decode);

        //****************************************************************************************
        //bash64编码（二进制数据编码为文本）
        byte[] input = new byte[]{(byte) 0xe4,(byte) 0xb8, (byte) 0xad,(byte) 0xad};
        String b64Encoded= Base64.getEncoder().withoutPadding().encodeToString(input);        // 将字节数组编码为 Base64 字符串。
        System.out.println(b64Encoded);
        byte[] output=Base64.getDecoder().decode(b64Encoded);
        System.out.println(Arrays.toString(output));
        //********************************************************************************************
        //针对URL的bash64编码
        String b64Encoded1= Base64.getUrlEncoder().withoutPadding().encodeToString(input);        // 将字节数组编码为 Base64 字符串。
        System.out.println(b64Encoded1);
        byte[] output1=Base64.getDecoder().decode(b64Encoded);
        System.out.println(Arrays.toString(output1));
        //**************************************************************************************************
        int HashCode="hello world".hashCode();
        System.out.println("*********\n"+"hello world（的hashcode码）："+HashCode);
        System.out.println("AaAaAa".hashCode()+"**********"+"BBAaBB".hashCode()); // 哈希碰撞，不同的输入，相同的输出
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-512");               //MD5算法计算哈希值
            md.update("Hello".getBytes("UTF-8"));
            md.update("World".getBytes("UTF-8"));
            byte[] result=md.digest();
            System.out.println(HexFormat.of().formatHex(result));                   //HexFormat.of()：创建HexFormat实例，提供了多种将字节数组格式化为十六进制字符串的方式
                                                                                     //formatHex():实例提供的方法，把  byte[] -> String
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }catch (IOException e){

        }


    }
}