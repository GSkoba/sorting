package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.AbstractSortOnComparisons;
import ru.mail.polis.sort.MergeSort;

import java.io.IOException;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void test1MergeSort() throws IOException{
        AbstractSortOnComparisons<String> mergeSort = new MergeSort<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        mergeSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void test2MergeSort() throws IOException{
        AbstractSortOnComparisons<Integer> mergeSort = new MergeSort<>();
        Integer[] array = new Integer[]{9,8,7,6,5,4,3,2,1};
        mergeSort.sort(array);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, array);
    }
}