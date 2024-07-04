

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    public static class Pair {

        public int startTime;
        public int endTime;
        public int dura;
        public String name;
        public int stt;

        public Pair(int stt, int startTime, int endTime) {
            this.stt = stt;
            this.startTime = startTime;
            this.endTime = endTime;
            this.dura = endTime - startTime;
            this.name = "";
        }
    }

    public static String solve(Pair startPair, List<Pair> pairs) {
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(final Pair object1, final Pair object2) {
                return object1.endTime - object2.endTime;
            }
        });
//        Pair taifCCC = startPair;
        Pair taifCCC = null;

        for (Pair pair : pairs) {
            if (taifCCC == null) {
                pair.name = "C";
                taifCCC = pair;
            }
            if (pair.name.isEmpty()) {
                if (taifCCC.endTime <= pair.startTime) {
                    pair.name = "C";
                    taifCCC = pair;
                }
            }
        }
        Pair taifJJ = null;
        for (Pair pair : pairs) {
            if (taifJJ == null && pair.name.isEmpty()) {
                pair.name = "J";
                taifJJ = pair;
            }
            if (pair.name.isEmpty()) {
                if (taifJJ.endTime <= pair.startTime) {
                    pair.name = "J";
                    taifJJ = pair;
                }
            }
        }

//        for (Pair pair : pairs) {
//            if (pair.startTime == startPair.startTime && pair.endTime == startPair.endTime) {
//                continue;
//            }
//            if (taifCCC.endTime <= pair.startTime) {
//                if (taifJJ != null && taifJJ.endTime <= pair.startTime) {
//                    if (taifCCC.endTime < taifJJ.endTime) {
//                        pair.name = "J";
//                        taifJJ = pair;
//                    } else {
//                        pair.name = "C";
//                        taifCCC = pair;
//                    }
//
//                } else {
//                    pair.name = "C";
//                    taifCCC = pair;
//                }
//            } else {
//                pair.name = "J";
//                if (taifJJ == null) {
//                } else {
//                    if (taifJJ.endTime <= pair.startTime) {
//                    } else {
//                        return "IMPOSSIBLE";
//                    }
//                }
//                taifJJ = pair;
//            }
//        }
//        Collections.sort(pairs, new Comparator<Pair>() {
//            @Override
//            public int compare(final Pair object1, final Pair object2) {
//                return object1.stt - object2.stt;
//            }
//        });
        String ret = "";
        for (Pair pair : pairs) {
            if (pair.name.isEmpty()) {
                return "IMPOSSIBLE";
            }
            ret += pair.name;
        }
        return ret;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                List<Pair> pairs = new ArrayList<>();

                int numActiviti = scanner.nextInt();
                Pair pair = new Pair(0, 9999999, 0);
                for (int i = 0; i < numActiviti; i++) {
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();
                    Pair tmp = new Pair(i, startTime, endTime);
                    if (startTime < pair.startTime) {
                        pair = tmp;
                    }
                    pairs.add(tmp);
                }
//                pair.name = "C";
                System.out.println("Case #" + testNumber + ": " + solve(pair, pairs));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
