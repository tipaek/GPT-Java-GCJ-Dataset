import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testB.in";

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

    private static long getCurrentTime() {
        return System.nanoTime();
    }

    private static double roundToSignificantDigits(double value, int significantDigits) {
        double scale = Math.pow(10, significantDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printElapsedTime(long start, long end) {
        long elapsed = end - start;
        double millisecondsPerNanosecond = 1e-6;
        debugPrintln("Elapsed time (ms): " + roundToSignificantDigits(elapsed * millisecondsPerNanosecond, 4) +
                " (" + roundToSignificantDigits(start * millisecondsPerNanosecond, 4) + ", " + roundToSignificantDigits(end * millisecondsPerNanosecond, 4) + ")");
    }

    private static void processCase(int a, int b) {
        boolean foundCenter = false;
        long searchStart = (long) (Math.pow(10, 9) - 10);
        long searchEnd = (long) (Math.pow(10, 9) + 10);

        for (long x = searchStart; x <= searchEnd; x++) {
            for (long y = searchStart; y <= searchEnd; y++) {
                writer.println(x + " " + y);
                writer.flush();
                String response = scanner.next();

                if ("CENTER".equals(response)) {
                    foundCenter = true;
                    break;
                }
            }
            if (foundCenter) break;
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processCase(a, b);
        }

        writer.close();
        scanner.close();
    }
}