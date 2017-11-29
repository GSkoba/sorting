package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.AbstractSortOnComparisons;
import ru.mail.polis.sort.QuickSort2;
import ru.mail.polis.sort.*;
import ru.mail.polis.structures.IntKeyStringValueObject;
import ru.mail.polis.structures.SimpleString;
import java.io.IOException;

import static org.junit.Assert.*;

public class QuickSort2Test {

    @Test
    public void test1QuickSort2() throws IOException{
        AbstractSortOnComparisons<String> quickSort2 = new QuickSort2<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        quickSort2.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }

    @Test
    public void test2QuickSort2() throws IOException{
        AbstractSortOnComparisons<Integer> quickSort2 = new QuickSort2<>();
        Integer[] array = new Integer[]{9,8,7,6,5,4,3,2,1};
        quickSort2.sort(array);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, array);
    }

}