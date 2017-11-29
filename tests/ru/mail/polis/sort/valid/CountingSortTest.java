package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.structures.IntKeyStringValueObject;

import java.io.IOException;

import static org.junit.Assert.*;

public class CountingSortTest {


    @Test
    public void test1CountingSort() throws IOException{
        CountingSort<IntKeyStringValueObject> countingSort = new CountingSort<>();
        IntKeyStringValueObject[] isvo = new IntKeyStringValueObject[]{
                new IntKeyStringValueObject(1, "a"),
                new IntKeyStringValueObject(5, "f"),
                new IntKeyStringValueObject(3, "c"),
                new IntKeyStringValueObject(2, "b"),
                new IntKeyStringValueObject(4, "d")
        };
        countingSort.sort(isvo);
        Assert.assertArrayEquals(new IntKeyStringValueObject[]{
                new IntKeyStringValueObject(1, "a"),
                new IntKeyStringValueObject(2, "b"),
                new IntKeyStringValueObject(3, "c"),
                new IntKeyStringValueObject(4, "d"),
                new IntKeyStringValueObject(5, "f"),
        }, isvo);
    }
}
