public class Accumulator extends Thread {
    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increment(int value) {
        this.value = value + 1;
    }
}
