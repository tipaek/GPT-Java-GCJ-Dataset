import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testC.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String message) {
        if (DEBUG) {
            writer.println(message);
        }
    }

    private static void debugPrint(String message) {
        if (DEBUG) {
            writer.print(message);
        }
    }

    private static long currentTime() {
        return System.nanoTime();
    }

    private static double roundToSignificantDigits(double value, int significantDigits) {
        double scale = Math.pow(10, significantDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printElapsedTime(long start, long end) {
        long elapsedTime = end - start;
        double millisecondsPerNanosecond = 1e-6;
        debugPrintln("Milliseconds elapsed: " + roundToSignificantDigits(elapsedTime * millisecondsPerNanosecond, 4) + 
                     " (" + roundToSignificantDigits(start * millisecondsPerNanosecond, 4) + ", " + 
                     roundToSignificantDigits(end * millisecondsPerNanosecond, 4) + ")");
    }

    private static void processCase(int caseNumber) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        HashMap<Long, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long number = scanner.nextLong();
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int answer;
        boolean hasTwoEqual = false;
        boolean hasThreeEqual = false;
        boolean hasDouble = false;
        int minTwoEqual = Integer.MAX_VALUE;
        int maxSize = 0;

        for (int count : counts.values()) {
            maxSize = Math.max(maxSize, count);

            if (count >= 2) {
                hasTwoEqual = true;
                minTwoEqual = Math.min(minTwoEqual, count);
            }

            if (count >= 3) {
                hasThreeEqual = true;
            }
        }

        for (long key : counts.keySet()) {
            if (counts.containsKey(key * 2)) {
                hasDouble = true;
                break;
            }
        }

        if (d == 2) {
            answer = hasTwoEqual ? 0 : 1;
        } else if (d == 3) {
            if (hasThreeEqual) {
                answer = 0;
            } else if (hasDouble || (hasTwoEqual && minTwoEqual < maxSize)) {
                answer = 1;
            } else {
                answer = 2;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported case for d = " + d);
        }

        writer.print("Case #" + caseNumber + ": " + answer);
    }

    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            processCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}