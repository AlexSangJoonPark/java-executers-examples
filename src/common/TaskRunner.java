package common;

import java.util.concurrent.TimeUnit;

public class TaskRunner implements Runnable {

    private INumberCount numberCount;
    public TaskRunner(INumberCount numberCount) {
        this.numberCount = numberCount;
    }

    @Override
    public void run() {
        int returnInt = numberCount.incrementAndGet();
//        CheckDupNumber.checkDup(returnInt);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : \t" + returnInt);
    }

}
