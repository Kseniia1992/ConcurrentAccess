package corruptedMapSynch;

import java.util.HashMap;

/**
 * Class creates threads
 * Created by ksolodovnik on 10/22/14.
 */
public class ThreadTest {

    static HashMap<Integer,Integer> mainMap ;

    public static void main(String[] args) {
        mainMap = new HashMap<Integer, Integer>();
        Runnable runMap = new CorruptedMap1(mainMap);
        //Creating of 1000 threads
        for (int i = 0; i < 1000; i++) {
            new Thread(runMap, "Thread " + i).start();
        }

    }
}
