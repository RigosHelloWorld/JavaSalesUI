package server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    //so class can not be instatianted
    private Encryptor(){};


    public static String getHash(String input){

        
        try{

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //update the obj with the input.bytes
            messageDigest.update(input.getBytes());

            //the digest function returns a byte array
            byte[] byteArray = messageDigest.digest();

            
            BigInteger bigInt = new BigInteger(1,byteArray);

            //System.out.println(bigInt.toString(16));

            //return the hashed string
            return bigInt.toString(16);

        }catch(NoSuchAlgorithmException e ){
            System.out.println(e.getMessage());
        }

        return "";

    }
}
