/*
* 在软件开发中，常用的对称加密算法有：

算法	密钥长度	工作模式	填充模式
DES	56/64	ECB/CBC/PCBC/CTR/...	NoPadding/PKCS5Padding/...
AES	128/192/256	ECB/CBC/PCBC/CTR/...	NoPadding/PKCS5Padding/PKCS7Padding/...
IDEA	128	ECB	PKCS5Padding/PKCS7Padding/...
* */
package Symmetric_encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HexFormat;

public class Main {

    public static void main(String[]args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String Message="哈哈哈哈哈，加密成功";

        byte[] key="1482782348278234".getBytes(StandardCharsets.UTF_8);
        byte[] data=Message.getBytes(StandardCharsets.UTF_8);
        //salt
        byte[] salt= SecureRandom.getInstanceStrong().generateSeed(16);    //随机生成一个长度为16字节数组

        byte[] encrypt=encrypt(key,data);
        byte[] decrypt=decrypt(key,encrypt);

        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypt));
        System.out.println("Decrypted: " + Base64.getEncoder().encodeToString(decrypt));


    }

    //加密
    public static byte[] encrypt(byte[] key,byte[] input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec=new SecretKeySpec(key,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        return cipher.doFinal(input);
    }
    //解密
    public static byte[] decrypt(byte[] key ,byte[] input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher=Cipher.getInstance("AES");
        SecretKey keySpec=new SecretKeySpec(key,"AES");
        cipher.init(Cipher.DECRYPT_MODE,keySpec);
        byte[] bytes=cipher.doFinal(input);
        return bytes;
    }



}

