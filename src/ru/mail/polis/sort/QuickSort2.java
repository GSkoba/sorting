package ru.mail.polis.sort;

import java.util.Comparator;
import java.util.Random;

import static ru.mail.polis.sort.SortUtils.swap;

public class QuickSort2<T> extends AbstractSortOnComparisons<T>{

    private static Random random = new Random();

    public QuickSort2(){
        super();
    }

    public QuickSort2(Comparator<? super T> comparator){
        super(comparator);
    }

    @Override
    public void sort(T[] array){
        sort(array,0,array.length-1);
    }

    private  void sort(T[] array, int left, int right){
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

}
