import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long testCase) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] kp = initializeKPartition(n);
        int sumSoFar = Arrays.stream(kp).sum();

        adjustKPartition(k, kp, sumSoFar);

        int[][] sq = initializeSquare(n, kp);

        boolean possible = false;
        boolean outOfKPartitions = false;

        while (!(possible = fillSquare(sq, n)) && !outOfKPartitions) {
            outOfKPartitions = getNextKPartition(kp);
            sq = initializeSquare(n, kp);
        }

        printResult(testCase, possible, sq);
    }

    private static int[] initializeKPartition(int n) {
        int[] kp = new int[n];
        for (int i = 0; i < n; i++) {
            kp[i] = i + 1;
        }
        return kp;
    }

    private static void adjustKPartition(int k, int[] kp, int sumSoFar) {
        if (k > sumSoFar) {
            adjustUp(k, kp, sumSoFar);
        } else if (k < sumSoFar) {
            adjustDown(k, kp, sumSoFar);
        }
    }

    private static void adjustUp(int k, int[] kp, int sumSoFar) {
        int index = kp.length - 1;
        while (k > sumSoFar && index >= 0) {
            if (kp[index] < kp.length) {
                kp[index]++;
                sumSoFar++;
            } else {
                index--;
            }
        }
        Arrays.sort(kp);
    }

    private static void adjustDown(int k, int[] kp, int sumSoFar) {
        int index = 0;
        while (k < sumSoFar && index < kp.length) {
            if (kp[index] > 1) {
                kp[index]--;
                sumSoFar--;
            } else {
                index++;
            }
        }
        Arrays.sort(kp);
    }

    private static int[][] initializeSquare(int n, int[] kp) {
        int[][] sq = new int[n][n];
        for (int i = 0; i < n; i++) {
            sq[i][i] = kp[i];
        }
        return sq;
    }

    private static boolean fillSquare(int[][] sq, int n) {
        int r = -1, c = -1;
        boolean filled = true;

        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sq[i][j] == 0) {
                    r = i;
                    c = j;
                    filled = false;
                    break outerLoop;
                }
            }
        }

        if (filled) return true;

        for (int x = 1; x <= n; x++) {
            if (isValid(sq, r, c, x)) {
                sq[r][c] = x;
                if (fillSquare(sq, n)) return true;
                sq[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] sq, int row, int col, int x) {
        for (int c = 0; c < sq.length; c++) {
            if (sq[row][c] == x) return false;
        }

        for (int r = 0; r < sq.length; r++) {
            if (sq[r][col] == x) return false;
        }
        return true;
    }

    private static boolean getNextKPartition(int[] kp) {
        if (kp[kp.length - 1] - kp[0] <= 1) return true;

        int lowest = kp[0];
        int i = 0, j = 0;

        for (; i < kp.length - 1; i++) {
            if (kp[i] > lowest) break;
        }

        for (j = i; j < kp.length; j++) {
            if (kp[j] - lowest > 1) break;
        }

        kp[j]--;
        kp[i - 1]++;
        return false;
    }

    private static void printResult(long testCase, boolean possible, int[][] sq) {
        if (possible) {
            System.out.println("Case #" + testCase + ": POSSIBLE");
            printSquare(sq);
        } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
    }

    private static void printSquare(int[][] sq) {
        for (int[] row : sq) {
            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println(row[row.length - 1]);
        }
    }
}