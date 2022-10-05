public class IncrementTask  {

    private Accumulator accumulator;


    public IncrementTask(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            accumulator.increment(accumulator.getValue());
        }
    }
}
