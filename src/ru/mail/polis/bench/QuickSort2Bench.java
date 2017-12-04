package ru.mail.polis.bench;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.QuickSort2;

public class QuickSort2Bench extends BenchUtils {

    @Setup(value = Level.Trial)
    public void setUpTrial(){
        setUpInvocation(new QuickSort2<Integer>(),new QuickSort2<String>());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSort2Bench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
