package common;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNumberCount implements INumberCount {
    private static AtomicInteger count = new AtomicInteger();

    public int incrementAndGet() {
        int curr, next;

        do {
            curr = count.get();
            next = curr + 1;
        } while (!count.compareAndSet(curr, next));

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return next;
    }
}