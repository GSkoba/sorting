package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;
import java.lang.reflect.Array;

import java.util.Comparator;

public class LSD<T extends Numerical> implements Sort<T>{


    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array){
        int rage = array[0].getDigitMaxValue()+1;
        int maxDigit = findMaxDigit(array);
        for (int i = 0; i < maxDigit; i++) {
            int[] count = new int[rage];
            for (T x : array) count[x.getDigit(i)]++;
            for (int j = 1; j < rage; j++) {
                count[j] += count[j - 1];
            }
            T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
            for (int j = array.length - 1; j >= 0; j--) {
                result[--count[array[j].getDigit(i)]] = array[j];
            }
            System.arraycopy(result, 0, array, 0, array.length);
        }
    }

    private int findMaxDigit(T[] a) {
        int maxDigit = 0;
        for (T x : a) {
            maxDigit = Math.max(maxDigit, x.getDigitCount());
        }
        return maxDigit;
    }
}
