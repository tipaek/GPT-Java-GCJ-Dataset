import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testB.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String s) {
        if (DEBUG) {
            writer.println(s);
        }
    }

    private static void debugPrint(String s) {
        if (DEBUG) {
            writer.print(s);
        }
    }

    private static long now() {
        return System.nanoTime();
    }

    private static double round(double value, int sigDigits) {
        double scale = Math.pow(10, sigDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) +
                " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    private static void nextCase(int a, int b) {
        long lowerBound = (long) Math.pow(10, 9) - 10;
        long upperBound = (long) Math.pow(10, 9) + 10;
        outerLoop:
        for (long i = lowerBound; i <= upperBound; i++) {
            for (long j = lowerBound; j <= upperBound; j++) {
                writer.println(i + " " + j);
                writer.flush();
                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    break outerLoop;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            nextCase(a, b);
        }

        writer.close();
        scanner.close();
    }
}