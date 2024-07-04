import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            processCase(caseNum);
        }
    }

    private static void processCase(long caseNum) {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] partition = initializePartition(n, k);
        int[][] square = initializeSquare(n, partition);

        if (tryToFillSquare(square, n)) {
            System.out.println("Case #" + caseNum + ": POSSIBLE");
            printSquare(square);
        } else {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
        }
    }

    private static int[] initializePartition(int n, int k) {
        int[] partition = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            partition[i] = i + 1;
            sum += partition[i];
        }

        int index = n - 1;
        while (sum != k && index > 0) {
            if (k > sum) {
                partition[index]++;
                sum++;
                if (partition[index] == n) index--;
            } else {
                partition[index]--;
                sum--;
                if (partition[index] == 1) index--;
            }
        }
        Arrays.sort(partition);
        return partition;
    }

    private static int[][] initializeSquare(int n, int[] partition) {
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            square[i][i] = partition[i];
        }
        return square;
    }

    private static boolean tryToFillSquare(int[][] square, int n) {
        boolean possible = false;
        boolean exhaustedPartitions = false;

        while (!(possible = fillSquare(square, n)) && !exhaustedPartitions) {
            exhaustedPartitions = !generateNextPartition(square);
        }

        return possible;
    }

    private static boolean fillSquare(int[][] square, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (!tryToPlaceValue(square, n, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean tryToPlaceValue(int[][] square, int n, int row, int col) {
        for (int value = 1; value <= n; value++) {
            if (isValueValid(square, n, row, col, value)) {
                square[row][col] = value;
                return true;
            }
        }
        return false;
    }

    private static boolean isValueValid(int[][] square, int n, int row, int col, int value) {
        for (int i = 0; i < n; i++) {
            if (square[row][i] == value || square[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean generateNextPartition(int[][] square) {
        int[] partition = new int[square.length];
        for (int i = 0; i < square.length; i++) {
            partition[i] = square[i][i];
        }
        if (partition[partition.length - 1] - partition[0] <= 1) {
            return false;
        }
        int minValue = partition[0];
        int i;
        for (i = 0; i < partition.length - 1; i++) {
            if (partition[i] > minValue) {
                break;
            }
        }
        partition[partition.length - 1]--;
        partition[i - 1]++;
        Arrays.sort(partition);
        for (int j = 0; j < partition.length; j++) {
            square[j][j] = partition[j];
        }
        return true;
    }

    private static void printSquare(int[][] square) {
        for (int[] row : square) {
            for (int j = 0; j < row.length; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }
}