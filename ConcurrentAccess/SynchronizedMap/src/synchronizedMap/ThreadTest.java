package synchronizedMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class creates threads
 * Created by ksolodovnik on 10/22/14.
 */
public class ThreadTest {

    static Map<Integer,Integer> mainMap ;

    /**
     * mainMap - synchronized map. One thread can work with mainMap
     * runMap - Runnable object
     */
    public static void main(String[] args) {
        mainMap = Collections.synchronizedMap(new HashMap<Integer, Integer>());
        Runnable runMap = new CorruptedMap1(mainMap);
        // creating of 1000 threads
        for (int i = 0; i < 1000; i++) {
            new Thread(runMap, "Thread " + i).start();
        }

    }
}
