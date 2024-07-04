import java.util.*;
import java.io.*;

public class Solution {

    private static int[][] x;
    private static int n = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int trace = in.nextInt();
            boolean isPossible = solve(size, trace);
            System.out.println("Case #" + i + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
            if (isPossible) {
                printMatrix();
            }
        }
    }

    private static boolean solve(int size, int trace) {
        int k = 0;
        n = size;
        initMatrix();
        while (!matches(trace)) {
            k++;
            if (k == n) {
                return false;
            }
            rearrangeMatrix();
        }
        return true;
    }

    private static boolean matches(int trace) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum1 += x[i][i];
            sum2 += x[j][i];
        }

        if (sum1 == trace) {
            return true;
        } else if (sum2 == trace) {
            flipMatrix();
            return true;
        } else {
            return false;
        }
    }

    private static void initMatrix() {
        int k = 1;
        x = new int[n][n];
        for (int i = 0; i < n; i++) {
            k = i + 1;
            for (int j = 0; j < n; j++) {
                k = k > n ? k % n : k;
                x[i][j] = k;
                k++;
            }
        }
    }

    private static void flipMatrix() {
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                tmp = x[i][j];
                x[i][j] = x[i][n - 1 - j];
                x[i][n - 1 - j] = tmp;
            }
        }
    }

    private static void rearrangeMatrix() {
        int tmp[][] = new int[n][n];
        for (int i = 1, k = 0; k < n; i++, k++) {
            i = i == n ? 0 : i;
            for (int j = 0; j < n; j++) {
                tmp[k][j] = x[i][j];
            }
        }
        x = tmp;
    }

    private static void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}