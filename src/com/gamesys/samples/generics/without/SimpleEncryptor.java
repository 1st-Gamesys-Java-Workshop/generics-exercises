package com.gamesys.samples.generics.without;

import java.util.Base64;

/*
    Warning: This is not the correct way of encrypting/decrypting data.
    This is just an example and it merely encodes data to Base 64 format.
    Do not use in production. LOL!
 */
public class SimpleEncryptor {

    public String encrypt(Object value) {
        String valueString = "RR" + getTypeIdentifier(value) + value;
        // e.g. value = Hello; valueString = RRSHello
        return Base64.getEncoder().encodeToString(valueString.getBytes());
    }

    public Object decrypt(String encrypted) {
        String decodedString = decodeString(encrypted);
        char typeIdentifier = decodedString.charAt(2);
        switch (typeIdentifier) {
            case 'I':
                return Integer.valueOf(decodedString.substring(3));
            case 'D':
                return Double.valueOf(decodedString.substring(3));
            case 'B':
                return Boolean.valueOf(decodedString.substring(3));
            case 'S':
                return decodedString.substring(3);
            default:
                throw new IllegalArgumentException("Data type is not supported.");
        }
    }

    private String getTypeIdentifier(Object value) {
        if (value instanceof Integer) {
            return "I";
        } else if (value instanceof Double) {
            return "D";
        } else if (value instanceof Boolean) {
            return "B";
        } else if (value instanceof String) {
            return "S";
        }
        throw new IllegalArgumentException("Data type is not supported.");
    }

    private String decodeString(String encrypted) {
        byte[] valueBytes = Base64.getDecoder().decode(encrypted);
        return new String(valueBytes);
    }

}
