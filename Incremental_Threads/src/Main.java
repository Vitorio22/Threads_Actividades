import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);
        LinkedList<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(new IncrementalTask(accumulator, 1000));
            thread1.start();
            threads.add(thread1);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accumulator.getValue());
    }
}