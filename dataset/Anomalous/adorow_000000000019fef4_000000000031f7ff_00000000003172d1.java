import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static PrintStream output;

    private static final String CASE_PREFIX = "Case #";
    private static final String CASE_SEPARATOR = ": ";

    public static void main(String[] args) throws Throwable {
        scanner = new Scanner(System.in);
        // scanner = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/C/C.in"));
        output = System.out;
        // output = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int testCases = scanner.nextInt();
        long[] array = new long[10001];

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
            }

            Arrays.sort(array, 0, n);

            output.print(CASE_PREFIX);
            output.print(t);
            output.print(CASE_SEPARATOR);

            output.print(computeResult(array, n, d));

            output.println();
        }
        output.flush();
    }

    private static int computeResult(long[] array, int n, int d) {
        if (containsSequence(array, n, d)) {
            return 0;
        }

        // Only applicable for D=3
        if (containsNonLargestSequence(array, n, d - 1)) {
            return 1;
        }
        // Only applicable for D=3
        if (containsDoubleSizeSlice(array, n)) {
            return 1;
        }

        // Worst case scenario
        return d - 1;
    }

    private static boolean containsDoubleSizeSlice(long[] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (array[i] * 2 == array[j]) return true;
                if (array[i] * 2 > array[j]) break;
            }
        }
        return false;
    }

    private static boolean containsNonLargestSequence(long[] array, int n, int d) {
        for (int i = 0; i < n - d + 1; i++) {
            if (array[i] == array[i + d - 1] && array[i] != array[n - 1]) return true;
        }
        return false;
    }

    private static boolean containsSequence(long[] array, int n, int d) {
        for (int i = 0; i < n - d + 1; i++) {
            if (array[i] == array[i + d - 1]) return true;
        }
        return false;
    }
}