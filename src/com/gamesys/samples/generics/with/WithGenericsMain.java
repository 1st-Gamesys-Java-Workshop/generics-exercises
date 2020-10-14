package com.gamesys.samples.generics.with;

public class WithGenericsMain {

    public static void main(String[] args) {
        SimpleEncryptor<String> stringEncryptor = new SimpleEncryptor<>();
        SimpleEncryptor<Integer> integerEncryptor = new SimpleEncryptor<>();

        String encryptedMessage = stringEncryptor.encrypt("Hello World");
        String encryptedNumber = integerEncryptor.encrypt(12345);

        System.out.println("Hello World is " + encryptedMessage);
        System.out.println("12345 is " + encryptedNumber);

        // With Generics the return of the decrypt() method doesn't need to be down casted
        String decryptedMessage = stringEncryptor.decrypt("UlJTSGVsbG8gV29ybGQ=");
        Integer decryptedNumber = integerEncryptor.decrypt("UlJJMTIzNDU=");

        System.out.println("UlJTSGVsbG8gV29ybGQ= is " + decryptedMessage);
        System.out.println("UlJJMTIzNDU= is " + decryptedNumber);
    }

}
