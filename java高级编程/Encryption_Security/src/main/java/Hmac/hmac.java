package Hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Map;

public class hmac {
    public static void main (String[]args)throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {

        KeyGenerator keygen=KeyGenerator.getInstance("HmacMD5");
        SecretKey key=keygen.generateKey();
        byte[] keys=key.getEncoded();
        System.out.println("随机生成的key：  "+HexFormat.of().formatHex(keys));                      //打印随机生成的key
        Mac mac = Mac.getInstance("HmacMD5");              //mac：实例化Hmac算法
        mac.init(key);                                               //init（）：使用key初始化mac实例
        mac.update("HelloWorld".getBytes("UTF-8"));      //update（）：添加数据
        byte[] result = mac.doFinal();                               //doFinal（）：完成哈希计算，并返回结果
        System.out.println(HexFormat.of().formatHex(result));       //转化为16进制打印输出

        byte[] hkey = HexFormat.of().parseHex(
                "b648ee779d658c420420d86291ec70f5" +
                        "cf97521c740330972697a8fad0b55f5c" +
                        "5a7924e4afa99d8c5883e07d7c3f9ed0" +
                        "76aa544d25ed2f5ceea59dcc122babc8");

        SecretKey key2 = new SecretKeySpec(hkey, "HmacMD5");       //new SecretKeySpec():恢复SecretKey
        Mac mac2 = Mac.getInstance("HmacMD5");
        mac2.init(key2);
        mac2.update("HelloWorld".getBytes("UTF-8"));
        byte[] result2 = mac.doFinal();
        System.out.println(HexFormat.of().formatHex(result2)); // 4af40be7864efaae1473a4c601b650ae

    }
}
