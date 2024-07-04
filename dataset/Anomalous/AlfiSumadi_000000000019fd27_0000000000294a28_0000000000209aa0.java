import java.util.*;
import java.io.*;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long caseNumber) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] kp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            kp[i] = i + 1;
            sum += kp[i];
        }

        int index = n - 1;
        while (sum != k && index > 0) {
            if (k > sum) {
                kp[index]++;
                sum++;
                if (kp[index] == n) index--;
            } else {
                kp[index]--;
                sum--;
                if (kp[index] == 1) index--;
            }
        }
        Arrays.sort(kp);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = kp[i];
        }

        boolean possible = false;
        boolean noMorePartitions = false;

        while (!(possible = fillMatrix(matrix, n)) && !noMorePartitions) {
            noMorePartitions = nextPartition(kp);
        }

        if (possible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    static boolean fillMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    boolean found = false;
                    for (int x = 1; x <= n; x++) {
                        found = false;
                        for (int r = 0; r < n; r++) {
                            if (matrix[i][r] == x) {
                                found = true;
                                break;
                            }
                        }
                        for (int c = 0; c < n; c++) {
                            if (matrix[c][j] == x) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            matrix[i][j] = x;
                            break;
                        }
                    }
                    if (found) return false;
                }
            }
        }
        return true;
    }

    static boolean nextPartition(int[] kp) {
        int n = kp.length;
        if (kp[n - 1] - kp[0] <= 1) return true;
        int min = kp[0];
        int i = 0;
        while (i < n - 1 && kp[i] == min) {
            i++;
        }
        kp[n - 1]--;
        kp[i - 1]++;
        return false;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}