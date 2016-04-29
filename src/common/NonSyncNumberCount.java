package common;

import java.util.concurrent.TimeUnit;

public class NonSyncNumberCount implements INumberCount {
    private static int count = 0;

    public int incrementAndGet() {
        count = count + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}