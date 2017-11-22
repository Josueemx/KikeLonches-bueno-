/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.kikelonches.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Morales
 */
public class Security {
    
    public static String MD5Encode(String Password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(Password.getBytes("UTF-8")));
    }
    
}
