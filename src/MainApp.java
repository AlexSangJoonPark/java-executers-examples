import common.AtomicNumberCount;
import common.INumberCount;
import common.SyncNumberCount;
import common.TaskRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharki on 2016. 4. 28..
 */
public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        long startTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        System.out.println("main is started...");

        INumberCount numberCount = new AtomicNumberCount();
//        numberCount = new SyncNumberCount();
//        numberCount = new NonSyncNumberCount();

        ExecutorService exeService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            exeService.execute(new TaskRunner(numberCount));
        }

        exeService.shutdown();

        // wait until all threads finished
        while (!exeService.isTerminated()) {}

        long endTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        long elapsedTime = endTime - startTime;
        System.out.println("main is finished..." + elapsedTime + " millis");


    }


}
