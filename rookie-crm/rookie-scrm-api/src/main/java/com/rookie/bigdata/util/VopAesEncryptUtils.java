package com.rookie.bigdata.util;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Class VopAesEncryptUtils
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:07
 * @Version 1.0
 */
public class VopAesEncryptUtils {


    /**
     * 进行加密
     *
     * @param source
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String source, String key) throws Exception {

        return parseByte2HexStr(encrypt(getBytes(source), key));


    }

    /**
     * 解密
     */
    public static String decrypt(String source, String key) throws Exception {
        return getDecryptResultString(decrypt(parseHexStr2Byte(source), key));
    }

    private static String getDecryptResultString(byte[] decryptResultArray) {
        return new String(decryptResultArray, StandardCharsets.UTF_8);
    }

    private static byte[] getBytes(String source) throws Exception {
        if (StringUtils.isBlank(source)) {
            throw new Exception("encrypt content is empty");
        }
        return source.getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] encrypt(byte[] content, String password) throws Exception {
        try {
            SecretKeySpec key = generateAESKeySpec(password);
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            return cipher.doFinal(content);
        } catch (Exception exception) {
            throw new Exception(exception.getCause());
        }
    }

    /**
     * 将二进制转换成 16 进制
     *
     * @param content content
     * @return string
     */
    private static byte[] decrypt(byte[] content, String password) throws Exception {
        SecretKeySpec key = generateAESKeySpec(password);
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        return cipher.doFinal(content);
    }

    private static SecretKeySpec generateAESKeySpec(String password) throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        return new SecretKeySpec(enCodeFormat, "AES");
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将 16 进制转换为二进制
     *
     * @param hexStr the hex str
     * @return byte [ ]
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (StringUtils.isBlank(hexStr))
            return new byte[0];
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String key = "875e9069ebd45519d8060d23d1e21998";
        String originStr = "18200000001";
        String encryptStr = encrypt(originStr, key);
        System.out.println("encrypt str: " + encryptStr);
        String decryptStr = decrypt(encryptStr, key);
        System.out.println("decrypt str: " + decryptStr + ", decrypt is ：" + (originStr.equals(decryptStr)));
    }
}
