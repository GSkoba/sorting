package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.IntKeyStringValueObject;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class CountingSortBench {

    private static final Random r = ThreadLocalRandom.current();

    private IntKeyStringValueObject[] dataRandom, dataUnique, dataRepetative,
            dataSorted, dataMirror, dataAntiQS, stringRandom, stringEqLen, stringHW;
    private int countOfElem = 100000;

    private IntKeyStringValueObject[] transform(Integer[] array){
        IntKeyStringValueObject[] a = new IntKeyStringValueObject[array.length];
        for(int i =0; i< a.length;i++){
            a[i] = new IntKeyStringValueObject(array[i],generateRandomString());
        }
        return a;
    }

    private IntKeyStringValueObject[] transform(String[] array){
        IntKeyStringValueObject[] a = new IntKeyStringValueObject[array.length];
        for(int i =0; i< a.length;i++){
            a[i] = new IntKeyStringValueObject(r.nextInt(10),array[i]);
        }
        return a;
    }

    public static String generateRandomString(){
        String list;
        String allSymbol = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] allSymbolCharArr = allSymbol.toCharArray();

        int len = r.nextInt(4);
        char[] tempChar = new char[len];
        for(int j =0; j<len;j++){
            tempChar[j] = allSymbolCharArr[r.nextInt(62)];
        }
        list = new String(tempChar);

        return list;
    }

    @Setup(value = Level.Trial)
    public void setUpTrial(){
        dataRandom = new IntKeyStringValueObject[countOfElem];
        dataUnique = new IntKeyStringValueObject[countOfElem];
        dataRepetative = new IntKeyStringValueObject[countOfElem];
        dataSorted = new IntKeyStringValueObject[countOfElem];
        dataMirror = new IntKeyStringValueObject[countOfElem];
        dataAntiQS = new IntKeyStringValueObject[countOfElem];
        stringEqLen = new IntKeyStringValueObject[countOfElem];
        stringRandom = new IntKeyStringValueObject[countOfElem];
        stringHW = new IntKeyStringValueObject[countOfElem];
        //рандомные данные
        dataRandom = transform(SortUtils.generateRandomDateInteger(countOfElem));
        //Все элементы уникальные
        dataUnique = transform(SortUtils.generateUniqueDateInteger(countOfElem));
        //Много повторяющихся
        dataRepetative = transform(SortUtils.generateRepetitiveArrayInteger(countOfElem));
        //Отсортированный массив
        dataSorted = transform(SortUtils.generateSortedArrayInteger(countOfElem));
        //Зеркально отсортированный массив
        dataMirror = transform(SortUtils.generateMirrorArrayInteger(countOfElem));
        //Анти QuickSSort
        dataAntiQS = transform(SortUtils.generateAntiQSortInteger(countOfElem));
        //Строки с разной длиной countOfElem
        stringRandom = transform(SortUtils.generateRandomString(countOfElem));
        //Строки с фиксированной длиной 100
        stringEqLen = transform(SortUtils.generateStringEq(countOfElem));
        //Все строки равны Hello World
        stringHW = transform(SortUtils.generateAllWordEqHW(countOfElem));
    }

    @Benchmark
    public void measureRandom(Blackhole bh) {
        new CountingSort<>().sort(dataRandom);
        bh.consume(dataRandom);
    }

    @Benchmark
    public void measureUnique(Blackhole bh) {
        new CountingSort<>().sort(dataUnique);
        bh.consume(dataUnique);
    }

    @Benchmark
    public void measureRepetative(Blackhole bh) {
        new CountingSort<>().sort(dataRepetative);
        bh.consume(dataRepetative);
    }

    @Benchmark
    public void measureSorted(Blackhole bh) {
        new CountingSort<>().sort(dataSorted);
        bh.consume(dataSorted);
    }

    @Benchmark
    public void measureMirror(Blackhole bh) {
        new CountingSort<>().sort(dataMirror);
        bh.consume(dataMirror);
    }

    @Benchmark
    public void measuretAntiQS(Blackhole bh) {
        new CountingSort<>().sort(dataAntiQS);
        bh.consume(dataAntiQS);
    }

    @Benchmark
    public void measureStringRandom(Blackhole bh){
        new CountingSort<>().sort(stringRandom);
        bh.consume(stringRandom);
    }

    @Benchmark
    public void measureStringEqLen(Blackhole bh){
        new CountingSort<>().sort(stringEqLen);
        bh.consume(stringEqLen);
    }

    @Benchmark
    public void measureStringHW (Blackhole bh){
        new CountingSort<>().sort(stringHW);
        bh.consume(stringHW);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CountingSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
