package ru.mail.polis.sort;

import java.util.Comparator;
import java.util.Random;

public class QuickSort1<T> extends AbstractSortOnComparisons<T>{

    private static Random random = new Random();
    private final int TRANSIT_TO_INSERT = 15;

    public void sort(T[] array){
        sort(array,0,array.length-1);
    }

    private  void sort(T[] array, int left, int right){

        if(right-left < TRANSIT_TO_INSERT) {
            insertSort(array);
            return;
        }
        if (left > right) return;

        int idx = partition(array,left,right);
        sort(array,left,idx);
        sort(array,idx+1,right);
    }

    private int partition(T[] array, int left, int right) {
        T p = array[left + random.nextInt(right - left + 1)];
        int i = left, j = right;
        while (i <= j) {
            while (lesser(array[i],p)) i++;
            while (greater(array[j],p)) j--;
            if (i <= j) {
                swap(array, i++, j--);
            }
        }
        return j;
    }

    public void insertSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            while (j >= 0 && greater(a[j],a[j + 1])){
                swap(a, j, j + 1);
                j--;
            }
        }
    }
}
