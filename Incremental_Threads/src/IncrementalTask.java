public class IncrementalTask implements Runnable {
    private Accumulator accumulator;
    private int times;

    public IncrementalTask(Accumulator accumulator, int times) {
        this.accumulator = accumulator;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            accumulator.increment();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
