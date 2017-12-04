package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    Integer data;
   // private final int length;
    public SimpleInteger(){

    }
    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        this.data = data;
        //  this.length = todo
    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {
            //todo
            return 0;//data>>index & 1;
        }
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return Integer.SIZE/2;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return 0;
    }
}
