package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.mail.polis.sort.AbstractSortOnComparisons;
import ru.mail.polis.sort.QuickSort1;
import ru.mail.polis.structures.SimpleInteger;

import java.io.IOException;

import static org.junit.Assert.*;

public class QuickSort1Test {

    @Test
    public void test1QuickSort1() throws IOException {
        AbstractSortOnComparisons<String> quickSort1 = new QuickSort1<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        quickSort1.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void test2QuickSort1() throws IOException{
        AbstractSortOnComparisons<Integer> quickSort1 = new QuickSort1<>();
        Integer[] array = new Integer[]{9,8,7,6,5,4,3,2,1};
        quickSort1.sort(array);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, array);
    }
    @Ignore
    @Test
    public void test3QuickSort1() throws IOException {
        AbstractSortOnComparisons<SimpleInteger> quickSort1 = new QuickSort1<>();
        SimpleInteger[] array = new SimpleInteger[]{new SimpleInteger(9),
                new SimpleInteger(8),
                new SimpleInteger(7),
                new SimpleInteger(6),
                new SimpleInteger(5),};
        quickSort1.sort(array);

        SimpleInteger[] currArray = new SimpleInteger[]{new SimpleInteger(5),
                new SimpleInteger(6),
                new SimpleInteger(7),
                new SimpleInteger(8),
                new SimpleInteger(9),};
        Assert.assertArrayEquals(currArray,array);
    }

}