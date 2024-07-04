import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, n);
            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                }
            }

            int expectedSum = calculateSum(n);
            int duplicateRows = countDuplicates(rowSums, expectedSum);
            int duplicateCols = countDuplicates(colSums, expectedSum);

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    private static int countDuplicates(int[] sums, int expectedSum) {
        int duplicates = 0;
        for (int sum : sums) {
            if (sum != expectedSum) {
                duplicates++;
            }
        }
        return duplicates;
    }
}