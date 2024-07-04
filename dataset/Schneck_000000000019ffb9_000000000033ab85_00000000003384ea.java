import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        long L = scan.nextLong();
        long R = scan.nextLong();
        long equalizer = findEqualizer(Math.abs(L-R));
//        System.err.println(equalizer);
        if (R > L) R -= sum(1, equalizer, 1);
        else L -= sum(1, equalizer, 1);
//        System.err.println(L + " " + R);
        long lStart, rStart;
        if (L >= R) {
            lStart = equalizer + 1;
            rStart = equalizer + 2;
        } else {
            lStart = equalizer + 2;
            rStart = equalizer + 1;
        }
//        System.err.println(lStart + " " + rStart);
        long lMax = findMax(L, lStart);
        long rMax = findMax(R, rStart);
        long customers;
        if (lMax > rMax) {
            lMax = rMax + 1;
            customers = lMax;
        } else {
            rMax = lMax + 1;
            customers = rMax;
        }
//        System.err.println(lMax + " " + rMax);
        L -= sum(lStart, lMax, 2);
        R -= sum(rStart, rMax, 2);
        System.out.println(customers + " " + L + " " + R);
    }

    private long findMax(long amount, long start) {
        return binarySearch(start, amount, 2);
    }

    private long findEqualizer(long amount) {
        return binarySearch(1, amount, 1);
    }

    private long binarySearch(long start, long amount, int delta) {
        // want max such that sum(start, max, delta) <= amount but sum(start, max+delta, delta) > amount
        if (sum(start, start, delta) > amount) return 0;
        if (sum(start, start+delta, delta) > amount) return start;
        long maxDeltas = (amount - start) / delta;
        if (sum(start, start + maxDeltas*delta, delta) <= amount) return start + maxDeltas*delta;
        return binarySearch(start, amount, delta, 0, maxDeltas);
    }

    private long binarySearch(long start, long amount, int delta, long minDeltas, long maxDeltas) {
        long trialDeltas = (minDeltas + maxDeltas) / 2;
        long trial = start + trialDeltas * delta;
        if (sum(start, trial, delta) > amount) {
            return binarySearch(start, amount, delta, minDeltas, trialDeltas);
        }
        if (sum(start, trial+delta, delta) > amount) {
            return trial;
        }
        return binarySearch(start, amount, delta, trialDeltas, maxDeltas);
    }

    private long sum(long start, long max, int delta) {
        if (max == 0) return 0;
        long count = (max - start) / delta + 1;
        long dblAvg = (max + start);
        return count * dblAvg / 2;
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}