import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            solve(caseNumber);
        }
    }

    private static void solve(long caseNumber) {
        int n = scanner.nextInt(), k = scanner.nextInt();

        int[] partition = new int[n];
        int currentSum = 0;
        for (int i = 1; i <= n; i++) {
            partition[i - 1] = i;
            currentSum += i;
        }

        if (k > currentSum) {
            adjustPartition(partition, k, currentSum, n, true);
        } else if (k < currentSum) {
            adjustPartition(partition, k, currentSum, n, false);
        }

        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            square[i][i] = partition[i];
        }

        boolean isPossible = false;
        boolean noMorePartitions = false;

        while (!(isPossible = fillSquare(square, n)) && !noMorePartitions) {
            noMorePartitions = getNextPartition(partition);
            for (int i = 0; i < n; i++) {
                square[i][i] = partition[i];
            }
        }

        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printSquare(square);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void adjustPartition(int[] partition, int k, int currentSum, int n, boolean increase) {
        int index = increase ? n - 1 : 0;
        while (k != currentSum && index >= 0 && index < n) {
            if ((increase && partition[index] == n) || (!increase && partition[index] == 1)) {
                index = increase ? index - 1 : index + 1;
            } else {
                partition[index] += increase ? 1 : -1;
                currentSum += increase ? 1 : -1;
            }
        }
        Arrays.sort(partition);
    }

    private static boolean fillSquare(int[][] square, int n) {
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

    private static boolean getNextPartition(int[] partition) {
        if (partition[partition.length - 1] - partition[0] <= 1) {
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

    private static void printSquare(int[][] square) {
        for (int[] row : square) {
            for (int j = 0; j < square.length - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println(row[square.length - 1]);
        }
    }
}