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
import ru.mail.polis.sort.LSDSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.IntKeyStringValueObject;
import ru.mail.polis.structures.SimpleInteger;
import ru.mail.polis.structures.SimpleString;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class LSDSortBench {

    private static final Random r = ThreadLocalRandom.current();

    private SimpleInteger[] dataRandom, dataUnique, dataRepetative,
            dataSorted, dataMirror, dataAntiQS;
    private SimpleString[] stringRandom, stringEqLen, stringHW;
    private int countOfElem = 10000;

    private SimpleString[] transform(String[] array){
        SimpleString[] a = new SimpleString[array.length];
        for(int i =0; i< a.length;i++){
            a[i] = new SimpleString(array[i]);
        }
        return a;
    }

    private SimpleInteger[] transform(Integer[] array){
        SimpleInteger[] a = new SimpleInteger[array.length];
        for(int i =0; i< a.length;i++){
            a[i] = new SimpleInteger(array[i]);
        }
        return a;
    }

    @Setup(value = Level.Trial)
    public void setUpTrial(){
        dataRandom = new SimpleInteger[countOfElem];
        dataUnique = new SimpleInteger[countOfElem];
        dataRepetative = new SimpleInteger[countOfElem];
        dataSorted = new SimpleInteger[countOfElem];
        dataMirror = new SimpleInteger[countOfElem];
        dataAntiQS = new SimpleInteger[countOfElem];
        stringEqLen = new SimpleString[countOfElem];
        stringRandom = new SimpleString[countOfElem];
        stringHW = new SimpleString[countOfElem];
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
    //    stringRandom = transform(SortUtils.generateRandomString(countOfElem));
        //Строки с фиксированной длиной 100
     //   stringEqLen = transform(SortUtils.generateStringEq(countOfElem));
        //Все строки равны Hello World
     //   stringHW = transform(SortUtils.generateAllWordEqHW(countOfElem));
    }

    @Benchmark
    public void measureRandom(Blackhole bh) {
        new LSDSort<>().sort(dataRandom);
        bh.consume(dataRandom);
    }

    @Benchmark
    public void measureUnique(Blackhole bh) {
        new LSDSort<>().sort(dataUnique);
        bh.consume(dataUnique);
    }

    @Benchmark
    public void measureRepetative(Blackhole bh) {
        new LSDSort<>().sort(dataRepetative);
        bh.consume(dataRepetative);
    }

    @Benchmark
    public void measureSorted(Blackhole bh) {
        new LSDSort<>().sort(dataSorted);
        bh.consume(dataSorted);
    }

    @Benchmark
    public void measureMirror(Blackhole bh) {
        new LSDSort<>().sort(dataMirror);
        bh.consume(dataMirror);
    }

    @Benchmark
    public void measuretAntiQS(Blackhole bh) {
        new LSDSort<>().sort(dataAntiQS);
        bh.consume(dataAntiQS);
    }
/*
    @Benchmark
    public void measureStringRandom(Blackhole bh){
        new LSDSort<>().sort(stringRandom);
        bh.consume(stringRandom);
    }

    @Benchmark
    public void measureStringEqLen(Blackhole bh){
        new LSDSort<>().sort(stringEqLen);
        bh.consume(stringEqLen);
    }

    @Benchmark
    public void measureStringHW (Blackhole bh){
        new LSDSort<>().sort(stringHW);
        bh.consume(stringHW);
    }
*/
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
