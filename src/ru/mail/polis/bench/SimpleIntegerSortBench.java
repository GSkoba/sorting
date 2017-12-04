package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;
import ru.mail.polis.structures.SimpleInteger;

/**
 * Created by Nechaev Mikhail
 * Since 27/11/2017.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class SimpleIntegerSortBench {
    //todo: классы extends AbstractSortOnComparisons и LSDSort
    private static AbstractSortOnComparisons<SimpleInteger> quickSort1 = new QuickSort1<>();
    private static AbstractSortOnComparisons<SimpleInteger> quickSort2 = new QuickSort2<>();
    private static AbstractSortOnComparisons<SimpleInteger> mergeSort = new MergeSort<>();
    private static AbstractSortOnComparisons<SimpleInteger> heapSort = new HeapSort<>();
    private static LSDSort<SimpleInteger> lsdSort = new LSDSort<>();

    private SimpleInteger[][] data;
    private SimpleInteger[] curr;
    private int index;
    private int[] size = {10, 1000};

    @Setup(value = Level.Trial)
    public void setUpTrial(){
        data = new SimpleInteger[size[0]][size[1]];
        //рандомные данные
        data[0] = SortUtils.generateRandomDateSimpleInteger(size[1]);
        //Все элементы уникальные
        data[1] = SortUtils.generateUniqueDateSimpleInteger(size[1]);
        //Много повторяющихся
        data[2] = SortUtils.generateRepetitiveArraySimpleInteger(size[1]);
        //Отсортированный массив
        data[3] = SortUtils.generateSortedArraySimpleInteger(size[1]);
        //Зеркально отсортированный массив
        data[4] = SortUtils.generateMirrorArraySimpleInteger(size[1]);
        //Анти QuickSSort
        data[5] = SortUtils.generateAntiQSortSimpleInteger(size[1]);

    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureQuickSort1(){
        quickSort1.sort(curr);
    }

    @Benchmark
    public void measureQuickSort2(){
        quickSort2.sort(curr);
    }

    @Benchmark
    public void measureMergeSort(){
        mergeSort.sort(curr);
    }

    @Benchmark
    public void measureHeapSort(){
        heapSort.sort(curr);
    }

    @Benchmark
    public void measureLSDSort(){
        lsdSort.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SimpleIntegerSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

}
