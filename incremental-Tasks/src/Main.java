import com.sun.jdi.Value;

public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);
        IncrementTask incrementTask = new IncrementTask(accumulator);
        incrementTask.run();
        System.out.println(accumulator.getValue());
    }
}