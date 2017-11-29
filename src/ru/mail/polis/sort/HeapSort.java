package ru.mail.polis.sort;

import java.util.Comparator;

public class HeapSort<T> extends AbstractSortOnComparisons<T> {

    public HeapSort(){
        super();
    }

    public HeapSort(Comparator<? super T> comparator){
        super(comparator);
    }

    @Override
    public void sort(T[] arr)
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(T[] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && greater(arr[l],arr[largest]))
            largest = l;

        if (r < n && greater(arr[r],arr[largest]))
            largest = r;

        if (largest != i)
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
