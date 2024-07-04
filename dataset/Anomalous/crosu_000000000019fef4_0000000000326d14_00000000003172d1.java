import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static boolean debug = false;
    private static boolean fromFile = false;
    private static String inputFile = "testC.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String message) {
        if (debug) {
            writer.println(message);
        }
    }

    private static void debugPrint(String message) {
        if (debug) {
            writer.print(message);
        }
    }

    private static long now() {
        return System.nanoTime();
    }

    private static double round(double value, int significantDigits) {
        double scale = Math.pow(10, significantDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double millisecondsPerNanosecond = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * millisecondsPerNanosecond, 4) + " (" + round(start * millisecondsPerNanosecond, 4) + ", " + round(stop * millisecondsPerNanosecond, 4) + ")");
    }

    private static void nextCase(int caseNumber) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] sizes = new long[n];
        HashMap<Long, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long size = scanner.nextLong();
            sizes[i] = size;
            counts.put(size, counts.getOrDefault(size, 0) + 1);
        }

        String answer = "";

        boolean foundEqual = false;
        boolean foundDouble = false;

        for (int count : counts.values()) {
            if (count >= d) {
                foundEqual = true;
                break;
            }
        }

        if (!foundEqual) {
            for (long size : counts.keySet()) {
                if (counts.containsKey(size * 2)) {
                    foundDouble = true;
                    break;
                }
            }
        }

        if (foundEqual) {
            answer = "0";
        } else if (d == 2 || foundDouble) {
            answer = "1";
        } else {
            answer = "2";
        }

        writer.print("Case #" + caseNumber + ": " + answer);
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