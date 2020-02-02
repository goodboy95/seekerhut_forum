package com.seekerhut.utils;

import java.util.Date;
import java.util.Random;

public class CommonFunctions {
    private static String charIndex = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+`-=abcdefghijklmnopqrstuvwxyz{}:|<>?[];',./";
    private static int charIndexLen = 92;

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < length; i++) {
            int idx = r.nextInt(charIndexLen);
            sb.append(charIndex.charAt(idx));
        }
        return sb.toString();
    }
}
