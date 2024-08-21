package BouncyCastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.HexFormat;

public class bouncyCastle {
    public static void main(String[]arg)throws NoSuchAlgorithmException {
        //注册Bouncy Castle
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest messageDigest1=MessageDigest.getInstance("RipeMD160");
        messageDigest1.update("你好啊！".getBytes(StandardCharsets.UTF_8));
        byte[] b1=messageDigest1.digest();
        System.out.println(Arrays.toString(b1));
        System.out.println(HexFormat.of().formatHex(b1));
    }
}
