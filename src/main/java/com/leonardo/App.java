package com.leonardo;

import com.leonardo.algorigmos.Aes;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Aes aes = new Aes("PdRgUkXp2s5v8y/B");
        String encrypted = aes.encrypt("Cristopher");
        System.out.println(encrypted);
        
        String decrypted = aes.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
