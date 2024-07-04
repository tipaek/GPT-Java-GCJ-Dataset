import java.util.*;
import java.io.*;

class Solution {

    public static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    public static int countNonMatchingElements(int[] arr, int expectedSum) {
        int count = 0;
        for (int value : arr) {
            if (value != expectedSum) {
                count++;
            }
        }
        return count;
    }

    public static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, n);

            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int expectedSum = calculateSum(n);
            int rowsWithDup = countNonMatchingElements(rowSums, expectedSum);
            int colsWithDup = countNonMatchingElements(colSums, expectedSum);

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowsWithDup + " " + colsWithDup);
        }
        scanner.close();
    }
}