package com.leonardo.algorigmos;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    private final String key;
    private static String iv = "l76FWf2M8vd6ndL3";

    public Aes(String key) {
        this.key = key;
    }

    public byte[] encrypt(byte[] bytes) throws Exception{
        Cipher aes = getCipher();
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        aes.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv.getBytes("UTF-8")));
        return aes.doFinal(bytes);
    }

    public String encrypt(String plainText) throws Exception{
        byte[] bytes = plainText.getBytes("UTF-8");
        byte[] bytesEncrypted = encrypt(bytes);
        return Base64.getEncoder().encodeToString(bytesEncrypted);
    }

    public byte[] decrypt(byte[] bytes) throws Exception{
        Cipher aes = getCipher();
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        aes.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv.getBytes("UTF-8")));
        return aes.doFinal(bytes);
    }

    public String decrypt(String encrypted) throws Exception{
        byte[] bytes = Base64.getDecoder().decode(encrypted);
        byte[] bytesDecrypted = decrypt(bytes);
        return new String(bytesDecrypted, StandardCharsets.UTF_8);
    }

    private Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException{
        return Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}
