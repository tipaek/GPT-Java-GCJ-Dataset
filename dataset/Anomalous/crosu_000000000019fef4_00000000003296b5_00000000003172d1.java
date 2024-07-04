import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testC.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double value, int digits) {
        double scale = Math.pow(10, digits);
        return Math.round(value * scale) / scale;
    }

    public static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    public static void nextCase(int caseNum) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        HashMap<Long, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long l = scanner.nextLong();
            counts.put(l, counts.getOrDefault(l, 0) + 1);
        }

        int answer;
        boolean found2Equal = false;
        boolean found3Equal = false;
        boolean foundDouble = false;
        long min2Equal = Long.MAX_VALUE;
        long maxSize = Long.MIN_VALUE;

        for (Map.Entry<Long, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            long l = entry.getKey();

            maxSize = Math.max(maxSize, l);

            if (count >= 2) {
                found2Equal = true;
                min2Equal = Math.min(min2Equal, l);
            }

            if (count >= 3) {
                found3Equal = true;
            }
        }

        for (long l : counts.keySet()) {
            if (counts.containsKey(l * 2)) {
                foundDouble = true;
                break;
            }
        }

        if (d == 2) {
            answer = found2Equal ? 0 : 1;
        } else if (d == 3) {
            if (found3Equal) {
                answer = 0;
            } else if (foundDouble || (found2Equal && min2Equal < maxSize)) {
                answer = 1;
            } else {
                answer = 2;
            }
        } else {
            throw new RuntimeException("Unsupported case for d: " + d);
        }

        writer.print("Case #" + caseNum + ": " + answer);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            nextCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}