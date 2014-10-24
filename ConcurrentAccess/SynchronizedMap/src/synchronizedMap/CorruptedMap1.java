package synchronizedMap;

import java.util.Map;
import java.util.Random;

/**
 *
 * Created by ksolodovnik on 10/22/14.
 */
public class CorruptedMap1 implements Runnable{

    Map<Integer,Integer> map;

    Random r = new Random();

    /** Constructor */
    public CorruptedMap1(Map<Integer, Integer> mainMap) {
        map = mainMap;    // map - synchronized map
    }

    /**
     * Overriding method which performs getting and
     * putting entries to the synchronized map.
     * Methods put and get are synchronized.
     */
    public void run() {
        // Random number
        int del = r.nextInt(1000);

        //only one thread can perform this block of code
        synchronized (map) {
            for (Integer key : map.keySet()) {
                //   System.out.println(map.get(del+1));
            }

            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }

            for (int i = 0; i < 1000; i++) {
                // 	System.out.println(map.get(i));
            }
        }
    }
}
