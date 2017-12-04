package ru.mail.polis.bench;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import ru.mail.polis.sort.AbstractSortOnComparisons;
import ru.mail.polis.sort.SortUtils;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchUtils {
    private AbstractSortOnComparisons<Integer> typeOfSortInteger;
    private AbstractSortOnComparisons<String> typeOfSortString;
    private Integer[]dataRandom, dataUnique, dataRepetative, dataSorted, dataMirror, dataAntiQS;
    private String[] stringRandom, stringEqLen, stringHW;
    private int countOfElem = 1000;

    public void setUpInvocation(AbstractSortOnComparisons<Integer> typeOfSortInteger, AbstractSortOnComparisons<String> typeOfSortString) {
        this.typeOfSortInteger = typeOfSortInteger;
        this.typeOfSortString = typeOfSortString;

        dataRandom = new Integer[countOfElem];
        dataUnique = new Integer[countOfElem];
        dataRepetative = new Integer[countOfElem];
        dataSorted = new Integer[countOfElem];
        dataMirror = new Integer[countOfElem];
        dataAntiQS = new Integer[countOfElem];
        stringEqLen = new String[countOfElem];
        stringRandom = new String[countOfElem];
        stringHW = new String[countOfElem];
        //рандомные данные
        dataRandom = SortUtils.generateRandomDateInteger(countOfElem);
        //Все элементы уникальные
        dataUnique = SortUtils.generateUniqueDateInteger(countOfElem);
        //Много повторяющихся
        dataRepetative = SortUtils.generateRepetitiveArrayInteger(countOfElem);
        //Отсортированный массив
        dataSorted = SortUtils.generateSortedArrayInteger(countOfElem);
        //Зеркально отсортированный массив
        dataMirror = SortUtils.generateMirrorArrayInteger(countOfElem);
        //Анти QuickSSort
        dataAntiQS = SortUtils.generateAntiQSortInteger(countOfElem);
        //Строки с разной длиной countOfElem
        stringRandom = SortUtils.generateRandomString(countOfElem);
        //Строки с фиксированной длиной 100
        stringEqLen = SortUtils.generateStringEq(countOfElem);
        //Все строки равны Hello World
        stringHW = SortUtils.generateAllWordEqHW(countOfElem);
    }
    @Benchmark
    public void measureRandom(Blackhole bh) {
        typeOfSortInteger.sort(dataRandom);
        bh.consume(dataRandom);
    }

    @Benchmark
    public void measureUnique(Blackhole bh) {
        typeOfSortInteger.sort(dataUnique);
        bh.consume(dataUnique);
    }

    @Benchmark
    public void measureRepetative(Blackhole bh) {
        typeOfSortInteger.sort(dataRepetative);
        bh.consume(dataRepetative);
    }

    @Benchmark
    public void measureSorted(Blackhole bh) {
        typeOfSortInteger.sort(dataSorted);
        bh.consume(dataSorted);
    }

    @Benchmark
    public void measureMirror(Blackhole bh) {
        typeOfSortInteger.sort(dataMirror);
        bh.consume(dataMirror);
    }

    @Benchmark
    public void measuretAntiQS(Blackhole bh) {
        typeOfSortInteger.sort(dataAntiQS);
        bh.consume(dataAntiQS);
    }

    @Benchmark
    public void measureStringRandom(Blackhole bh){
        typeOfSortString.sort(stringRandom);
        bh.consume(stringRandom);
    }

    @Benchmark
    public void measureStringEqLen(Blackhole bh){
        typeOfSortString.sort(stringEqLen);
        bh.consume(stringEqLen);
    }

    @Benchmark
    public void measureStringHW (Blackhole bh){
        typeOfSortString.sort(stringHW);
        bh.consume(stringHW);
    }
}
