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

    private static void printElapsedTime(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        double millisecondsPerNanosecond = 1e-6;
        debugPrintln("Milliseconds elapsed: " + roundToSignificantDigits(elapsedTime * millisecondsPerNanosecond, 4) +
                " (" + roundToSignificantDigits(startTime * millisecondsPerNanosecond, 4) + ", " +
                roundToSignificantDigits(endTime * millisecondsPerNanosecond, 4) + ")");
    }

    private static void processCase(int a, int b) {
        boolean foundCenter = false;
        long center = (long) Math.pow(10, 9);

        for (long x = center - 10; x <= center + 10; x++) {
            for (long y = center - 10; y <= center + 10; y++) {
                writer.println(x + " " + y);
                writer.flush();
                String response = scanner.next();
                scanner.next();

                if ("CENTER".equals(response)) {
                    foundCenter = true;
                    break;
                }
            }
            if (foundCenter) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
            writer = new PrintWriter(System.out);

            int testCases = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            for (int i = 0; i < testCases; i++) {
                processCase(a, b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}