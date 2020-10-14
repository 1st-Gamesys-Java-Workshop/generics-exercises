package com.gamesys.samples.generics.without;

public class WithoutGenericsMain {

    public static void main(String[] args) {
        SimpleEncryptor simpleEncryptor = new SimpleEncryptor();

        String encryptedMessage = simpleEncryptor.encrypt("Hello World");
        String encryptedNumber = simpleEncryptor.encrypt(12345);

        System.out.println("Hello World is " + encryptedMessage);
        System.out.println("12345 is " + encryptedNumber);

        // Without Generics the return of the decrypt() method has to down casted
        String decryptedMessage = (String) simpleEncryptor.decrypt("UlJTSGVsbG8gV29ybGQ=");
        Integer decryptedNumber = (Integer) simpleEncryptor.decrypt("UlJJMTIzNDU=");

        System.out.println("UlJTSGVsbG8gV29ybGQ= is " + decryptedMessage);
        System.out.println("UlJJMTIzNDU= is " + decryptedNumber);
    }

}
