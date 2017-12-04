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

        if(right-left < TRANSIT_TO_INSERT) insertSort(array);

        if (left > right) return;

        int temp = left+random.nextInt(right-left+1);
        T pivot = array[temp];
        int b = left;
        int j = left;

        swap(array,left,temp);

        for(int i=left+1; i<=right; i++){
            if(lesser(array[i],pivot)){
                swap(array,++j,i);
            }else if(array[i]==pivot){
                swap(array,i,j++);
                swap(array,++b,j);
            }
        }

        int del = j;

        for(int i = left; i<=b; i++){
            swap(array,i,j--);
        }

        sort(array,left,j);
        sort(array,del+1,right);
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
