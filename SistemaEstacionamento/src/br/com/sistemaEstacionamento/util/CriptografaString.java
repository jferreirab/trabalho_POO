/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desenvolvedor
 */
public class CriptografaString {
    
    public static String criptografiaHashMd5(String stringOriginal) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        MessageDigest algoritmoCriptografia = MessageDigest.getInstance("MD5");
        byte[] stringCriptografadaBytes = algoritmoCriptografia.digest(stringOriginal.getBytes("UTF-8"));
        
        StringBuilder stringBuilder = new StringBuilder();
        for (byte byteCriptografado : stringCriptografadaBytes){
             stringBuilder.append(Integer.toHexString((byteCriptografado & 0xFF) | 0x100).substring(1,3));
        }
        
        return stringBuilder.toString();
    }
}
