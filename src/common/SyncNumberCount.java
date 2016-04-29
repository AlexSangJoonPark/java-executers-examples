package common;

import java.util.concurrent.TimeUnit;

public class SyncNumberCount implements INumberCount {
    private static volatile int count = 0;

    public synchronized int incrementAndGet() {
        count = count + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}