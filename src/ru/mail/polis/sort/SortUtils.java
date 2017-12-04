package ru.mail.polis.sort;

import ru.mail.polis.structures.SimpleInteger;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortUtils {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swap(Integer[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    public static void swap(SimpleInteger[] a, int i, int j) {
        SimpleInteger x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    //generateInteger
    public static Integer[] generateRandomDateInteger(int n){
        Integer[] a = new Integer[n];

        for(int i = 0; i< a.length; i++){
            a[i] = r.nextInt(i+1);
        }
        return a;
    }

    public static Integer[] generateUniqueDateInteger(int n){
        Integer[] a = new Integer[n];

        for(int i = 0; i<a.length; i++){
            a[i] = i;
        }

        for(int i = a.length-1;i>0; i--){
            int j = r.nextInt(i+1);
            SortUtils.swap(a,i,j);
        }
        return a;
    }

    public static Integer[] generateIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;
    }

    public static Integer[] generateRepetitiveArrayInteger(int n){
        Integer[] a = new Integer[n];

        for(int i=0; i<a.length;i++){
            a[i] = r.nextInt(2);
        }
        return a;
    }

    public static Integer[] generateSortedArrayInteger(int n){
        Integer[] a = new Integer[n];

        for(int i =0; i<a.length;i++){
            a[i] = i;
        }
        return a;
    }

    public static Integer[] generateAntiQSortInteger(int n){
        Integer[] a = new Integer[n];

        for(int i = 0;i<a.length;i++){
            a[i] = i;
        }

        for(int i = 2; i< n; i++){
            swap(a,i,i/2);
        }
        return a;
    }

    public static Integer[] generateMirrorArrayInteger(int n){
        Integer[] a = new Integer[n];

        for(int i =a.length-1; i>=0;i--){
            a[i] = i;
        }
        return a;
    }

    //end generateInteger


    //generateString


    public static String[] generateRandomString(int n){
        String[] list = new String[n];
        String allSymbol = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] allSymbolCharArr = allSymbol.toCharArray();
        for(int i = 0; i<list.length; i++){
            int len = r.nextInt(10);
            char[] tempChar = new char[len];
            for(int j =0; j<len;j++){
                tempChar[j] = allSymbolCharArr[r.nextInt(62)];
            }
            list[i] = new String(tempChar);
        }
        return list;
    }

    public static String[] generateStringEq(int n){
        String[] list = new String[n];
        String allSymbol = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] allSymbolCharArr = allSymbol.toCharArray();
        for(int i = 0; i<list.length; i++){
            int len = 100;
            char[] tempChar = new char[len];
            for(int j =0; j<len;j++){
                tempChar[j] = allSymbolCharArr[r.nextInt(62)];
            }
            list[i] = new String(tempChar);
        }
        return list;
    }

    public static String[] generateAllWordEqHW(int n){
        String[] list = new String[n];
        for(int i =0; i<list.length;i++){
            list[i] = "Hello world!";
        }
        return list;
    }

    //end generateString


    public static int[] generateArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;
    }

    public static boolean isArraySorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    public static <T extends Comparable<? super T>> boolean isArraySorted(T[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = array[i].compareTo(array[i + 1]) <= 0;
        }
        return isSorted;
    }

    public static <T> boolean isArraySorted(T[] array, Comparator<T> comparator) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = comparator.compare(array[i], array[i + 1]) <= 0;
        }
        return isSorted;
    }
}
