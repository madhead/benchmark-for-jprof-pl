package b.f.j.p;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@Fork(3)
@Warmup(iterations = 3)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
public class JprofBenchmark {
    @Param({"1", "2", "5", "10", "20", "50", "100"})
    public int levelsNumber;

    public String LEVEL = "LEVEL";

    @Benchmark
    public void b1(Blackhole gloryHole) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int level = 1; level <= levelsNumber; level++) {
            gloryHole.consume(stringBuilder.append(LEVEL).append(level).toString());
            stringBuilder.setLength(0);
        }
    }

    @Benchmark
    public void b2(Blackhole gloryHole) {
        for (int level = 1; level <= levelsNumber; level++) {
            gloryHole.consume(LEVEL + level);
        }
    }
}
