import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }
                    matrix[row][col] = value;
                }
            }

            // Check for repeated elements in rows
            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    repeatedRows++;
                }
            }

            // Check for repeated elements in columns
            for (int col = 0; col < n; col++) {
                int[] columnArray = new int[n];
                for (int row = 0; row < n; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (hasDuplicates(columnArray)) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}