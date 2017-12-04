package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    private static final Random r = ThreadLocalRandom.current();

    public static void main(String[] args) {
        String list = generateRandomString(1000);
        System.out.println(list);
    }

    public static String generateRandomString(int n){
        String list;
        String allSymbol = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] allSymbolCharArr = allSymbol.toCharArray();

            int len = r.nextInt(4);
            char[] tempChar = new char[len];
            for(int j =0; j<len;j++){
                tempChar[j] = allSymbolCharArr[r.nextInt(62)];
            }
            list = new String(tempChar);

        return list;
    }
}
