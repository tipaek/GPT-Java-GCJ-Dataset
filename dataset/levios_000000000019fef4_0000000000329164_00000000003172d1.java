
import java.io.*;
import java.util.*;

/**
 * Round 1C - Code Jam 2020
 * C.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1c\\C\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int n, d;
    static long SUM = (long)(360 * Math.pow(10,9));
    private static void solve() {
        n = in.nextInt();
        d = in.nextInt();
        long sum = 0;
        Map<Long, Integer> slices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long l = in.nextLong();
            sum += l;
            if (slices.containsKey(l)) {
               int count =  slices.get(l);
               slices.put(l, count+1);
            } else {
                slices.put(l, 1);
            }
        }

        long diff = SUM - sum;
        if (slices.containsKey(diff)) {
            int count =  slices.get(diff);
            slices.put(diff, count+1);
        } else {
            slices.put(diff, 1);
        }

        int max = maxUsingCollections(slices);

        if (d == 2) {
            if (max == 1) {
                print("1");
            } else {
                print("0");
            }
        } else if (d == 3) {
            if (max == 1) {
                if (isThereDouble(slices)) {
                    print("1");
                } else {
                    print("2");
                }
            } else if (max == 2) {
                if (slices.size() == 1) {
                    print("2");
                } else {
                    print("1");
                }
            } else {
                print("0");
            }
        } else {
            print("0");
        }

        //print("");
    }

    private static boolean isThereDouble(Map<Long, Integer> slices) {
        for (long k: slices.keySet()) {
            if (slices.containsKey(k / 2)) {
                return true;
            }
            if (slices.containsKey(k * 2)) {
                return true;
            }
        }
        return false;
    }

    public static <K, V extends Comparable<V>> V maxUsingCollections(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
        return maxEntry.getValue();
    }

    private static void print(String s) {
        out.println(s); out.flush();
        if (debug) System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN)); // new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            if (debug) System.out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
