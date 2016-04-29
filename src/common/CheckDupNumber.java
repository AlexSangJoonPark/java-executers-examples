package common;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by sharki on 2016. 4. 29..
 */
public class CheckDupNumber {

    private static Set set = new ConcurrentSkipListSet();

    public static synchronized void checkDup(int number) {
        if (set.contains(number)) {
            throw new RuntimeException("Duplicated number : " + number);
        }

        set.add(number);
    }
}
