import java.util.*;
import java.io.*;

/**
 * Solution
 */
public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            solve(caseNumber);
        }
    }

    private static void solve(long caseNumber) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

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
            noMorePartitions = generateNextPartition(kPartition);
            for (int i = 0; i < n; i++) {
                square[i][i] = kPartition[i];
            }
        }

        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printSquare(square);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
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

    static boolean generateNextPartition(int[] partition) {
        if (partition[partition.length - 1] - partition[0] == 1 || partition[partition.length - 1] == partition[0]) {
            return true;
        }
        int minValue = partition[0];
        int i = 0, j = 0;
        for (; i < partition.length - 1; i++) {
            if (partition[i] > minValue) {
                break;
            }
        }
        for (j = i; j < partition.length; j++) {
            if (partition[j] - minValue > 1) {
                break;
            }
        }
        partition[j]--;
        partition[i - 1]++;
        return false;
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printSquare(int[][] square) {
        for (int[] row : square) {
            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print(row[row.length - 1]);
            System.out.println();
        }
    }
}