package concurrentMapTask;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by ksolodovnik on 10/22/14.
 */
public class CorruptedMap1 implements Runnable{

    ConcurrentHashMap<Integer,Integer> map;

    Random r = new Random();

    /** Constructor */
    public CorruptedMap1(ConcurrentHashMap<Integer, Integer> mainMap) {

        map=mainMap;
    }

    /**
     * Overriding method which performs getting
     * and putting entries to the concurrent map
     *
     */
    public void run() {

            // Random number
            int del = r.nextInt(1000);

            for (Integer key : map.keySet()) {
                //   		System.out.println(map.get(del+1));
            }

            for (int i = 0; i < 1000; i++) {
                map.put(i, i);
            }

            for (int i = 0; i < 1000; i++) {
                //  		System.out.println(map.get(i));
            }
    }
}
