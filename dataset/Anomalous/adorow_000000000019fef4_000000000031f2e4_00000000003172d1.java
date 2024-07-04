import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final String CASE_PREFIX = "Case #";
    private static final String SEPARATOR = ": ";
    private static final int MAX_SIZE = 10001;

    private static Scanner in;
    private static PrintStream out;

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        // in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/C/C.in"));
        out = System.out;
        // out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();
        long[] A = new long[MAX_SIZE];

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int D = in.nextInt();
            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            Arrays.sort(A, 0, N);

            out.print(CASE_PREFIX);
            out.print(t);
            out.print(SEPARATOR);
            out.print(solve(A, N, D));
            out.println();
        }
        out.flush();
    }

    private static int solve(long[] a, int n, int d) {
        if (hasSequence(a, n, d)) {
            return 0;
        }

        if (d == 3) {
            if (hasSequenceOfNotLargest(a, n, d - 1) || hasASliceDoubleTheSize(a, n)) {
                return 1;
            }
        }

        return d - 1;
    }

    private static boolean hasASliceDoubleTheSize(long[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[i] * 2 == a[j]) return true;
                if (a[i] * 2 > a[j]) break;
            }
        }
        return false;
    }

    private static boolean hasSequenceOfNotLargest(long[] a, int n, int d) {
        for (int i = 0; i < n - d; i++) {
            if (a[i] == a[i + d - 1] && a[i] != a[n - 1]) return true;
        }
        return false;
    }

    private static boolean hasSequence(long[] a, int n, int d) {
        for (int i = 0; i < n - d; i++) {
            if (a[i] == a[i + d - 1]) return true;
        }
        return false;
    }
}