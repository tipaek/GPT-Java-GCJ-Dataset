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

    private static void solve(long testCaseNumber) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] kPartition = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            kPartition[i - 1] = i;
            sum += i;
        }

        int currentIndex = n - 1;
        while (sum != k && currentIndex > 0) {
            if (k > sum) {
                kPartition[currentIndex]++;
                sum++;
                if (kPartition[currentIndex] == n) currentIndex--;
            } else {
                kPartition[currentIndex]--;
                sum--;
                if (kPartition[currentIndex] == 1) currentIndex--;
            }
        }
        Arrays.sort(kPartition);

        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            square[i][i] = kPartition[i];
        }

        boolean isPossible = false;
        boolean noMorePartitions = false;

        while (!(isPossible = fillSquare(square, n)) && !noMorePartitions) {
            noMorePartitions = getNextPartition(kPartition);
        }

        if (isPossible) {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            printSquare(square);
        } else {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }

    static boolean fillSquare(int[][] square, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    boolean found = false;
                    for (int x = 1; x <= n; x++) {
                        found = false;
                        for (int r = 0; r < n; r++) {
                            if (square[i][r] == x) {
                                found = true;
                                break;
                            }
                        }
                        for (int c = 0; c < n; c++) {
                            if (square[c][j] == x) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            square[i][j] = x;
                            break;
                        }
                    }
                    if (found) return false;
                }
            }
        }
        return true;
    }

    static boolean getNextPartition(int[] partition) {
        if (partition[partition.length - 1] - partition[0] == 1 || partition[partition.length - 1] == partition[0]) {
            return true;
        }
        int lowest = partition[0];
        int i = 0;
        for (; i < partition.length - 1; i++) {
            if (partition[i] > lowest) {
                break;
            }
        }
        partition[partition.length - 1]--;
        partition[i - 1]++;
        return false;
    }

    static void printSquare(int[][] square) {
        for (int[] row : square) {
            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print(row[row.length - 1]);
            System.out.println();
        }
    }
}