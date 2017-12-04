package ru.mail.polis.sort;

import ru.mail.polis.structures.IntKeyObject;

public class CountingSort <T extends IntKeyObject> implements Sort<T>{

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array) {
        int maxKey = findMax(array);
        int[] values = new int[maxKey+1];
        for (T i : array) values[i.getKey()]++;
        for(int i =1; i<maxKey+1;i++) values[i] += values[i-1];
        T[] result = (T[])new IntKeyObject[array.length];
        for(int i = array.length-1; i>=0;i--) result[--values[array[i].getKey()]] = array[i];
        System.arraycopy(result,0,array,0,array.length);
    }

    private int findMax(T[] array) {
        int maxKey = 0;
        for (T i : array) {
            int currentKey = i.getKey();
            if(maxKey < currentKey) maxKey = currentKey;
        }
        return maxKey;
    }

}
