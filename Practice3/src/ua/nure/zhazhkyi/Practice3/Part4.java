package ua.nure.zhazhkyi.Practice3;

import java.security.*;

public class Part4 {

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        String s = null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                s = String.format("00000000%s", Integer.toBinaryString(hash[i])).replace(' ', '0');
            } else {
                s = Integer.toBinaryString(hash[i]);
            }
            s = s.substring(s.length() - 8);
            s = Integer.toHexString(Integer.valueOf(s, 2));
            if (s.length() == 1) {
                s = "0" + s;
            }
            builder.append(s.toUpperCase());
        }
        return builder.toString();
    }

}