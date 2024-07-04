import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testA.in";

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
        debugPrintln("Ms elapsed: " + roundToSignificantDigits(elapsedTime * millisecondsPerNanosecond, 4) + " (" + roundToSignificantDigits(start * millisecondsPerNanosecond, 4) + ", " + roundToSignificantDigits(end * millisecondsPerNanosecond, 4) + ")");
    }

    private static void processCase(int caseNumber) {
        int n = scanner.nextInt();
        int trace = 0;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
            }
        }

        int duplicateRowCount = 0;
        int duplicateColumnCount = 0;
        HashSet<Integer> uniqueValues = new HashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueValues.clear();

            for (int j = 0; j < n; j++) {
                int rowValue = matrix[i][j];
                if (!uniqueValues.add(rowValue)) {
                    duplicateRowCount++;
                    break;
                }
            }

            uniqueValues.clear();
            for (int j = 0; j < n; j++) {
                int colValue = matrix[j][i];
                if (!uniqueValues.add(colValue)) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }

        writer.printf("Case #%d: %d %d %d", caseNumber, trace, duplicateRowCount, duplicateColumnCount);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            processCase(i + 1);
            if (i < testCaseCount - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}