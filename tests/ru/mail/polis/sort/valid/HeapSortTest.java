package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.AbstractSortOnComparisons;
import ru.mail.polis.sort.HeapSort;

import java.io.IOException;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void test1HeapSort() throws IOException {
        AbstractSortOnComparisons<String> heapSort = new HeapSort<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        heapSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void test2HeapSort() throws IOException{
        AbstractSortOnComparisons<Integer> heapSort = new HeapSort<>();
        Integer[] array = new Integer[]{9,8,7,6,5,4,3,2,1};
        heapSort.sort(array);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, array);
    }

}