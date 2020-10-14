package com.gamesys.samples.generics.with;

import java.util.Base64;

/*
    Warning: This is not the correct way of encrypting/decrypting data.
    This is just an example and it merely encodes data to Base 64 format.
    Do not use in production. LOL!
 */
public class SimpleEncryptor<T> {

    public String encrypt(T value) {
        String valueString = "RR" + getTypeIdentifier(value) + value;
        // e.g. value = Hello; valueString = RRSHello
        return Base64.getEncoder().encodeToString(valueString.getBytes());
    }

    public T decrypt(String encrypted) {
        String decodedString = decodeString(encrypted);
        char typeIdentifier = decodedString.charAt(2);
        Class<T> dataType;
        switch (typeIdentifier) {
            case 'I':
                dataType = (Class<T>) Integer.class;
                Integer integerValue = Integer.valueOf(decodedString.substring(3));
                return dataType.cast(integerValue);
            case 'D':
                dataType = (Class<T>) Double.class;
                Double doubleValue = Double.valueOf(decodedString.substring(3));
                return dataType.cast(doubleValue);
            case 'B':
                dataType = (Class<T>) Boolean.class;
                Boolean booleanValue = Boolean.valueOf(decodedString.substring(3));
                return dataType.cast(booleanValue);
            case 'S':
                dataType = (Class<T>) String.class;
                return dataType.cast(decodedString.substring(3));
            default:
                throw new IllegalArgumentException("Data type is not supported.");
        }
    }

    private String decodeString(String encrypted) {
        byte[] valueBytes = Base64.getDecoder().decode(encrypted);
        return new String(valueBytes);
    }

    private String getTypeIdentifier(T value) {
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

}
