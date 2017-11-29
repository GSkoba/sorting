package ru.mail.polis.sort;

import java.util.Comparator;

import static java.lang.Math.min;

public class MergeSort<T> extends AbstractSortOnComparisons<T> {

    public MergeSort(){
        super();
    }

    public MergeSort(Comparator<? super T> comparator){
        super(comparator);
    }

    @Override
    public void sort(T[] array){
        for(int i = 1; i<array.length; i*=2){
            for(int j = 0; j<array.length-i; j+=2*i){
                merge(array,j,j+i,min(j+2*i,array.length));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] array,int left,int m, int right){

        int it1 = 0;
        int it2 = 0;

        T[] result = (T[])new Object[right-left];

        while (left+it1 < m && m+it2 < right){
            if(lesser(array[left+it1],array[m+it2])){
                result[it1+it2]=array[left+it1];
                it1++;
            }else {
                result[it1+it2] = array[m+it2];
                it2++;
            }
        }

        while (left+it1 <m){
            result[it1+it2] = array[left+it1];
            it1++;
        }
        while (m+it2<right){
            result[it1+it2]=array[m+it2];
            it2++;
        }

        System.arraycopy(result,0,array,left,it1+it2);
    }

}
