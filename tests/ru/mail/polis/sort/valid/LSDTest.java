package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.mail.polis.sort.LSD;
import ru.mail.polis.structures.SimpleString;

import java.io.IOException;

import static org.junit.Assert.*;

public class LSDTest {


    @Test
    public void test1LSD() throws IOException {
        LSD<SimpleString> lsdSort = new LSD<>();
        SimpleString[] array = new SimpleString[]{
                new SimpleString("bcd"),
                new SimpleString("abc"),
                new SimpleString("zxy"),
                new SimpleString("cde"),
                new SimpleString("acd"),
                new SimpleString("bba"),
        };
        lsdSort.sort(array);
        Assert.assertArrayEquals(new SimpleString[]{
                new SimpleString("abc"),
                new SimpleString("acd"),
                new SimpleString("bba"),
                new SimpleString("bcd"),
                new SimpleString("cde"),
                new SimpleString("zxy"),
        }, array);
    }
}